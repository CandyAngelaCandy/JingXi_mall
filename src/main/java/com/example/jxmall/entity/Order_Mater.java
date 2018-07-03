package com.example.jxmall.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

//Order_Mater记录用户对应的订单的信息
@Entity
public class Order_Mater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;//外键为customer_id;
    private int status;
    private BigDecimal Amount;
    private Date CreateDate;
    private int CreateUser;
    private Date lastEditDate;
    private int lastEditUser;
    private String Notes;

    public Order_Mater() {

    }

    public Order_Mater(int id, int status, BigDecimal amount, Date createDate,
                       int createUser, Date lastEditDate, int lastEditUser, String notes) {
        this.id = id;
        this.status = status;
        Amount = amount;
        CreateDate = createDate;
        CreateUser = createUser;
        this.lastEditDate = lastEditDate;
        this.lastEditUser = lastEditUser;
        Notes = notes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public BigDecimal getAmount() {
        return Amount;
    }

    public void setAmount(BigDecimal amount) {
        Amount = amount;
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

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }


















}
