package test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import test.dao.UserDao;
import test.entity.User;

import java.util.List;

/**
 * Created by wowa on 22.10.2018.
 */
@Controller
public class MainController {

  @Autowired
  private UserDao userDao;

   @GetMapping("/")
    public String index(Model model){

     List<User> userList = userDao.findAll();
     model.addAttribute("vseUser", userList);


       return "index";
    }

}
