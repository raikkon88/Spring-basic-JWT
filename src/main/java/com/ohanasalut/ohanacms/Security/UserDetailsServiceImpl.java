package com.ohanasalut.ohanacms.Security;

import com.ohanasalut.ohanacms.entities.OhanaUser;
import com.ohanasalut.ohanacms.entities.raw.UserLogin;
import com.ohanasalut.ohanacms.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;


/**
 * Custom User class to manage token authentication and users. (combine userdetailsservice and application user entity)
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        OhanaUser stored = userService.getUser(email);
        if (stored==null) {
            throw new UsernameNotFoundException(email);
        }
        return new User(stored.getEmail(), stored.getPassword(), Collections.emptyList());
    }


}