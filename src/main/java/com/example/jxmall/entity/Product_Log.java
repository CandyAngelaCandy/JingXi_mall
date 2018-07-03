package com.example.jxmall.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Product_Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;//外键关联：product_id;
    private int ActionCode;
    private String description;
    private BigDecimal price;
    private String Notes;
    private Date createDate;
    private int createUser;

    public Product_Log() {

    }

    public Product_Log(int id, int actionCode, String description,
                       BigDecimal price, String notes, Date createDate, int createUser) {
        this.id = id;
        ActionCode = actionCode;
        this.description = description;
        this.price = price;
        Notes = notes;
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

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
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
