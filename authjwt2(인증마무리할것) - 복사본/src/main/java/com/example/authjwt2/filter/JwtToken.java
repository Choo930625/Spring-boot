package com.example.authjwt2.filter;

import java.io.Serializable;

public class JwtToken implements Serializable {
    private static final long serialVersionUID = 5926468583005150707L;
    private String token;

    //need default constructor for JSON Parsing
    public JwtToken() {
    }

    public JwtToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
