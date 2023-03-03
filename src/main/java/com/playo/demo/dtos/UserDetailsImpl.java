package com.playo.demo.dtos;

import com.playo.demo.entities.Credential;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

public class UserDetailsImpl implements UserDetails {
    private final Credential credential;

    @Override
    public String getUsername() {
        return this.credential.getUsername();
    }

    @Override
    public String getPassword() {
        return this.credential.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Set.of(new SimpleGrantedAuthority(this.credential.getUserRoleBasedAuthority().getRole()));
    }

    @Override
    public boolean isEnabled() {
        return this.credential.getEnabled();
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.credential.getAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.credential.getAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credential.getCredentialsNonExpired();
    }

    public UserDetailsImpl(Credential credential) {
        this.credential = credential;
    }
}
