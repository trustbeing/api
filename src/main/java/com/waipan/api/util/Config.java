package com.waipan.api.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author: WangChenGang
 * @Description:
 * @Date: Created in 10:39 2018/2/2
 * @Modified By:
 */
@Component
public class Config {
	public static String AccessKeyId;

	public static String AccessKeySecret;

	public static String SignName;

	@Value("${config.aliyun.AccessKeyId}")
	public void setAccessKeyId(String AccessKeyId) {
		if(StringExtension.isEmpty(AccessKeyId)){
			Config.AccessKeyId = AccessKeyId;
		}

	}

	@Value("${config.aliyun.AccessKeySecret}")
	public void setAccessKeySecret(String AccessKeySecret) {
		if(StringExtension.isEmpty(AccessKeySecret)){
			Config.AccessKeySecret = AccessKeySecret;
		}
	}

	@Value("${config.aliyun.SignName}")
	public void setApiPrefix(String SignName) {
		if(StringExtension.isEmpty(SignName)){
			Config.SignName = SignName;
		}
	}

}
