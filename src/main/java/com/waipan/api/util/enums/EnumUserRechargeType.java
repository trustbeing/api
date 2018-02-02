package com.waipan.api.util.enums;

/**
 * @Author: WangChenGang
 * @Description:
 * @Date: Created in 18:17 2018/2/1
 * @Modified By:
 */
public enum EnumUserRechargeType {
	UnKnown("未知方式",0),
	AliPay("支付宝",1),
	BankTransfer("银行转账",2);

	// 成员变量
	private String name;
	private int index;

	// 构造方法
	private EnumUserRechargeType(String name, int index) {
		this.name = name;
		this.index = index;
	}

	public int getIndex(){
		return this.index;
	}

	public String getName(){
		return this.name;
	}

	public static EnumUserRechargeType getByIndex(int index){
		if(index==1) return EnumUserRechargeType.AliPay;
		if(index==2) return EnumUserRechargeType.BankTransfer;
		return EnumUserRechargeType.UnKnown;
	}

	//覆盖方法
	@Override
	public String toString() {
		return this.index+"_"+this.name;
	}

}
