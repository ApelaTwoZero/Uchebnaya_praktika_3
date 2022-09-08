package com.example.test2.Controllers;

import com.example.test2.Model.PostUser;
import com.example.test2.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class DeleteAndEditController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/blog/{id}")
    public String blogDetails(@PathVariable(value = "id") long id, Model model) {
        Optional<PostUser> post = userRepository.findById(id);
        ArrayList<PostUser> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        if(!userRepository.existsById(id)) {return "redirect:/blog";}
        return "blog-details";}
    @GetMapping("/blog/{id}/edit")
    public String blogEdit(@PathVariable("id")long id, Model model)
    {if(!userRepository.existsById(id)){return "redirect:/";}
        Optional<PostUser> post = userRepository.findById(id);
        ArrayList<PostUser> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post",res);
        return "blog-edit";
    }
    @PostMapping("/blog/{id}/edit")
    public String blogPostUpdate(@PathVariable("id")long id, @RequestParam(value = "name") String name, @RequestParam(value = "surname") String surname, @RequestParam(value = "midlname") String midlname, @RequestParam(value = "age")  int age,
                                 @RequestParam(value = "growth") int growth,
                                 @RequestParam(value = "weight") double weight,
                                 Model model) {
        PostUser post = userRepository.findById(id).orElseThrow();
        post.setName(name);
        post.setSurname(surname);
        post.setMidlname(midlname);
        post.setAge(age);
        post.setGrowth(growth);
        post.setWeight(weight);
        userRepository.save(post);
        return "redirect:/";}
    @PostMapping("/blog/{id}/remove")
    public String blogBlogDelete(@PathVariable("id") long id, Model model){
        PostUser post = userRepository.findById(id).orElseThrow();
        userRepository.delete(post);
        return "redirect:/";}}
