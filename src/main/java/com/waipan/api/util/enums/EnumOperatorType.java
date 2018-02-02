package com.waipan.api.util.enums;

/**
 * @Author: WangChenGang
 * @Description:
 * @Date: Created in 15:31 2018/1/26
 * @Modified By:
 */
public enum EnumOperatorType {
	SysUser(1),
	User(2);

	private int index;

	EnumOperatorType(int index){
		this.index = index;
	}

	public int getIndex(){
		return index;
	}


}
