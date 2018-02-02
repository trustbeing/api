package com.waipan.api.model.entity;

import java.math.BigDecimal;
import java.util.Date;

public class UserRecharge {
    private Long id;

    private Long user_id;

    private Integer recharge_type;

    private BigDecimal money;

    private Long sys_user_id;

    private String third_code;

    private String remark;

    private Date create_time;

    private Integer cmp_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Integer getRecharge_type() {
        return recharge_type;
    }

    public void setRecharge_type(Integer recharge_type) {
        this.recharge_type = recharge_type;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Long getSys_user_id() {
        return sys_user_id;
    }

    public void setSys_user_id(Long sys_user_id) {
        this.sys_user_id = sys_user_id;
    }

    public String getThird_code() {
        return third_code;
    }

    public void setThird_code(String third_code) {
        this.third_code = third_code == null ? null : third_code.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Integer getCmp_id() {
        return cmp_id;
    }

    public void setCmp_id(Integer cmp_id) {
        this.cmp_id = cmp_id;
    }
}