package com.waipan.api.model.entity;

import java.util.Date;

public class AdminRole {
    private Long id;

    private String role_name;

    private Long create_id;

    private Integer is_delete;

    private String permission_ids;

    private Date create_time;

    private Date update_time;

    private Integer cmp_id;

    private String default_path;

    private String all_path;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name == null ? null : role_name.trim();
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

    public String getPermission_ids() {
        return permission_ids;
    }

    public void setPermission_ids(String permission_ids) {
        this.permission_ids = permission_ids == null ? null : permission_ids.trim();
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

    public Integer getCmp_id() {
        return cmp_id;
    }

    public void setCmp_id(Integer cmp_id) {
        this.cmp_id = cmp_id;
    }

    public String getDefault_path() {
        return default_path;
    }

    public void setDefault_path(String default_path) {
        this.default_path = default_path == null ? null : default_path.trim();
    }

    public String getAll_path() {
        return all_path;
    }

    public void setAll_path(String all_path) {
        this.all_path = all_path == null ? null : all_path.trim();
    }
}