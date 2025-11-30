package com.example.demo.JPAHibernateExamples;

import com.example.demo.UserData;

import java.util.List;

public interface UserDataService {
    UserData saveUserData(UserData user);

    List<UserData> getAllUserData();

    UserData updateUserData(UserData user, Integer id);

    void deleteUserById(Integer id);

    UserData getUserById(Integer id);

}
