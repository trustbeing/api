package com.waipan.api.model.entity;

import java.math.BigDecimal;
import java.util.Date;

public class UserAccountLog {
    private Long id;

    private Long user_id;

    private Integer change_type;

    private BigDecimal change_money;

    private BigDecimal pre_money;

    private BigDecimal now_money;

    private String detail;

    private String remark;

    private String ref_table;

    private Long ref_id;

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

    public Integer getChange_type() {
        return change_type;
    }

    public void setChange_type(Integer change_type) {
        this.change_type = change_type;
    }

    public BigDecimal getChange_money() {
        return change_money;
    }

    public void setChange_money(BigDecimal change_money) {
        this.change_money = change_money;
    }

    public BigDecimal getPre_money() {
        return pre_money;
    }

    public void setPre_money(BigDecimal pre_money) {
        this.pre_money = pre_money;
    }

    public BigDecimal getNow_money() {
        return now_money;
    }

    public void setNow_money(BigDecimal now_money) {
        this.now_money = now_money;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getRef_table() {
        return ref_table;
    }

    public void setRef_table(String ref_table) {
        this.ref_table = ref_table == null ? null : ref_table.trim();
    }

    public Long getRef_id() {
        return ref_id;
    }

    public void setRef_id(Long ref_id) {
        this.ref_id = ref_id;
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