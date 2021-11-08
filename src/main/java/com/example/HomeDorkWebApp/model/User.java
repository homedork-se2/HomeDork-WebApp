package com.example.HomeDorkWebApp.model;

public class User {
    private String displayName;
    private String email;
    private String localId;

    @Override
    public String toString() {
        return "User{" +
                "displayName='" + displayName + '\'' +
                ", email='" + email + '\'' +
                ", tokenId='" + localId + '\'' +
                '}';
    }

    public User(String displayName, String email, String localId) {
        this.displayName = displayName;
        this.email = email;
        this.localId = localId;
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

    public String getLocalId() {
        return localId;
    }

    public void setLocalId(String localId) {
        this.localId = localId;
    }
}
