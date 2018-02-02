package com.waipan.api.util.enums;

/**
 * @Author: WangChenGang
 * @Description:
 * @Date: Created in 18:12 2018/2/1
 * @Modified By:
 */
public enum EnumUserAccountChangeType {
	UnKnown("未知状态",0),
	UserWithDraw("用户提现",1),
	DeductMargin("下单扣除保证金",2),
	DeductFee("下单扣除综合费",3),
	GiveBackMargin("返还保证金",4),
	GiveBackFee("返还综合费",5),
	UserRechange("用户充值",6),
	WithDrawFail("提现失败",7),
	ExpandCommission("推广佣金",8),
	ChangeByAdmin("资金变更",9),
	ChangeDyjByAdmin("抵用金变更",10),
	OrderSimExp("一元体验",11);


	// 成员变量
	private String name;
	private int index;

	// 构造方法
	private EnumUserAccountChangeType(String name, int index) {
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
