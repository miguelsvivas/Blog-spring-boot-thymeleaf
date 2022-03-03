package com.blog.controller;


import com.blog.model.Categoria;
import com.blog.model.Post;
import com.blog.model.Usuario;
import com.blog.service.CategoriaService;
import com.blog.service.PostService;
import com.blog.service.UsuarioService;

import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.time.LocalDate;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/admin-posts")
public class PostController {

    @Autowired
    PostService postService;

    @Autowired
    CategoriaService categoriaService;

    @Autowired
    UsuarioService usuarioService;


    @GetMapping("")
    public String home(Model model){

        

        model.addAttribute("posts", postService.postsPorId());

        model.addAttribute("listaCategorias", categoriaService.listadoCategoria());


        return "/admin/posts/lista-posts";
    }

    @GetMapping("/crear")
    public String createForm(Model model) {

        List<Categoria> listaCategorias = categoriaService.listadoCategoria();

        model.addAttribute("listaCategorias", listaCategorias);

        return "/admin/posts/crear-post";
    }

    @PostMapping("/admin-posts/crear/save")
    public String savePost(@RequestParam(name = "file", required = false) MultipartFile imagen, Post post,
     RedirectAttributes redirect,Authentication auth){


        

        if(!imagen.isEmpty()) {
            String ruta = "C://Users//MIGUEL//Documents//blog//uploads";
            String nombreUnico = UUID.randomUUID()+ "img" + imagen.getOriginalFilename();

            String nombreUsuario = auth.getName();

            Usuario user = usuarioService.getByUsername(nombreUsuario).get();


            Usuario usuario = new Usuario(user.getId());

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
       return "redirect:/admin-posts";
    }


    @GetMapping("/edit/{id}")
    public String editPost(@PathVariable Long id, Model model){
        Post post = new Post();
        Optional<Post> optionalPost = postService.get(id);
        post = optionalPost.get();


        model.addAttribute("post", post);

        model.addAttribute("listaCategorias", categoriaService.listadoCategoria());

        return "/admin/posts/editar-post";
    }

    @PostMapping("/update")
    public String editarPost(@RequestParam(name="file")MultipartFile imagenPortada,
                             @ModelAttribute("post") Post post, Model model){
        Post p = new Post();
        p = postService.get(post.getId()).get();



        Usuario usuario = new Usuario(2L);
        post.setFecha(p.getFecha());
        post.setUsuario(usuario);


        if(imagenPortada.isEmpty()){
            post.setImagen(p.getImagen());
            postService.save(post);
        }

        if(!imagenPortada.isEmpty()) {
            String ruta = "C://Users//MIGUEL//Documents//blog//uploads";
            String nombreUnico = UUID.randomUUID()+ "img" + imagenPortada.getOriginalFilename();


            try {
                byte[] bytes = imagenPortada.getBytes();
                Path rutaAbsoluta = Paths.get(ruta + "//" + nombreUnico);
                Files.write(rutaAbsoluta, bytes);
                post.setImagen(nombreUnico);

                postService.save(post);



            }catch (Exception e) {
                e.getCause().getMessage();

            }

        }



        return "redirect:/admin-posts";
    }

    @GetMapping("/delete/{id}")
    public String eleminarPost(@PathVariable Long id, Model model){

        postService.eliminarPost(id);


        return "redirect:/posts";
    }



}
