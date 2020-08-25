package com.ohanasalut.ohanacms.Security;

import com.auth0.jwt.JWT;
import org.springframework.stereotype.Component;

import java.util.UUID;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

@Component
public class JWTProvider {

    private String secret;
    private static JWTProvider provider;

    public static JWTProvider getInstance(){
        if(provider == null) {
            provider = new JWTProvider();
        }
        return provider;
    }

    private JWTProvider(){
        this.secret = UUID.randomUUID().toString();
    }

    public String generateToken(String username){
        return JWT.create()
                .withSubject(username)
                .sign(HMAC512(this.secret.getBytes()));
    }

    public String getSecret() {
        return this.secret;
    }


}
