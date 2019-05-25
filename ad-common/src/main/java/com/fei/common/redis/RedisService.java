package com.fei.common.redis;

import com.alibaba.fastjson.JSON;
import com.fei.common.redis.prefix.KeyPrefix;
import com.fei.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Set;

@Service
public class RedisService {

    @Autowired
    private JedisPool jedisPool;

    public <T> T get(KeyPrefix keyPrefix, String key, Class<T> clazz) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String realKey = keyPrefix.getPrefix() + key;
            String result = jedis.get(realKey);
            if (StringUtils.isBlank(result)) {
                return null;
            }
            return strToBean(result, clazz);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }


    public boolean set(KeyPrefix keyPrefix, String key, Object bean) {
        Jedis jedis = null;
        try {
            if (bean == null) {
                return false;
            }
            jedis = jedisPool.getResource();
            String s = beanToStr(bean);
            String realKey = keyPrefix.getPrefix() + key;
            if (keyPrefix.getExpireTime() <= 0) {
                jedis.set(realKey, s);
            } else {
                jedis.setex(realKey, keyPrefix.getExpireTime(), s);
            }
            return true;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public boolean exists(KeyPrefix keyPrefix, String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String realKey = keyPrefix.getPrefix() + key;
            return jedis.exists(realKey);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public long incr(KeyPrefix keyPrefix, String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String realKey = keyPrefix.getPrefix() + key;
            return jedis.incr(realKey);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    public long desc(KeyPrefix keyPrefix, String key) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String realKey = keyPrefix.getPrefix() + key;
            return jedis.decr(realKey);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    private <T> T strToBean(String str, Class<T> clazz) {
        if (str == null) {
            return null;
        }
        return JSON.toJavaObject(JSON.parseObject(str), clazz);
    }

    private String beanToStr(Object obj) {
        return JSON.toJSONString(obj);
    }


    public void deleteByKeyPrefix(KeyPrefix keyPrefix) {
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            Set<String> keys = jedis.keys(keyPrefix.getPrefix() + "*");
            if (keys.size() > 0) {
                String[] kks = new String[keys.size()];
                int pos = 0;
                for (String key : keys) {
                    kks[pos++] = key;
                }
                jedis.del(kks);
            }
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(JSON.toJSONString("1"));
        System.out.println(JSON.toJSONString(1));
        System.out.println(JSON.toJSONString(1l));
    }

}
















