package com.example.authjwt2.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name= "token")
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
