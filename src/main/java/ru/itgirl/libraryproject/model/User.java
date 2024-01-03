package ru.itgirl.libraryproject.model;

import jakarta.persistence.*;
import lombok.*;

import java.awt.geom.QuadCurve2D;
import java.security.SecureRandom;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String email;
}
