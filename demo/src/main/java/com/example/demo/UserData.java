package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String role;
    private String pwd;

    public UserData(String name, String role, String pwd){
        this.role=role;
        this.name=name;
        this.pwd=pwd;
    }

    public String toString() {
        return "ID: "+this.id+", NAME: "+this.name+", ROLE: "+this.role;
    }

}
