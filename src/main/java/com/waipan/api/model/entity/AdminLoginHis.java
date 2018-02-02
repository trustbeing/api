package com.waipan.api.model.entity;

import java.util.Date;

public class AdminLoginHis {
    private Long id;

    private Long admin_id;

    private String login_ip;

    private Date create_time;

    private Integer cmp_id;

    private Integer is_area_calc;

    private String area;

    private String agent;

    private String ip_mask;

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

    public String getLogin_ip() {
        return login_ip;
    }

    public void setLogin_ip(String login_ip) {
        this.login_ip = login_ip == null ? null : login_ip.trim();
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

    public Integer getIs_area_calc() {
        return is_area_calc;
    }

    public void setIs_area_calc(Integer is_area_calc) {
        this.is_area_calc = is_area_calc;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent == null ? null : agent.trim();
    }

    public String getIp_mask() {
        return ip_mask;
    }

    public void setIp_mask(String ip_mask) {
        this.ip_mask = ip_mask == null ? null : ip_mask.trim();
    }
}