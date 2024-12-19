package com.restApi.RestApi.Basics.dto;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;
import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {

    private String email;
    private String password;
    private boolean isActive;
    private Long userId;  // Benutzer-ID

    // Konstruktor
    public CustomUserDetails(String email, String password, boolean isActive, Long userId) {
        this.email = email;
        this.password = password;
        this.isActive = isActive;
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Hier kannst du Benutzerrollen hinzufügen, falls erforderlich
        return List.of(); // Standard: keine Rollen
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isActive;  // Hier entscheiden wir, ob das Konto gesperrt ist
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive;  // Konto ist aktiv, wenn isActive true ist
    }
}