package com.example.wbdvsp21recipeplannerserverjava.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


public class ApplicationUserPrincipal implements UserDetails {


    private final List<? extends GrantedAuthority> grantedAuthorities;
    private final String password;
    private final String email;
    private final boolean isAccountNonExpired;
    private final boolean isAccountNonLocked;
    private final boolean isCredentialsNonExpired;
    private final boolean isEnabled;

    public ApplicationUserPrincipal(List<? extends GrantedAuthority> grantedAuthorities, String email, String password) {
        this.grantedAuthorities = grantedAuthorities;
        this.password = password;
        this.email = email;
        this.isAccountNonExpired = true;
        this.isAccountNonLocked = true;
        this.isCredentialsNonExpired = true;
        this.isEnabled = true;
    }

    public ApplicationUserPrincipal(List<? extends GrantedAuthority> grantedAuthorities,
                                    String email,
                                    String password,
                                    boolean isAccountNonExpired,
                                    boolean isAccountNonLocked,
                                    boolean isCredentialsNonExpired,
                                    boolean isEnabled) {

        this.grantedAuthorities = grantedAuthorities;
        this.password = password;
        this.email = email;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
        this.isEnabled = isEnabled;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    public String getEmail() { return this.email; }

    @Override
    public boolean isAccountNonExpired() {
        return this.isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.isEnabled;
    }
}
