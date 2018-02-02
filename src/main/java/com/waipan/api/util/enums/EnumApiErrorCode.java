package com.waipan.api.util.enums;

/**
 * @Author: WangChenGang
 * @Description:
 * @Date: Created in 15:39 2018/1/25
 * @Modified By:
 */
public enum EnumApiErrorCode {
	LoginChange("网络发生变更或异地登陆",401),
	NoPermission("权限不足",402),
	MobileCodeLogin("短信验证码登录",403),
	UnCertificate("未实名认证",2002),
	NeedCharge("余额不足",2003);

	// 成员变量
	private String name;
	private int index;

	// 构造方法
	private EnumApiErrorCode(String name, int index) {
		this.name = name;
		this.index = index;
	}

	public int getIndex(){
		return this.index;
	}

	public String getName(){
		return this.name;
	}

	//覆盖方法
	@Override
	public String toString() {
		return this.index+"_"+this.name;
	}
}
