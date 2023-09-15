package com.example.demo.models;


import com.example.demo.enums.ERole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RoleId")
    private Long id;

    @Column(name = "RoleName")
    @Enumerated(EnumType.STRING)
    private ERole name;


}
