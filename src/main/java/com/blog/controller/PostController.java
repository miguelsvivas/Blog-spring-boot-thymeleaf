package com.blog.controller;


import com.blog.model.Categoria;
import com.blog.model.Post;
import com.blog.service.CategoriaService;
import com.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("posts")
public class PostController {

    @Autowired
    PostService postService;

    @Autowired
    CategoriaService categoriaService;

    @GetMapping("")
    public String home(){
        return "/admin/posts/lista-posts";
    }

    @GetMapping("/crear")
    public String createForm(Model model) {

        List<Categoria> listaCategorias = categoriaService.listadoCategoria();

        model.addAttribute("listaCategorias", listaCategorias);

        return "/admin/posts/crear-post";
    }

    @PostMapping("/save")
    public String savePost(Post post){

        postService.save(post);

       return "redirect:/posts";
    }


}
