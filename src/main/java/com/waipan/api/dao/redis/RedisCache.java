package com.waipan.api.dao.redis;

/**
 * @Author: WangChenGang
 * @Description:
 * @Date: Created in 14:50 2018/1/25
 * @Modified By:
 */
public interface RedisCache {

	String get(String key);

	String set(String key,String value);

	String set(String key,String value,int expire);

	long expire(String key,int expire);

	long delete(String key);
}
