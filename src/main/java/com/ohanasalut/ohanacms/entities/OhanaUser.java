package com.ohanasalut.ohanacms.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public @Data class OhanaUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String email;
    private String password;

    public OhanaUser(){}

    public OhanaUser(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
