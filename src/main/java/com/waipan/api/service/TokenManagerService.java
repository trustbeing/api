package com.waipan.api.service;

import com.waipan.api.model.dto.TokenModel;

public interface TokenManagerService {
	/**
	 * 创建一个token关联上指定用户
	 * @param id 指定用户的id
	 * @param type 指定用户类型
	 * @return 生成的token
	 */
	TokenModel createToken(long id, int type,String requestIp);

	/**
	 * 检查token是否有效
	 * @param model token
	 * @return 是否有效
	 */
	boolean checkToken(TokenModel model,String requestIp);

	/**
	 * 从字符串中解析token
	 * @param authentication 加密后的字符串
	 * @return
	 */
	TokenModel getToken(String authentication);

	/**
	 * 清除token
	 * @param id 登录的id
	 * @param type 登录类型
	 */
	void deleteToken(long id, int type);
}
