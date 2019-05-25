package com.fei.common.redis.prefix;

public class UserPrefix extends BaseKeyPrefix {

    protected UserPrefix(String prefix) {
        super(prefix);
    }

    protected UserPrefix(int expireTime, String prefix) {
        super(expireTime, prefix);
    }

    public final static UserPrefix getByOpenId = new UserPrefix("getByOpenId") ;

    public final static UserPrefix getByToken = new UserPrefix(600,"getByToken") ;

}
