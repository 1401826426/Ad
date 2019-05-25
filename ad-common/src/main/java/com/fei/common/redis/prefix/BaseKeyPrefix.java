package com.fei.common.redis.prefix;

public abstract class BaseKeyPrefix implements KeyPrefix{

	private int expireTime ; 
	
	private String prefix ; 
	
	protected BaseKeyPrefix(String prefix) {
		this(0, prefix) ;
	}
	
	protected BaseKeyPrefix(int expireTime,String prefix) {
		this.expireTime = expireTime ; 
		this.prefix = prefix ; 
	}
	
	
	@Override
	public String getPrefix() {
		return getClass().getSimpleName()+"_"+prefix;
	}

	@Override
	public int getExpireTime() {
		return expireTime;
	}

}
