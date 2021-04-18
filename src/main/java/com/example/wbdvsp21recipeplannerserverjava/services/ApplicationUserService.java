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
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(email).
                stream().
                findFirst().
                orElse(null);
        if (user==null){
            try {
                throw new NameNotFoundException("User " + email + " not found.");
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

        return new ApplicationUserPrincipal(grantedAuthorities,user.getEmail(), user.getPassword());

    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public List<User> findAllUsers() {return (List<User>) userRepository.findAll();}

    public Integer findIdByEmail(String name){return userRepository.findIdByEmail(name); }

    public String findNameByEmail(String name){return userRepository.findNameByEmail(name); }

    public List<User> findUserByEmail(String name){return userRepository.findUserByEmail(name); }

    public void deleteUserById(String id) {
        userRepository.deleteById(Integer.parseInt(id));
    }

    public Integer updateUser(String id, User newUser){
        Integer userId = Integer.parseInt(id);
        if (userRepository.existsById(userId)){
            newUser.setId(userId);
            userRepository.save(newUser);
            return 1;
        }else {
            return -1;
        }
    }

}
