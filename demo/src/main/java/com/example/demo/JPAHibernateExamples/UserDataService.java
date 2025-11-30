package com.example.demo.JPAHibernateExamples;

import com.example.demo.UserData;

import java.util.List;

public interface UserDataService {
    public UserData saveUserData(UserData user);

    public List<UserData> getAllUserData();

    public UserData updateUserData(UserData user, Integer id);

    public void deleteUserById(Integer id);
}
