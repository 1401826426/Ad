package com.fei.common.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Component
public class RedisPoolfactory {
	
	@Autowired
	private RedisConfig redisConfig ; 
	
	@Bean
	public JedisPool jedisPool(){
		JedisPoolConfig poolConfig = new JedisPoolConfig() ; 
		poolConfig.setMaxIdle(redisConfig.getPoolMaxIdle());
		poolConfig.setMaxTotal(redisConfig.getPoolMaxTotal());
		poolConfig.setMaxWaitMillis(1000l*redisConfig.getPoolMaxWait());
		JedisPool jedisPool = new JedisPool(poolConfig,
				redisConfig.getHost(),redisConfig.getPort(),redisConfig.getTimeout()*1000,redisConfig.getPassword()) ; 
		return jedisPool; 
	}
	
}
