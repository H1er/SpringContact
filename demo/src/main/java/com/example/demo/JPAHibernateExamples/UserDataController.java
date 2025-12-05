package com.example.demo.JPAHibernateExamples;

import com.example.demo.UserData;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.Entity;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("api/v0/users")
public class UserDataController {
    @Autowired
    private UserDataService userDataService;

    @GetMapping("/")
    public List<UserData> getAllUserData(){
        return userDataService.getAllUserData();
    }


    @PostMapping("/")
    public ResponseEntity<String> addUserDataJSON(@RequestBody List<UserData> users){
        String retMsg="All users added OK";
        try{
            for (UserData ud : users){
                userDataService.saveUserData(ud);
            }
        }
        catch (Exception e) {
            System.out.println("Eror when inserting multiple users");
        }

        return ResponseEntity.status(HttpStatus.OK).body("Ok");
    }

    @GetMapping("/{id}")
    public UserData addUserDataParms(@PathVariable Integer id) {

        //System.out.println("Controller: "+userDataService.getUserById(id));
        return Objects.nonNull(userDataService.getUserById(id))? userDataService.getUserById(id) : new UserData();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public UserData updateUser(@RequestBody UserData user, @PathVariable Integer id){
        return userDataService.updateUserData(user, id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    public UserData updateUserPartial(@PathVariable Integer id, @RequestBody UserData partial){
        UserData updated=userDataService.getUserById(id);
        //System.out.println("Partial recieved: "+partial);
        //System.out.println("Updated before: "+updated);

        if (partial.getName() != null){
            updated.setName(partial.getName());
        }

        if (partial.getRole() != null){
            updated.setRole(partial.getRole());
        }

        //System.out.println("updated after: "+updated);
        return userDataService.updateUserData(updated,id);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public UserData deleteUserData(@PathVariable Integer id){
        userDataService.deleteUserById(id);

        return new UserData(null, null,  null);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
    }
}
