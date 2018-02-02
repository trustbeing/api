package com.waipan.api.model.dto;

import com.waipan.api.util.enums.EnumOperatorType;

public class TokenModel {
	//用户id
	private long id;

	private int type;

	//随机生成的uuid
	private String token;

	public TokenModel(long id, int type, String token){
		this.id = id;
		this.type = type;
		this.token = token;
	}

	public long getId() {
		return id;
	}

	public void setId(long userId) {
		this.id = userId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}


	public String getAuthToken() {
		return id + "_" + type + "_" + token;
	}

	public static String getRedisKey(long id, int type) {
		return "AUTHORIZATION_" + id + "_" + type;
	}


}
