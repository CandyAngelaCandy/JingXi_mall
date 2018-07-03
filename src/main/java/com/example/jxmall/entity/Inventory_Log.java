package com.example.jxmall.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Inventory_Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;//外键关联：Inventory_Id;
    private int ActionCode;
    private int Quantity;
    private int LockQuantity;
    private int orderQuantity;
    private Date createDate;
    private int createUser;

    public Inventory_Log() {

    }

    public Inventory_Log(int id, int actionCode, int quantity,
                         int lockQuantity, int orderQuantity, Date createDate, int createUser) {
        this.id = id;
        ActionCode = actionCode;
        Quantity = quantity;
        LockQuantity = lockQuantity;
        this.orderQuantity = orderQuantity;
        this.createDate = createDate;
        this.createUser = createUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getActionCode() {
        return ActionCode;
    }

    public void setActionCode(int actionCode) {
        ActionCode = actionCode;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public int getLockQuantity() {
        return LockQuantity;
    }

    public void setLockQuantity(int lockQuantity) {
        LockQuantity = lockQuantity;
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

}
