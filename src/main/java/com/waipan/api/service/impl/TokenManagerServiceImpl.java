package com.waipan.api.service.impl;


import com.waipan.api.dao.redis.RedisCache;
import com.waipan.api.model.dto.TokenModel;
import com.waipan.api.service.TokenManagerService;
import com.waipan.api.util.StringExtension;
import com.waipan.api.util.enums.EnumOperatorType;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

@Component("tokenManagerService")
public class TokenManagerServiceImpl implements TokenManagerService {

	@Resource
	private RedisCache redisCache;

	public TokenModel createToken(long id, int type,String requestIp) {
		String token = (UUID.randomUUID().toString()+UUID.randomUUID().toString()+UUID.randomUUID().toString()+UUID.randomUUID().toString()).replace("-", "");
		TokenModel model = new TokenModel(id,type, token);
		redisCache.set(TokenModel.getRedisKey(id,type), token, 7 * 60 * 24);
		redisCache.set(TokenModel.getRedisKey(id,type)+"_ip", requestIp, 7 * 60 * 24);
		return model;
	}

	public boolean checkToken(TokenModel model,String requestIp) {
		if (model == null) {
			return false;
		}
		String token = redisCache.get(TokenModel.getRedisKey(model.getId(),model.getType()));
		String tokenIp = redisCache.get(TokenModel.getRedisKey(model.getId(),model.getType())+"_ip");
		if (StringExtension.isEmpty(token)||!model.getToken().equals(token)|| !requestIp.equals(tokenIp)) {
			return false;
		}

		//如果验证成功，说明此用户进行了一次有效操作，延长token的过期时间
		redisCache.expire(TokenModel.getRedisKey(model.getId(),model.getType()), 7 * 60 * 24);
		redisCache.expire(TokenModel.getRedisKey(model.getId(),model.getType())+"_ip", 7 * 60 * 24);

		return true;
	}

	public TokenModel getToken(String authentication) {
		if (StringExtension.isEmpty(authentication)) {
			return null;
		}
		String[] param = authentication.split("_");
		if (param.length != 3) {
			return null;
		}
		//使用userId和源token简单拼接成的token，可以增加加密措施
		long userId = Long.parseLong(param[0]);
		int type = Integer.parseInt(param[1]);
		String token = param[2];
		return new TokenModel(userId,type, token);
	}

	public void deleteToken(long userId,int type) {
		redisCache.delete(TokenModel.getRedisKey(userId,type));
	}
}
