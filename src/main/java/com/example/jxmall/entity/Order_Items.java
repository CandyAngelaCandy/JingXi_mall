package com.example.jxmall.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

//Order_Items记录一个订单中每项产品的详细信息
@Entity
public class Order_Items {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;//外键为Order_Mater_id(用户的id)和product_Id(产品的id);
    private int ProductId;

    private long userId;//用户 Id

    private String ProductName;
    private BigDecimal ItemPrice;
    private BigDecimal totalPrice;
    private int Quantity;
    private  String orderStatus;
    private Date CreateDate;
    private int CreateUser;
    private Date lastEditDate;
    private int lastEditUser;
    private Date paidTime; //支付时间
    private Date withdrawnTime; //撤销订单时间

    private String expressStatus;//物流状态
    private Date outboundTime;
    private Date signedTime;//签收时间
    private String deliveryMan;//运送的快递员

    //订单与产品是一对多的关系
    @OneToMany(mappedBy="order",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private Set<Product> products = new HashSet<>();

    public void addProduct(Product product){
        products.add(product);
        product.setOrder(this);
    }

    public String getExpressStatus() {
        return expressStatus;
    }

    public void setExpressStatus(String logisticsStatus) {
        this.expressStatus = logisticsStatus;
    }

    public Date getOutboundTime() {
        return outboundTime;
    }

    public void setOutboundTime(Date outboundTime) {
        this.outboundTime = outboundTime;
    }

    public Date getSignedTime() {
        return signedTime;
    }

    public void setSignedTime(Date signedTime) {
        this.signedTime = signedTime;
    }

    public String getDeliveryMan() {
        return deliveryMan;
    }

    public void setDeliveryMan(String deliveryMan) {
        this.deliveryMan = deliveryMan;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public Date getPaidTime() {
        return paidTime;
    }

    public void setPaidTime(Date paidTime) {
        this.paidTime = paidTime;
    }

    public Date getWithdrawnTime() {
        return withdrawnTime;
    }

    public void setWithdrawnTime(Date withdrawnTime) {
        this.withdrawnTime = withdrawnTime;
    }

    public Order_Items() {

    }

    public Order_Items(int id, int productId, String productName, BigDecimal itemPrice, int quantity, Date createDate,
                       int createUser, Date lastEditDate, int lastEditUser) {
        Id = id;
        ProductId = productId;
        ProductName = productName;
        ItemPrice = itemPrice;
        Quantity = quantity;
        CreateDate = createDate;
        CreateUser = createUser;
        this.lastEditDate = lastEditDate;
        this.lastEditUser = lastEditUser;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        ProductId = productId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public BigDecimal getItemPrice() {
        return ItemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        ItemPrice = itemPrice;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }

    public int getCreateUser() {
        return CreateUser;
    }

    public void setCreateUser(int createUser) {
        CreateUser = createUser;
    }

    public Date getLastEditDate() {
        return lastEditDate;
    }

    public void setLastEditDate(Date lastEditDate) {
        this.lastEditDate = lastEditDate;
    }

    public int getLastEditUser() {
        return lastEditUser;
    }

    public void setLastEditUser(int lastEditUser) {
        this.lastEditUser = lastEditUser;
    }
}
