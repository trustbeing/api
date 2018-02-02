package com.waipan.api.util;

import com.waipan.api.util.enums.EnumApiErrorCode;

import java.io.Serializable;

/**
 * @Author: WangChenGang
 * @Description:
 * @Date: Created in 15:30 2018/1/24
 * @Modified By:
 */
public class ResponseResult implements Serializable{

	public boolean success;

	public int errorcode;

	public String msg;

	public Object data;

	public static ResponseResult returnFailure(String msg){
		ResponseResult result = new ResponseResult();
		result.msg = msg;
		return result;
	}

	public static ResponseResult returnFailure(String msg,int errorcode){
		ResponseResult result = new ResponseResult();
		result.msg = msg;
		result.errorcode = errorcode;
		return result;
	}

	public static ResponseResult returnSuccess(Object data){
		ResponseResult result = new ResponseResult();
		result.success = true;
		result.data = data;
		return result;
	}

	public static ResponseResult returnStringResult(String data){

		ResponseResult result = new ResponseResult();
		result.data = data;
		if(StringExtension.isEmpty(data)){
			result.success = true;
		}else{
			result.msg = data;
		}

		return result;
	}

	public static ResponseResult returnAuthorizeFailure() {
		ResponseResult result = new ResponseResult();
		result.msg = EnumApiErrorCode.LoginChange.getName();
		result.errorcode = EnumApiErrorCode.LoginChange.getIndex();
		return result;
	}

	public static ResponseResult returnNoPermission() {
		ResponseResult result = new ResponseResult();
		result.msg = EnumApiErrorCode.NoPermission.getName();
		result.errorcode = EnumApiErrorCode.NoPermission.getIndex();
		return result;
	}
}
