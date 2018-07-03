package com.example.jxmall.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

//Customer_Log记录用户的操作日志
@Entity
public class Customer_Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;//外键为customer_id;
    private int actionCode;
    private String Notes;
    private Date CreateDate;
    private int CreateUser;

    public Customer_Log() {

    }

    public Customer_Log(int id, int actionCode, String notes,
                        Date createDate, int createUser) {
        this.id = id;
        this.actionCode = actionCode;
        Notes = notes;
        CreateDate = createDate;
        CreateUser = createUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getActionCode() {
        return actionCode;
    }

    public void setActionCode(int actionCode) {
        this.actionCode = actionCode;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
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



}
