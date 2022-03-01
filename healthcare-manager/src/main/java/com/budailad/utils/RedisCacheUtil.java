package com.budailad.utils;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisCacheUtil {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     *  插入数据 || 更新数据
     */
    public void Insert(String key, Object value, long timeout, TimeUnit timeUnit) {

        if (StringUtils.isBlank(key) || !ObjectUtils.anyNotNull(value)) {
            return;
        }
        if (timeout == 0) {
            redisTemplate.opsForValue().set(key, value);
        } else {
            redisTemplate.opsForValue().set(key, value, timeout, timeUnit);
        }

    }

    /**
     * 删除数据
     */
    public void Delete(String key) {
        redisTemplate.opsForValue().getOperations().delete(key);
    }
}
