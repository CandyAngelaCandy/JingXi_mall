package com.example.jxmall.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

//Inventory为仓库的情况
@Entity
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;//外键关联：product_id;
    private int Quantity;
    private int lockQuantity;
    private int orderQuantity;
    private Date createDate;
    private int createUser;
    private Date lastEditDate;
    private int lastEditUser;

    public Inventory() {

    }

    public Inventory(int id, int quantity, int lockQuantity, int orderQuantity,
                     Date createDate, int createUser, Date lastEditDate, int lastEditUser) {
        this.id = id;
        Quantity = quantity;
        this.lockQuantity = lockQuantity;
        this.orderQuantity = orderQuantity;
        this.createDate = createDate;
        this.createUser = createUser;
        this.lastEditDate = lastEditDate;
        this.lastEditUser = lastEditUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public int getLockQuantity() {
        return lockQuantity;
    }

    public void setLockQuantity(int lockQuantity) {
        this.lockQuantity = lockQuantity;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
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
}
