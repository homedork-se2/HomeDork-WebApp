package com.example.HomeDorkWebApp.model;

public class User {
    private String displayName;
    private String email;
    private String tokenId;

    @Override
    public String toString() {
        return "User{" +
                "displayName='" + displayName + '\'' +
                ", email='" + email + '\'' +
                ", tokenId='" + tokenId + '\'' +
                '}';
    }

    public User(String displayName, String email, String tokenId) {
        this.displayName = displayName;
        this.email = email;
        this.tokenId = tokenId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }
}
