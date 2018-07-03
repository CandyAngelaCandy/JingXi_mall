package com.example.jxmall.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Order_Mater_Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;//外键为Order_Mater_id;
    private int ActionCode;
    private String Notes;
    private Date CreateDate;
    private int CreateUser;

    public Order_Mater_Log() {

    }

    public Order_Mater_Log(int id, int actionCode, String notes, Date createDate, int createUser) {
        this.id = id;
        ActionCode = actionCode;
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
        return ActionCode;
    }

    public void setActionCode(int actionCode) {
        ActionCode = actionCode;
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
