package com.waipan.api.util.enums;

/**
 * @Author: WangChenGang
 * @Description:
 * @Date: Created in 10:37 2018/1/26
 * @Modified By:
 */
public enum EnumInfoMobileMsgType {
	Register("注册",1),
	ForgetPwd("忘记密码",2),
	QuickLogin("快捷登录",3),
	ChangePassword("修改密码",4),
	OtherAreaLoginTip("异地登录提醒",5),
	AdminLogin("后台登录验证码",6),
	UserRecharge("用户充值到帐",7),
	UserWithdraw("用户提现到帐",8),
	ChangeAdminAccount("修改后台账户",9);

	// 成员变量
	private String name;
	private int index;

	// 构造方法
	EnumInfoMobileMsgType(String name, int index) {
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
