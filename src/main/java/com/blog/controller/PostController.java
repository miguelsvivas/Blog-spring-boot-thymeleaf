package com.blog.controller;


import com.blog.model.Categoria;
import com.blog.model.Post;
import com.blog.model.Usuario;
import com.blog.service.CategoriaService;
import com.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.time.LocalDate;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("posts")
public class PostController {

    @Autowired
    PostService postService;

    @Autowired
    CategoriaService categoriaService;

    @GetMapping("")
    public String home(Model model){

        model.addAttribute("posts", postService.listadoPosts());



        return "/admin/posts/lista-posts";
    }

    @GetMapping("/crear")
    public String createForm(Model model) {

        List<Categoria> listaCategorias = categoriaService.listadoCategoria();

        model.addAttribute("listaCategorias", listaCategorias);

        return "/admin/posts/crear-post";
    }

    @PostMapping("/save")
    public String savePost(@RequestParam(name = "file", required = false) MultipartFile imagen, Post post, RedirectAttributes redirect){

        if(!imagen.isEmpty()) {
            String ruta = "C://Users//MIGUEL//Documents//blog//uploads";
            String nombreUnico = UUID.randomUUID()+ "img" + imagen.getOriginalFilename();
            Usuario usuario = new Usuario(1L);

            try {

                byte[] bytes = imagen.getBytes();
                Path rutaAbsoluta = Paths.get(ruta + "//" + nombreUnico);
                Files.write(rutaAbsoluta, bytes);
                post.setImagen(nombreUnico);
                post.setFecha( LocalDate.now());
                post.setUsuario(usuario);


                postService.save(post);

            }catch(Exception e) {

                e.getCause().getMessage();
            }
        }




       return "redirect:/posts";
    }


}
