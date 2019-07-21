package com.noodleesystem.auth.model;

public class AuthRequestBody {
	private String username;
	private String password;

	AuthRequestBody(String username, String password) {
		this.username = username;
		this.password = password;
	}

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
}