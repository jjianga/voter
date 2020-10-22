package org.jjianga.voter.redis;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by Mails-yj on .
 */
@Component
public class RedisUtils {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;
    /**
     * 	判断key是否存在
     * @param key
     * @return
     */
    public boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }
    /**
     * 	删除数据
     * @param key
     */
    public void deleteRedisKey(String key) {
        redisTemplate.delete(key);
    }
    /**
     * 	获取用户 存储的数据
     * @param userId
     * @param key
     * @return
     */
    public String getRedisKey(Integer userId, String key) {
        return userId + key;
    }
    /**
     * 
     * @param key
     * @return
     */
    public boolean getUserRedisLock(String key) {
        return redisTemplate.opsForValue().setIfAbsent(key, System.currentTimeMillis());
    }
    /**
     * 
     * @param key
     * @return
     */
    public Long getUserRedisLockValue(String key) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(redisTemplate.opsForValue().get(key), Long.class);
    }
    /**
     * 	设置key 过期时间
     * @param key
     * @param time
     */
    public void setRedisExpire(String key, long time) {
        redisTemplate.expire(key, time, TimeUnit.MILLISECONDS);
    }
    /**
     * 	键不存在则新增,存在则不改变已经有的值
     * @param key
     * @param user
     * @return
     */
    public boolean setUserToRedis(String key, Object user) {
        return redisTemplate.opsForValue().setIfAbsent(key, user);
    }

    /**
     * 	键不存在则新增,存在则不改变已经有的值
     * @param key
     * @param user
     * @return
     */
    public boolean setValueSyToRedis(String key, Object value) {
        return redisTemplate.opsForValue().setIfAbsent(key, value);
    }
    /**
     *   	覆盖从指定位置开始的值。
     * @param key
     * @param value
     */
    public void setValueToRedis(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }
    public void setValueToRedis(String key, Object value, long time) {
    	redisTemplate.opsForValue().set(key,value, time,TimeUnit.SECONDS);
    }
    
	/**
	 * 获取缓存对象
	 * @param o
	 * @param toValueType
	 * @return
	 */
    public <T> T getRedisValue(Object o, Class<T> toValueType) {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(o, toValueType);
    }
    
    public <T> T getRedisValueByKey(String key, Class<T> toValueType) {
        ObjectMapper objectMapper = new ObjectMapper();
        Object o = redisTemplate.opsForValue().get(key);
        return objectMapper.convertValue(o, toValueType);
    }
    
    /**
     * 	获取缓存字符串
     * @param key
     * @return
     */
    public String getStringRedisValue(String key) {
        Object o = redisTemplate.opsForValue().get(key);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.convertValue(o, String.class);
    }


}
