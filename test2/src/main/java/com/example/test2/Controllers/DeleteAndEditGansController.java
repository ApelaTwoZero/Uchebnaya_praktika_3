package com.example.test2.Controllers;

import com.example.test2.Model.PostGan;
import com.example.test2.Model.PostUser;
import com.example.test2.repo.GansRepository;
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
public class DeleteAndEditGansController {

    @Autowired
    private GansRepository gansRepository;
    @GetMapping("/blog-gan/{id}")
    public String blogDetails(@PathVariable(value = "id") long id, Model model)
    {
        Optional<PostGan> post = gansRepository.findById(id);
        ArrayList<PostGan> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        if(!gansRepository.existsById(id))
        {
            return "redirect:/blog";
        }
        return "blog-details-gan";
    }
    @GetMapping("/blog-gan/{id}/edit")
    public String blogEdit(@PathVariable("id")long id,
                           Model model)
    {
        if(!gansRepository.existsById(id)){
            return "redirect:/";
        }
        Optional<PostGan> post = gansRepository.findById(id);
        ArrayList<PostGan> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post",res);
        return "blog-edit-gan";
    }
    @PostMapping("/blog-gan/{id}/edit")
    public String blogPostUpdate(@PathVariable("id")long id,
                                 @RequestParam(value = "name") String name,
                                 @RequestParam(value = "boolets") int boolets,
                                 @RequestParam(value = "speed") double speed,
                                 @RequestParam(value = "gans_range")  int gans_range,
                                 @RequestParam(value = "disassembly") int disassembly,
                                 Model model) {

        PostGan post = gansRepository.findById(id).orElseThrow();
        post.setName(name);
        post.setBoolets(boolets);
        post.setSpeed(speed);
        post.setGans_range(gans_range);
        post.setDisassembly(disassembly);
        gansRepository.save(post);
        return "redirect:/";
    }
    @PostMapping("/blog-gan/{id}/remove")
    public String blogBlogDelete(@PathVariable("id") long id, Model model){
        PostGan post = gansRepository.findById(id).orElseThrow();
        gansRepository.delete(post);
        return "redirect:/";
    }

}
