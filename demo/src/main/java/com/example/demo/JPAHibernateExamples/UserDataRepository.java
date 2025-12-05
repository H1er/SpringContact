package com.example.demo.JPAHibernateExamples;

import com.example.demo.UserData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserDataRepository extends CrudRepository<UserData, Integer> {

}
