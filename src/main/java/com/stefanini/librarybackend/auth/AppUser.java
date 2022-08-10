package com.stefanini.librarybackend.auth;

import com.stefanini.librarybackend.domain.User;
<<<<<<<< HEAD:src/main/java/com/stefanini/librarybackend/security/CustomUserDetails.java
import com.stefanini.librarybackend.domain.enums.Role;
import org.springframework.context.annotation.Bean;
========
import lombok.Data;
>>>>>>>> develop:src/main/java/com/stefanini/librarybackend/auth/AppUser.java
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

<<<<<<<< HEAD:src/main/java/com/stefanini/librarybackend/security/CustomUserDetails.java
========
import java.util.ArrayList;
>>>>>>>> develop:src/main/java/com/stefanini/librarybackend/auth/AppUser.java
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

<<<<<<<< HEAD:src/main/java/com/stefanini/librarybackend/security/CustomUserDetails.java
public class CustomUserDetails implements UserDetails {

    private User user;


    public CustomUserDetails(User user){
        super();
        this.user=user;
========
@Data
public class AppUser implements UserDetails {
    private final User user;

    public AppUser(User user) {
        super();
        this.user = user;
>>>>>>>> develop:src/main/java/com/stefanini/librarybackend/auth/AppUser.java
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
<<<<<<<< HEAD:src/main/java/com/stefanini/librarybackend/security/CustomUserDetails.java
        Set<GrantedAuthority> authorities = new HashSet<>();
        for (Role role : user.getRoles()) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.toString());
            authorities.add(grantedAuthority);
        }
========
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.name()));
        });
>>>>>>>> develop:src/main/java/com/stefanini/librarybackend/auth/AppUser.java
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
