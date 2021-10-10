package com.example.HomeDorkWebApp.model;

public class SignInResponse {
    private String localId;
    private String email;
    private String displayName;
    private String idToken;
    private String registered;
    private String refreshToken;
    private String expiresIn;

    @Override
    public String toString() {
        return "SignInResponse{" +
                "localId='" + localId + '\'' +
                ", email='" + email + '\'' +
                ", displayName='" + displayName + '\'' +
                ", idToken='" + idToken + '\'' +
                ", registered='" + registered + '\'' +
                ", refreshToken='" + refreshToken + '\'' +
                ", expiresIn='" + expiresIn + '\'' +
                '}';
    }

    public SignInResponse(String localId, String email, String displayName, String idToken, String registered, String refreshToken, String expiresIn) {
        this.localId = localId;
        this.email = email;
        this.displayName = displayName;
        this.idToken = idToken;
        this.registered = registered;
        this.refreshToken = refreshToken;
        this.expiresIn = expiresIn;
    }

    public String getLocalId() {
        return localId;
    }

    public void setLocalId(String localId) {
        this.localId = localId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    public String getRegistered() {
        return registered;
    }

    public void setRegistered(String registered) {
        this.registered = registered;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
    }
}
