package com.waipan.api.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class InfoUser implements Serializable{
    private Long id;

    private String mobile;

    private String pass_word;

    private String nick_name;

    private String id_card;

    private String real_name;

    private BigDecimal account_money;

    private BigDecimal user_dyj;

    private Long ref_id;

    private Long company_id;

    private Integer channel;

    private Integer is_lock;

    private Date create_time;

    private Date recent_login;

    private Date recent_visit;

    private Date update_time;

    private Integer cmp_id;

    private Integer day_order_max_amount;

    private Integer is_touch_open;

    private String touch_number;

    private Integer plat_form;

    private String client_id;

    private BigDecimal user_ref_fee;

    private Integer exp_count;

    private Integer ref_level;

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

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card == null ? null : id_card.trim();
    }

    public String getReal_name() {
        return real_name;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name == null ? null : real_name.trim();
    }

    public BigDecimal getAccount_money() {
        return account_money;
    }

    public void setAccount_money(BigDecimal account_money) {
        this.account_money = account_money;
    }

    public BigDecimal getUser_dyj() {
        return user_dyj;
    }

    public void setUser_dyj(BigDecimal user_dyj) {
        this.user_dyj = user_dyj;
    }

    public Long getRef_id() {
        return ref_id;
    }

    public void setRef_id(Long ref_id) {
        this.ref_id = ref_id;
    }

    public Long getCompany_id() {
        return company_id;
    }

    public void setCompany_id(Long company_id) {
        this.company_id = company_id;
    }

    public Integer getChannel() {
        return channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    public Integer getIs_lock() {
        return is_lock;
    }

    public void setIs_lock(Integer is_lock) {
        this.is_lock = is_lock;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getRecent_login() {
        return recent_login;
    }

    public void setRecent_login(Date recent_login) {
        this.recent_login = recent_login;
    }

    public Date getRecent_visit() {
        return recent_visit;
    }

    public void setRecent_visit(Date recent_visit) {
        this.recent_visit = recent_visit;
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

    public Integer getDay_order_max_amount() {
        return day_order_max_amount;
    }

    public void setDay_order_max_amount(Integer day_order_max_amount) {
        this.day_order_max_amount = day_order_max_amount;
    }

    public Integer getIs_touch_open() {
        return is_touch_open;
    }

    public void setIs_touch_open(Integer is_touch_open) {
        this.is_touch_open = is_touch_open;
    }

    public String getTouch_number() {
        return touch_number;
    }

    public void setTouch_number(String touch_number) {
        this.touch_number = touch_number == null ? null : touch_number.trim();
    }

    public Integer getPlat_form() {
        return plat_form;
    }

    public void setPlat_form(Integer plat_form) {
        this.plat_form = plat_form;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id == null ? null : client_id.trim();
    }

    public BigDecimal getUser_ref_fee() {
        return user_ref_fee;
    }

    public void setUser_ref_fee(BigDecimal user_ref_fee) {
        this.user_ref_fee = user_ref_fee;
    }

    public Integer getExp_count() {
        return exp_count;
    }

    public void setExp_count(Integer exp_count) {
        this.exp_count = exp_count;
    }

    public Integer getRef_level() {
        return ref_level;
    }

    public void setRef_level(Integer ref_level) {
        this.ref_level = ref_level;
    }
}