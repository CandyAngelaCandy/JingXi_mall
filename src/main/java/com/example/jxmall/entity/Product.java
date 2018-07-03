package com.example.jxmall.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

//product表为产品的具体信息
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private BigDecimal price;

    private int totalCount;//库存数量
    private int purchaseCount;//用户购买数量
    private  int lockedCount;//锁定数量

    private Date createDate;
    private int createUser;
    private Date lastEditDate;
    private int lastEditUser;

    //产品与订单是多对一的关系
    @ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name = "orderId")
    private Order_Items order;

    public Order_Items getOrder() {
        return order;
    }

    public void setOrder(Order_Items order) {
        this.order = order;
    }

    public int getPurchaseCount() {
        return purchaseCount;
    }

    public void setPurchaseCount(int purchaseCount) {
        this.purchaseCount = purchaseCount;
    }

    public Product() {
    }

    public Product(int id, String name, String description, BigDecimal price,
                   Date createDate, int createUser, Date lastEditDate, int lastEditUser) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.createDate = createDate;
        this.createUser = createUser;
        this.lastEditDate = lastEditDate;
        this.lastEditUser = lastEditUser;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getLockedCount() {
        return lockedCount;
    }

    public void setLockedCount(int lockedCount) {
        this.lockedCount = lockedCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getCreateUser() {
        return createUser;
    }

    public void setCreateUser(int createUser) {
        this.createUser = createUser;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
