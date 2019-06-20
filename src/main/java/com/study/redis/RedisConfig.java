package com.study.redis;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="redis")
@Data
public class RedisConfig {
	private String host;
	private int port;
	private int timeout;//秒
	private int poolMaxTotal;
	private int poolMaxIdle;
	private int poolMaxWait;//秒

}
