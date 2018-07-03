package com.example.jxmall.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

//Express_Merchant记录第三方的快递公司
@Entity
public class Express_Merchant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;//外键为Express的id;
    private String Name;
    private String ThirdPartReferenceId;
    private Date CreateDate;
    private int CreateUser;
    private Date lastEditDate;
    private int lastEditUser;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getThirdPartReferenceId() {
        return ThirdPartReferenceId;
    }

    public void setThirdPartReferenceId(String thirdPartReferenceId) {
        ThirdPartReferenceId = thirdPartReferenceId;
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

    public Express_Merchant(int id, String name, String thirdPartReferenceId, Date createDate,
                            int createUser, Date lastEditDate, int lastEditUser) {
        this.id = id;
        Name = name;
        ThirdPartReferenceId = thirdPartReferenceId;
        CreateDate = createDate;
        CreateUser = createUser;
        this.lastEditDate = lastEditDate;
        this.lastEditUser = lastEditUser;
    }

    public Express_Merchant() {

    }


}
