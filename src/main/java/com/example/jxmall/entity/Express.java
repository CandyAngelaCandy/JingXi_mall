package com.example.jxmall.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

//Express记录快递信息
@Entity
public class Express {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;//外键为Order_Mater_id和merchant_Id(用户的id);
    private int status;
    private Date CreateDate;
    private int CreateUser;
    private Date lastEditDate;
    private int lastEditUser;

    private  String expressStatus;
    private  Date outboundTime;
    private  Date signedTime;
    private  String deliveryMan;

    public Express(Order_Items order) {
        this.Id  = order.getId();
        this.expressStatus = order.getLogisticsStatus();
        this.outboundTime = order.getOutboundTime();
        this.signedTime = order.getSignedTime();
        this.deliveryMan = order.getDeliveryMan();
    }

    public Express(int id, int status, Date createDate, int createUser,
                   Date lastEditDate, int lastEditUser) {
        Id = id;
        this.status = status;
        CreateDate = createDate;
        CreateUser = createUser;
        this.lastEditDate = lastEditDate;
        this.lastEditUser = lastEditUser;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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
