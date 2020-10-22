package org.jjianga.voter.redis;

/**
 * redis 分布式锁
 * Created by Mails-yj on .
 */
public abstract class RedisLock {

    public int isDoSomeThingSuccess = 0;

    public RedisLock(String key, RedisUtils redisUtils) {
        boolean getlock = redisUtils.getUserRedisLock(key);
        if (getlock) {
            try {
                doRedisLockThing();
            } catch (Exception e) {
                isDoSomeThingSuccess = -2;
                e.printStackTrace();
            } finally {
                redisUtils.deleteRedisKey(key);
            }
        } else {
            isDoSomeThingSuccess = -1;
            Long time = redisUtils.getUserRedisLockValue(key);
            if (System.currentTimeMillis() - time > 10000) {
                redisUtils.deleteRedisKey(key);
            }
        }
    }

    public abstract void doRedisLockThing();

}
