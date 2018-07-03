package com.example.jxmall.controller;


import com.example.jxmall.entity.Product;
import com.example.jxmall.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    /*当添加商品时，输入商品的名称，描述，价格，系统应该创建商品，同时创建对应的库存数量为0*/
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity addProduct(@RequestBody Product product) {
       productRepository.save(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

   /* 当修改商品时，输入商品的名称，描述，价格，系统应该对商品信息进行修改。*/
   @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
   public ResponseEntity<Void> updataProduct(@PathVariable int id, @RequestBody Product product) {
       if (productRepository.existsById(id)){
            Product newPro = productRepository.findById(id).get();
            newPro.setName(product.getName());
            newPro.setDescription(product.getDescription());
            newPro.setPrice(product.getPrice());
            productRepository.save(newPro);
           return new ResponseEntity<>(HttpStatus.NO_CONTENT);
       }
       return new ResponseEntity<>(HttpStatus.NOT_FOUND);
   }

    /* 根据商品id查找商品 */
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) {
        return productRepository.findById(id).get();
    }

    /* 根据name查找商品 */
    @GetMapping(params = "name")
    public List<Product> getProductsByName(@RequestParam String name) {
        return productRepository.findByName(name);
    }

    /*查找所有商品 */
    @GetMapping
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    /*当查询商品时，输入查询文本，系统应该对商品的名称和描述进行模糊查询，并返回包含查询文本的商品。*/
    @GetMapping(params = {"name","description"})
    public List<Product> getProductsByNameAndDescription(@RequestParam String name,
                                                         @RequestParam String description) {
        return productRepository.findByNameAndDescriptionContains(name, description);
    }



}
