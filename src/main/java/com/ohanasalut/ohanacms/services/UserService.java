package com.ohanasalut.ohanacms.services;

import com.ohanasalut.ohanacms.entities.OhanaUser;
import com.ohanasalut.ohanacms.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Value("${env.ohana.admin}")
    private String adminUsername;

    @Value("${env.ohana.password}")
    private String adminPassword;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public OhanaUser getUser(String email) {
        Optional<OhanaUser> user = userRepository.findByEmail(email);
        return user.orElse(null);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void init() {

        System.out.println("Username : " + adminUsername);
        System.out.println("Password : " + adminPassword);

        OhanaUser user = getUser(adminUsername);
        if(user == null) {
            user = new OhanaUser(adminUsername, bCryptPasswordEncoder.encode(adminPassword));
            userRepository.save(user);
        }
    }

}
