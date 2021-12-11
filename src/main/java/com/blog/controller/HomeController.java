package com.blog.controller;

import com.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HomeController {

    @Autowired
    PostService postService;

    @GetMapping("")
    public String home(Model model){

        model.addAttribute("posts", postService.listadoPosts());

        return "index";
    }
    
}
