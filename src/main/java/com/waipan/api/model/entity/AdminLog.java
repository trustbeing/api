package com.waipan.api.model.entity;

import java.util.Date;

public class AdminLog {
    private Long id;

    private Long admin_id;

    private String ref_table;

    private Long ref_id;

    private String content;

    private String remark;

    private Date create_time;

    private Integer cmp_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(Long admin_id) {
        this.admin_id = admin_id;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
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