package com.fei.common.redis.prefix;

public interface KeyPrefix {
	
	public String getPrefix() ; 
	
	public int getExpireTime() ;
	
}
