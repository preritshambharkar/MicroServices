package com.gateway.models;

import java.util.Collection;

public class AuthResponse {
    private String userid;
    private String accessToken;
    private String refreshToken;
    private long expireAt;
    private Collection<String> authorities;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public long getExpireAt() {
        return expireAt;
    }

    public void setExpireAt(long expireAt) {
        this.expireAt = expireAt;
    }

    public Collection<String> getAuthorities() {
        return authorities;
    }

    public void setAuthories(Collection<String> authories) {
        this.authorities = authories;
    }

    public AuthResponse(String userid, String accessToken, String refreshToken, long expireAt, Collection<String> authories) {
        this.userid = userid;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.expireAt = expireAt;
        this.authorities = authories;
    }

    public AuthResponse() {
    }
}
