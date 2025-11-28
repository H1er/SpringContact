package com.example.demo.dependencyInjectionExamples;

import com.example.demo.UserData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v0/users")
public class UserController {
    @GetMapping
    public List<UserData> getUsersList(){
        return List.of(
                new UserData(
                        1,
                        "Antonio",
                        "admin"
                ),
                new UserData(
                        2,
                        "Juan",
                        "basic"
                )
        );
    }
}
