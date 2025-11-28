package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class UserData {
    @Id
    private Integer id;
    private String name;
    private String role;

    public UserData() {
    }

    public UserData(Integer id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserData user = (UserData) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, role);
    }

}
