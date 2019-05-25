package com.fei.common.redis.prefix;

public class ProduckPrefix extends BaseKeyPrefix {

    protected ProduckPrefix(String prefix) {
        super(prefix);
    }

    public final static ProduckPrefix productStcockCount = new ProduckPrefix("productStockPrefix") ;

}
