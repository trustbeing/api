package com.waipan.api.dao.redis.impl;

import com.waipan.api.dao.redis.RedisCache;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @Author: WangChenGang
 * @Description:
 * @Date: Created in 14:51 2018/1/25
 * @Modified By:
 */
@Repository("redisCache")
public class RedisCacheImpl implements RedisCache {
	//日志记录对象
	private static final Logger logger = Logger.getLogger(RedisCacheImpl.class);

	//redis连接池
	@Autowired
	public JedisPool jedisPool;

	public String get(String key){
		Jedis jedis = jedisPool.getResource();
		return jedis.get(key);
	}

	public String set(String key, String value) {
		Jedis jedis = jedisPool.getResource();
		String result = jedis.set(key,value);
		return result;
	}

	public String set(String key,String value,int expire){
		Jedis jedis = jedisPool.getResource();
		String result = jedis.set(key,value);
		jedis.expire(key,expire * 60);
		return result;
	}

	public long expire(String key,int expire){
		Jedis jedis = jedisPool.getResource();
		return jedis.expire(key,expire * 60);
	}

	public long delete(String key){
		Jedis jedis = jedisPool.getResource();
		return jedis.del(key);
	}
}
