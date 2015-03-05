package com.insart.tasker.services;

import com.insart.tasker.dao.UserDAO;
import com.insart.tasker.enums.UserRole;
import com.insart.tasker.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * User: Evgeniy James
 * Date: 05.03.2015
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User u = userDAO.findByLogin(login);
        Set<GrantedAuthority> roles = new HashSet<>();
        roles.add(new SimpleGrantedAuthority(UserRole.USER.name()));
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(u.getLogin(), u.getPassword(), roles);
        return userDetails;
    }
}
