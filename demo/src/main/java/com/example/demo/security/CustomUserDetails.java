package com.example.demo.security;

import com.example.demo.models.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class CustomUserDetails implements UserDetails {
    private Long id;
    private String username;
    @JsonIgnore
    private String password;
    private LocalDate created;
    private String email;
    private String phone;
    private boolean userStatus;
    private Collection<? extends  GrantedAuthority> authorities;

    //Từ thông tin của User chuyển sang UserDetails
    public static CustomUserDetails mapUserToUserDetail(User user){

        //Lấy líst authorities
        List<GrantedAuthority> listAuth = user.getListRole().stream().map(
                s -> new SimpleGrantedAuthority(s.getName().name())
        ).collect(Collectors.toList());
        //Return lại CustomUserDetails
        return new CustomUserDetails(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getCreated(),
                user.getEmail(),
                user.getPhone(),
                user.isUserStatus(),
                listAuth
        );
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
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
