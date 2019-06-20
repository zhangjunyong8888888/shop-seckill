package com.study.redis;

public class UserKey extends BasePrefix{

	public static final int TOKEN_EXPIRE = 3600*24 * 2;


	public static final String TOKEN_NAME = "token";


	private UserKey(int expireSeconds, String prefix) {
		super(expireSeconds, prefix);
	}

	public static UserKey token = new UserKey(TOKEN_EXPIRE, "tk");
}
