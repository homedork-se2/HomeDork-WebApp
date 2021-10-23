package com.example.HomeDorkWebApp.model;

public class UserFirebase {
    private String displayName;
    private String email;
    private String tokenId;

    public String getLocalId() {
        return localId;
    }

    public void setLocalId(String localId) {
        this.localId = localId;
    }

    private String localId;

    public UserFirebase(String displayName, String email, String tokenId, String localId) {
        this.displayName = displayName;
        this.email = email;
        this.tokenId = tokenId;
        this.localId = localId;
    }

    @Override
    public String toString() {
        return "UserFirebase{" +
                "displayName='" + displayName + '\'' +
                ", email='" + email + '\'' +
                ", tokenId='" + tokenId + '\'' +
                ", localId='" + localId + '\'' +
                '}';
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
