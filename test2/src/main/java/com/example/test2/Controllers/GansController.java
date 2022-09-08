package com.example.test2.Controllers;

import com.example.test2.Model.PostGan;
import com.example.test2.repo.GansRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class GansController {
    @Autowired
    private GansRepository gansRepository;
    @GetMapping("/blog/filtergan")
    public String blogFilterGan(Model model)
    {
        Iterable<PostGan> posts = gansRepository.findAll();
        model.addAttribute("result", posts);
        return "blog-filter-gans";
    }
    @PostMapping("/blog/filtergan/result")
    public String blogGansResult(@RequestParam String name, Model model) {
        List<PostGan> result = gansRepository.findByName(name);
        model.addAttribute("result", result);
        return "blog-filter-gans";}
    @PostMapping("/blog/filtergan/result2")
    public String blogGansResult2(@RequestParam String name, Model model) {
        List<PostGan> result = gansRepository.findByNameContains(name);
        model.addAttribute("result", result);
        return "blog-filter-gans";}
    @GetMapping("/blog/gans")
    public String blogGansAdd(Model model)
    {
        return "gans";
    }
    @PostMapping("/create-gan")
    public String createGan(@RequestParam(value = "name") String name, @RequestParam(value = "boolets") int boolets, @RequestParam(value = "speed") double speed, @RequestParam(value = "range")  int range, @RequestParam(value = "disassembly") int disassembly, Model model) {
        PostGan postgan = new PostGan(name,boolets,speed, range,disassembly);
        gansRepository.save(postgan);
        return "redirect:/blog/all-gans";}
    @GetMapping("/blog/all-gans")
    public String blogGans(Model model) {
        Iterable<PostGan> posts = gansRepository.findAll();
        model.addAttribute("posts", posts);
        return "all-gans";}
}
