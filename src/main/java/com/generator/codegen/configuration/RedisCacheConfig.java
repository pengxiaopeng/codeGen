package com.generator.codegen.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;


/*@Configuration
@EnableCaching*/
public class RedisCacheConfig extends CachingConfigurerSupport {
    Logger logger = LoggerFactory.getLogger(getClass());

   /* @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.timeout}")
    private int timeout;

    @Value("${spring.redis.pool.max-idle}")
    private int maxIdle;

    @Value("${spring.redis.pool.max-wait}")
    private long maxWaitMillis;

    @Value("${spring.redis.password}")
    private String password;*/

    /*@Bean
    public JedisPool redisPoolFactory() {
        logger.info("JedisPool注入成功！！");
        logger.info("redis地址：" + host + ":" + port);
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        JedisPool jedisPool = null;
        if (StringUtils.isEmpty(password)) {
            jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout);  //数据库没有设置密码
        } else {
            jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout, password);
        }
        return jedisPool;
    }*/

}