package com.example.test2.Controllers;

import com.example.test2.Model.PostUser;
import com.example.test2.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/blog/filterus")
    public String blogFilterUser(Model model)
    {
        Iterable<PostUser> posts = userRepository.findAll();
        model.addAttribute("result", posts);
        return "blog-filter-user";
    }
    @PostMapping("/blog/filterus/result")
    public String blogUserResult(@RequestParam String surname, Model model) {
        List<PostUser> result = userRepository.findBySurname(surname);
        model.addAttribute("result", result);
        return "blog-filter-user";}
    @GetMapping("/blog/all-users")
    public String blogUsers(Model model) {
        Iterable<PostUser> posts = userRepository.findAll();
        model.addAttribute("posts", posts);
        return "all-users";}
    @GetMapping("/blog/users")
    public String blogUsersAdd(Model model)
    {
        return "users";
    }
    @PostMapping("/create-user")
    public String createUser(@RequestParam(value = "name") String name, @RequestParam(value = "surname") String surname, @RequestParam(value = "midlname") String midlname, @RequestParam(value = "age")  int age, @RequestParam(value = "growth") int growth, @RequestParam(value = "weight") double weight, Model model) {
        PostUser postuser = new PostUser(name,surname,midlname, age,growth,weight);
        userRepository.save(postuser);
        return "redirect:/blog/all-users";}
}
