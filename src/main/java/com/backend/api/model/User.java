package com.backend.api.model;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import com.backend.api.model.enums.Roles;
import com.backend.api.model.enums.Status;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity(name = "USERS")
@Table(
    name = "users",
    indexes = @Index(name = "idx_email", columnList = "email", unique=true)
)
public class User {
    private Long id;
    private String name;
    private String email;
    private String password;
    private Status status;
    private Roles role;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public User() {
    }

    public User(Long id, String name, String email, String password, Status status, Roles role, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.status = status;
        this.role = role;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    @Column()
    public String getName() {
        return name;
    }

    @Column(unique = true)
    public String getEmail() {
        return email;
    }

    @Column()
    public String getPassword() {
        return password;
    }

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('ACTIVE', 'DEACTIVE', 'BANNED') DEFAULT 'ACTIVE'")
    public Status getStatus() {
        return status;
    }

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('SUPER_ADMIN', 'ADMIN', 'USER') DEFAULT 'USER'")
    public Roles getRole() {
        return role;
    }

    @CreationTimestamp
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @UpdateTimestamp
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void setStatus(Status status) {
        this.status = status;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
