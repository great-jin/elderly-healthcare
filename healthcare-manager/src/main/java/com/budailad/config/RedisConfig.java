package com.budailad.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Configuration
public class RedisConfig {

    /**
     * 配置缓存管理器
     *
     * @param factory Redis 线程安全连接工厂
     * @return 缓存管理器
     */
    @Bean
    public CacheManager cacheManager(RedisConnectionFactory factory) {
        RedisCacheConfiguration defaultCacheConfig = RedisCacheConfiguration.defaultCacheConfig();

        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                // 设置缓存前缀
                .prefixCacheNameWith("healthcare:")
                // 设置 key 序列化
                .serializeKeysWith(keyPair())
                // 设置 value 序列化
                .serializeValuesWith(valuePair());

        Set<String> cacheNames = new HashSet<>();
        cacheNames.add("minio");
        cacheNames.add("patient");

        cacheNames.add("applyGoods");
        cacheNames.add("applyInfo");
        cacheNames.add("dailyTask");
        cacheNames.add("employeeSalary");
        cacheNames.add("illnessCatalog");
        cacheNames.add("loginUser");
        cacheNames.add("homeMenu");
        cacheNames.add("mailInfo");
        cacheNames.add("medicineCatalog");
        cacheNames.add("orderGoods");
        cacheNames.add("organizeInfo");
        cacheNames.add("organizeStaff");
        cacheNames.add("paitentCostDetail");
        cacheNames.add("patientBodyInfo");
        cacheNames.add("patientCaseFiles");
        cacheNames.add("patientCaseInfo");
        cacheNames.add("patientContact");
        cacheNames.add("patientInfo");
        cacheNames.add("registerTemplate");
        cacheNames.add("salaryDetailFiles");
        cacheNames.add("staffDoctor");
        cacheNames.add("staffNurse");
        cacheNames.add("sysLogs");
        cacheNames.add("vacateInfo");
        cacheNames.add("warehoseStorage");

        Map<String, RedisCacheConfiguration> redisCacheConfigurationMap = new HashMap<>();
        redisCacheConfigurationMap.put("minio", redisCacheConfiguration.entryTtl(Duration.ofDays(5)));
        redisCacheConfigurationMap.put("patient", redisCacheConfiguration.entryTtl(Duration.ofHours(10)));

        redisCacheConfigurationMap.put("applyGoods", redisCacheConfiguration.entryTtl(Duration.ofHours(10)));
        redisCacheConfigurationMap.put("applyInfo", redisCacheConfiguration.entryTtl(Duration.ofHours(10)));
        redisCacheConfigurationMap.put("dailyTask", redisCacheConfiguration.entryTtl(Duration.ofHours(10)));
        redisCacheConfigurationMap.put("employeeSalary", redisCacheConfiguration.entryTtl(Duration.ofHours(10)));
        redisCacheConfigurationMap.put("illnessCatalog", redisCacheConfiguration.entryTtl(Duration.ofHours(10)));
        redisCacheConfigurationMap.put("loginUser", redisCacheConfiguration.entryTtl(Duration.ofHours(10)));
        redisCacheConfigurationMap.put("homeMenu", redisCacheConfiguration.entryTtl(Duration.ofHours(10)));
        redisCacheConfigurationMap.put("mailInfo", redisCacheConfiguration.entryTtl(Duration.ofHours(10)));
        redisCacheConfigurationMap.put("medicineCatalog", redisCacheConfiguration.entryTtl(Duration.ofHours(10)));
        redisCacheConfigurationMap.put("orderGoods", redisCacheConfiguration.entryTtl(Duration.ofHours(10)));
        redisCacheConfigurationMap.put("organizeInfo", redisCacheConfiguration.entryTtl(Duration.ofHours(10)));
        redisCacheConfigurationMap.put("organizeStaff", redisCacheConfiguration.entryTtl(Duration.ofHours(10)));
        redisCacheConfigurationMap.put("paitentCostDetail", redisCacheConfiguration.entryTtl(Duration.ofHours(10)));
        redisCacheConfigurationMap.put("patientBodyInfo", redisCacheConfiguration.entryTtl(Duration.ofHours(10)));
        redisCacheConfigurationMap.put("patientCaseFiles", redisCacheConfiguration.entryTtl(Duration.ofHours(10)));
        redisCacheConfigurationMap.put("patientCaseInfo", redisCacheConfiguration.entryTtl(Duration.ofHours(10)));
        redisCacheConfigurationMap.put("patientContact", redisCacheConfiguration.entryTtl(Duration.ofHours(10)));
        redisCacheConfigurationMap.put("patientInfo", redisCacheConfiguration.entryTtl(Duration.ofHours(10)));
        redisCacheConfigurationMap.put("registerTemplate", redisCacheConfiguration.entryTtl(Duration.ofHours(10)));
        redisCacheConfigurationMap.put("salaryDetailFiles", redisCacheConfiguration.entryTtl(Duration.ofHours(10)));
        redisCacheConfigurationMap.put("staffDoctor", redisCacheConfiguration.entryTtl(Duration.ofHours(10)));
        redisCacheConfigurationMap.put("staffNurse", redisCacheConfiguration.entryTtl(Duration.ofHours(10)));
        redisCacheConfigurationMap.put("sysLogs", redisCacheConfiguration.entryTtl(Duration.ofHours(10)));
        redisCacheConfigurationMap.put("vacateInfo", redisCacheConfiguration.entryTtl(Duration.ofHours(10)));
        redisCacheConfigurationMap.put("warehoseStorage", redisCacheConfiguration.entryTtl(Duration.ofHours(10)));

        // 返回 Redis 缓存管理器
        return RedisCacheManager.builder(factory)
                .cacheDefaults(defaultCacheConfig)
                .initialCacheNames(cacheNames)
                .withInitialCacheConfigurations(redisCacheConfigurationMap)
                .build();

    }

    /**
     * Redis 数据库操作基本配置
     *
     * @param factory
     * @return
     */
    @Bean
    @SuppressWarnings("all")
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
        template.setConnectionFactory(factory);

        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);

        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        // key采用String的序列化方式
        template.setKeySerializer(stringRedisSerializer);
        // hash的key也采用String的序列化方式
        template.setHashKeySerializer(stringRedisSerializer);
        // value序列化方式采用jackson
        template.setValueSerializer(jackson2JsonRedisSerializer);
        // hash的value序列化方式采用jackson
        template.setHashValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();

        return template;

    }

    /**
     * 配置 键 序列化
     */
    private RedisSerializationContext.SerializationPair<String> keyPair() {
        return RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer());
    }

    /**
     * 配置 值 序列化
     *
     * 使用 GenericJackson2JsonRedisSerializer 替换默认序列化
     */
    private RedisSerializationContext.SerializationPair<Object> valuePair() {
        return RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer());
    }

}
