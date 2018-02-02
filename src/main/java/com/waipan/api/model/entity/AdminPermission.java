package com.waipan.api.model.entity;

import java.util.Date;

public class AdminPermission {
    private Long id;

    private String permission_name;

    private Long create_id;

    private Integer is_delete;

    private String permission_controller;

    private String permission_action;

    private Date create_time;

    private Date update_time;

    private Long group_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermission_name() {
        return permission_name;
    }

    public void setPermission_name(String permission_name) {
        this.permission_name = permission_name == null ? null : permission_name.trim();
    }

    public Long getCreate_id() {
        return create_id;
    }

    public void setCreate_id(Long create_id) {
        this.create_id = create_id;
    }

    public Integer getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(Integer is_delete) {
        this.is_delete = is_delete;
    }

    public String getPermission_controller() {
        return permission_controller;
    }

    public void setPermission_controller(String permission_controller) {
        this.permission_controller = permission_controller == null ? null : permission_controller.trim();
    }

    public String getPermission_action() {
        return permission_action;
    }

    public void setPermission_action(String permission_action) {
        this.permission_action = permission_action == null ? null : permission_action.trim();
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

    public Long getGroup_id() {
        return group_id;
    }

    public void setGroup_id(Long group_id) {
        this.group_id = group_id;
    }
}