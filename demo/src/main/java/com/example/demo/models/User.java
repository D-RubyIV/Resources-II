package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserId")
    private Long id;

    @Column(name = "Username", unique = true, nullable = false)
    private String username;

    @Column(name = "Password", nullable = false)
    private String password;

    @Column(name = "Created")
    @JsonDeserialize
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate created;

    @Column(name = "Email")
    private String email;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "UserStatus")
    private boolean userStatus;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "User_Role",
            joinColumns = @JoinColumn(name = "UserId"),
            inverseJoinColumns = @JoinColumn(name = "RoleId")
    )
    private Set<Role> listRole = new HashSet<>();




}
