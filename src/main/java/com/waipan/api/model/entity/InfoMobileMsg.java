package com.waipan.api.model.entity;

import java.util.Date;

public class InfoMobileMsg {
    private Long id;

    private String mobile;

    private String request_ip;

    private String verify_code;

    private Integer msg_type;

    private String msg_content;

    private String send_result;

    private Date create_time;

    private Integer cmp_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getRequest_ip() {
        return request_ip;
    }

    public void setRequest_ip(String request_ip) {
        this.request_ip = request_ip == null ? null : request_ip.trim();
    }

    public String getVerify_code() {
        return verify_code;
    }

    public void setVerify_code(String verify_code) {
        this.verify_code = verify_code == null ? null : verify_code.trim();
    }

    public Integer getMsg_type() {
        return msg_type;
    }

    public void setMsg_type(Integer msg_type) {
        this.msg_type = msg_type;
    }

    public String getMsg_content() {
        return msg_content;
    }

    public void setMsg_content(String msg_content) {
        this.msg_content = msg_content == null ? null : msg_content.trim();
    }

    public String getSend_result() {
        return send_result;
    }

    public void setSend_result(String send_result) {
        this.send_result = send_result == null ? null : send_result.trim();
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