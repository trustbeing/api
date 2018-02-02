package com.waipan.api.util.enums;

/**
 * @Author: WangChenGang
 * @Description:
 * @Date: Created in 18:41 2018/1/24
 * @Modified By:
 */
public enum EnumTrueOrFalseState {
	True("是",1),
	False("否",0);

	// 成员变量
	private String name;
	private int index;

	// 构造方法
	private EnumTrueOrFalseState(String name, int index) {
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
