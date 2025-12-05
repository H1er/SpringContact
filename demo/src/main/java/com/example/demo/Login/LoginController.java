package com.example.demo.Login;

import com.example.demo.JPAHibernateExamples.UserDataService;
import com.example.demo.UserData;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/sec")
public class LoginController {

    @Autowired
    private PasswordEncoder pwdEncoder;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserDataService userData;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public RedirectView processLogin(@RequestParam String username,
                                     @RequestParam String password) {

        UserData user = this.userData.getUserByName(username);
        RedirectView rdw = new RedirectView("/index.html");

        if (user.getId()!=null) //user exists
        {
            if (pwdEncoder.matches(password, userData.getPwdByName(username))){ //both pwds match
                rdw = new RedirectView("/loginPage.html");
            }
        }

        return rdw;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String getRegisterUserPage(){

        System.out.println("Register endpoint called");

        return "register.html";
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public RedirectView doRegisterUser(@RequestParam String username,
                                 @RequestParam String password,
                                 @RequestParam String password2){

        UserData user = this.userData.getUserByName(username);
        RedirectView rdw = new RedirectView("/index.html");

        System.out.println("User after find by name: "+user);

        if (user.getId()==null) //new user
        {
            if (password.equals(password2)){ //both pwds match
                String hashedPwd = this.pwdEncoder.encode(password);
                UserData newUser = new UserData(username, "Basic", hashedPwd);
                this.userData.saveUserData(newUser);
                rdw = new RedirectView("/loginPage.html");
            }
        }

        return rdw;

    }
}
