package com.diansetiyadi.springsecurity.entity;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @Email(message = "*Please gunakan format email @ ")
    @NotEmpty(message = "*Mohon di isi!")
    @Column(name = "email")
    private String email;

    @Length(min = 5, message = "*Password harus lebih dari 5 karakter")
    @NotEmpty(message = "*Mohon di isi!")
    @Column(name = "password")
    @Transient
    private String password;

    @NotEmpty(message = "*Mohon di isi!")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "*Mohon di isi!")
    @Column(name = "last_name")
    private String lastName;


    @Column(name = "activate")
    private boolean activate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id")
            , inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public boolean isActivate() {
        return activate;
    }

    public void setActivate(boolean activate) {
        this.activate = activate;
    }
}
