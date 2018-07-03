package com.example.jxmall.controller;

import com.example.jxmall.entity.Express;
import com.example.jxmall.entity.Inventory;
import com.example.jxmall.entity.Order_Items;
import com.example.jxmall.entity.Product;
import com.example.jxmall.repository.OrderRepository;
import com.example.jxmall.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private int Order_Mater_id;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;


    public OrderController() {
        Order_Mater_id = 1; //给定用户的id
    }

    /*创建订单*/
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createOrder(@RequestBody List<Product> products) {

        Order_Items order = new Order_Items();

        BigDecimal totalPrice = new BigDecimal(0);
        for (Product productItem : products) {

            //判断是否超出库存
            if (productItem.getLockedCount() + productItem.getPurchaseCount() <=
                    productItem.getTotalCount()) {

                //锁定库存数量
                productItem.setLockedCount(productItem.getLockedCount() + productItem.getPurchaseCount());

            } else {
                int count = productItem.getTotalCount() - productItem.getLockedCount();
                productItem.setPurchaseCount(count);
            }

            productRepository.save(productItem);

            order.addProduct(productItem);

            //计算总价
            totalPrice = totalPrice.add(productItem.getPrice().
                    multiply(new BigDecimal(productItem.getPurchaseCount())));

        }

        order.setId(Order_Mater_id);
        order.setTotalPrice(totalPrice);
        order.setCreateDate(new Date());
        order.setOrderStatus("unPaid");//设置订单状态

        orderRepository.save(order);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //更新订单的支付状态,支付或者撤销
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateOrderStatus(@PathVariable int id,
                                  @RequestParam("orderStatus") String orderStatus) {

        Order_Items order = orderRepository.findById(id).get();

        if (orderStatus == "paid") {//订单支付
            order.setPaidTime(new Date());
        } else if (orderStatus == "withdrawn") {//撤销订单
            order.setWithdrawnTime(new Date());

            Set<Product> products = order.getProducts();

            for (Product item : products) {

                Product product = productRepository.findById(item.getId()).get();
                product.setLockedCount(product.getLockedCount() - item.getPurchaseCount());
                productRepository.save(product);

            }
        }
        order.setOrderStatus(orderStatus);
        orderRepository.save(order);
    }

    //查询订单信息
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Order_Items getOrder(@PathVariable int id) {
        return orderRepository.findById(id).get();
    }

    //查询用户的所有订单信息
    @RequestMapping(params = {"userId"}, method = RequestMethod.GET)
    public List<Order_Items> getOrders(@RequestParam("userId") int userId) {

        List<Order_Items> orders = orderRepository.findByUserId(userId);

        return orders;
    }

    //物流记录
    @RequestMapping(value = "/logisticsRecords/{id}", method = RequestMethod.GET)
    public Express ExpressRecord(@PathVariable int id) {
        Order_Items order = orderRepository.findById(id).get();
        return new Express(order);
    }

    //更新物流信息
    @RequestMapping(value = "/logisticsRecords/{logisticId}/orders/{id}", params = {"logisticsStatus"}, method = RequestMethod.PUT)
    public void updateExpressStatus(@PathVariable int expressId,
                                    @PathVariable int id,
                                    @RequestParam("logisticsStatus") String logisticsStatus,
                                    HttpServletResponse response) {

        Order_Items order = orderRepository.findById(id).get();//获取订单

        if (logisticsStatus == "shipping") {//物流状态：运输中

            order.setOutboundTime(new Date());
            order.setOrderStatus("shipping");

        } else if (logisticsStatus == "signed") {//订单签收了

            order.setSignedTime(new Date());
            order.setOrderStatus("finished");

            Set<Product> products = order.getProducts();
            for (Product item : products) {

                Product product = productRepository.findById(item.getId()).get();
                product.setTotalCount(product.getTotalCount() - item.getPurchaseCount());
                product.setLockedCount(product.getLockedCount() - item.getPurchaseCount());
                productRepository.save(product);

            }
        }
        order.setExpressStatus(logisticsStatus);
        orderRepository.save(order);
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }

    //商品入库
    @RequestMapping(value = "/inventories/{id}", method = RequestMethod.PUT)
    public void addInventory(@PathVariable int id, @RequestBody Inventory inventory, HttpServletResponse response) {
        Product product = productRepository.findById(id).get();
        product.setTotalCount(product.getTotalCount() + inventory.getQuantity());
        productRepository.save(product);
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }
}
