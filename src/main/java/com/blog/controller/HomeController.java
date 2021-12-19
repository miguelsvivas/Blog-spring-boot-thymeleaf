package com.blog.controller;

import java.util.Optional;

import com.blog.model.Post;
import com.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HomeController {

    @Autowired
    PostService postService;

    @GetMapping("")
    public String home(Model model,Authentication auth){

        if(auth != null){
        String username = auth.getName();
        model.addAttribute("username", username);
        }    
        model.addAttribute("posts", postService.listadoPosts());

        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/post/{id}")
    public String mostrarPost(@PathVariable Long id,Model model){

        Post post = new Post();
        Optional<Post> optional = postService.get(id);

        post = optional.get();

        model.addAttribute("post", post);


        return "post";
    }
    
}
