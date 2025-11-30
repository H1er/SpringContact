package com.example.demo.JPAHibernateExamples;

import com.example.demo.UserData;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.List;

@RestController
@RequestMapping("api/v0/crudRepository")
public class UserDataController {
    @Autowired
    private UserDataService userDataService;

    @GetMapping("/getall")
    public List<UserData> getAllUserData(){
        return userDataService.getAllUserData();
    }

    @PostMapping("/addsingleuserJSON")
    public  UserData addUserDataJSON(@RequestBody UserData user){
        return userDataService.saveUserData(user);
    }

    @PostMapping("/addlistusersJSON")
    public String addUserDataJSON(@RequestBody List<UserData> users){
        String retMsg="All users added OK";
        try{
            for (UserData ud : users){
                userDataService.saveUserData(ud);
            }
        }
        catch (Exception e) {
            retMsg= "Error when inserting multiple users";
        }

        return retMsg;
    }

    @PostMapping("/addsingleuserParms")
    public UserData addUserDataParms(@RequestParam("name") String name,
                                     @RequestParam("role") String role) {
        UserData ud = new UserData(name, role);
        return userDataService.saveUserData(ud);
    }

    @RequestMapping(value = "/{id}/updateUser", method = RequestMethod.PUT)
    public UserData updateUser(@RequestBody UserData user, @PathVariable Integer id){
        return userDataService.updateUserData(user, id);
    }

    @RequestMapping(value = "/{id}/updateUserVal", method = RequestMethod.PUT)
    public ResponseEntity<String> updateUservalidated(@PathVariable Integer id, @Validated @RequestBody UserData user, BindingResult result){
        if (result.hasErrors()){
            return ResponseEntity.badRequest().body("Bad validation");
        }

        userDataService.updateUserData(user,id);

        return ResponseEntity.ok("OK");
    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public UserData deleteUserData(@PathVariable Integer id){
        userDataService.deleteUserById(id);

        return new UserData(null, null);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
    }
}
