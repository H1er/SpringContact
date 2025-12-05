package com.example.demo.JPAHibernateExamples;

import com.example.demo.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserDataServiceImpl implements UserDataService{
    @Autowired
    private UserDataRepository userRepository;

    @Override
    public UserData saveUserData(UserData user) {
        return userRepository.save(user);
    }

    @Override
    public List<UserData> getAllUserData() {
        return (List<UserData>) userRepository.findAll();
    }

    @Override
    public UserData updateUserData(UserData user, Integer id) {
        UserData dbuser = userRepository.findById(id).get();
        UserData usr;

        if (Objects.nonNull(dbuser)){  //if exists
            dbuser.setName(user.getName());
            dbuser.setRole(user.getRole());
        }

        return userRepository.save(dbuser);
    }

    @Override
    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserData getUserById(Integer id) {

        return userRepository.findById(id).isEmpty()? null : userRepository.findById(id).get() ;
    }

    public UserData getUserByName(String name){
        UserData user=new UserData();

        for(UserData usr :this.userRepository.findAll())
        {
            if (usr.getName().equals(name)){
                user=usr;
            }
        }

        return user;
    }

    @Override
    public String getPwdByName(String name) {
        UserData user=new UserData();

        for(UserData usr :this.userRepository.findAll())
        {
            if (usr.getName().equals(name)){
                user=usr;
            }
        }

        return user.getPwd();
    }
}
