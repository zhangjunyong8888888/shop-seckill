package com.study.redis;

public interface KeyPrefix {
		
	int expireSeconds();
	
	String getPrefix();
	
}
