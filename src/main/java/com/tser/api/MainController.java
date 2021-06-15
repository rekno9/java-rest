package com.tser.api;

import com.tser.dao.entities.User;
import com.tser.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/db_veiksmai")
public class MainController {
    @Autowired
    MainService mainService;

    @PostMapping("/add_user")
    public @ResponseBody String addNewUser(@RequestParam String userName, @RequestParam String password){
        return mainService.addNewUser(userName, password);
    }

    @GetMapping("/get_users")
    public @ResponseBody Iterable<User> getUsers(){
        return mainService.getUsers();
    }

    @GetMapping("/get_by_username")
    public String getUserByName(@RequestParam String userName, Model model){
        User tempUser = mainService.getUserByName(userName);
        model.addAttribute("userName", tempUser.getUserName());
        model.addAttribute("roles", tempUser.getRoles());
        model.addAttribute("password", tempUser.getPassword());
        return "show_user";
    }

    @GetMapping("/get_by_username_contains")
    public @ResponseBody List<User> getUserByNameContains(@RequestParam String userName){
        return mainService.getUserByNameContains(userName);
    }

    @PostMapping("/req_user")
    public @ResponseBody String reqUser(@RequestParam String userName, @RequestParam String password){
        return mainService.addNewUser(userName, password);
        //return "inside reqUser" + "\n" + userName +"\n" + password;
    }
}
