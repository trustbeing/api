package com.waipan.api.model.entity;

import java.util.Date;

public class InfoAdmin {
    private Long id;

    private String user_name;

    private String mobile;

    private String pass_word;

    private String nick_name;

    private Long creater_id;

    private Long permission_role;

    private Integer is_super;

    private Integer is_delete;

    private Integer sys_type;

    private Long sys_type_id;

    private Date create_time;

    private Date update_time;

    private Integer lock_count;

    private Integer cmp_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name == null ? null : user_name.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getPass_word() {
        return pass_word;
    }

    public void setPass_word(String pass_word) {
        this.pass_word = pass_word == null ? null : pass_word.trim();
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name == null ? null : nick_name.trim();
    }

    public Long getCreater_id() {
        return creater_id;
    }

    public void setCreater_id(Long creater_id) {
        this.creater_id = creater_id;
    }

    public Long getPermission_role() {
        return permission_role;
    }

    public void setPermission_role(Long permission_role) {
        this.permission_role = permission_role;
    }

    public Integer getIs_super() {
        return is_super;
    }

    public void setIs_super(Integer is_super) {
        this.is_super = is_super;
    }

    public Integer getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(Integer is_delete) {
        this.is_delete = is_delete;
    }

    public Integer getSys_type() {
        return sys_type;
    }

    public void setSys_type(Integer sys_type) {
        this.sys_type = sys_type;
    }

    public Long getSys_type_id() {
        return sys_type_id;
    }

    public void setSys_type_id(Long sys_type_id) {
        this.sys_type_id = sys_type_id;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Integer getLock_count() {
        return lock_count;
    }

    public void setLock_count(Integer lock_count) {
        this.lock_count = lock_count;
    }

    public Integer getCmp_id() {
        return cmp_id;
    }

    public void setCmp_id(Integer cmp_id) {
        this.cmp_id = cmp_id;
    }
}