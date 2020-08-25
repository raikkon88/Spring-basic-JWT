package com.ohanasalut.ohanacms.entities.raw;

import lombok.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserLogin  {

    private String email;
    private String password;

    public UserLogin(){}

    public UserLogin(String email, String password){
        this.email = email;
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public String getEmail() {
        return this.email;
    }
}
