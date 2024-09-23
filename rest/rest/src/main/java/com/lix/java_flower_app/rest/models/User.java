package com.lix.java_flower_app.rest.models;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String role;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private int age;
    @Column
    private String occupation;
    @Column
    private String email;
    @Column
    private String password;

    public long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() { return this.role; }
    public void setRole(String role) { this.role = role; }

    public String getFirstName() {
        return this.firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getOccupation() {
        return this.occupation;
    }
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getEmail() {return this.email;}
    public void setEmail(String email) {this.email = email;}

    public String getPassword() {return this.password;}
    public void setPassword(String password) {this.password = password;}
}
