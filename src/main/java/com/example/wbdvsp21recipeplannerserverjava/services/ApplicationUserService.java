package com.example.wbdvsp21recipeplannerserverjava.services;

import com.example.wbdvsp21recipeplannerserverjava.auth.ApplicationUserPrincipal;
import com.example.wbdvsp21recipeplannerserverjava.models.User;
import com.example.wbdvsp21recipeplannerserverjava.models.UserRole;
import com.example.wbdvsp21recipeplannerserverjava.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.naming.NameNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ApplicationUserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findUserByUserName(userName).
                stream().
                findFirst().
                orElse(null);
        if (user==null){
            try {
                throw new NameNotFoundException("User " + userName + " not found.");
            } catch (NameNotFoundException e) {
                e.printStackTrace();
            }
        }

        List<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();
        if (user.getRole().equals(UserRole.CREATOR.toString())){
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + UserRole.CREATOR.toString()));
        }else {
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + UserRole.SHOPPER.toString()));
        }

        return new ApplicationUserPrincipal(grantedAuthorities,user.getUsername(), user.getPassword());

    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public List<User> findAllUsers() {return (List<User>) userRepository.findAll();}

    public Integer findIdByUsername(String name){return userRepository.findIdByUsername(name); }
}
