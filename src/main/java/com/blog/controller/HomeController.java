package com.blog.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import com.blog.model.Categoria;
import com.blog.model.Comentario;
import com.blog.model.Post;
import com.blog.model.Usuario;
import com.blog.service.CategoriaService;
import com.blog.service.ComentarioService;
import com.blog.service.PostService;
import com.blog.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;



@Controller
@RequestMapping("")
@SessionAttributes("comentario")
public class HomeController {

    @Autowired
    PostService postService;

    @Autowired
    ComentarioService comentarioService;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    CategoriaService categoriaService;

    @GetMapping("")
    public String home(Model model,Authentication auth){

        if(auth != null){
        String username = auth.getName();
        model.addAttribute("username", username);
        }
        
        
        
        model.addAttribute("categorias", categoriaService.listadoCategoria());
        model.addAttribute("posts", postService.listadoPosts());

        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/post/{id}")
    public String mostrarPost(@PathVariable Long id,Model model,Authentication auth){

        if(auth != null) {
			String username = auth.getName();
			model.addAttribute("username",username);
			
		}

        

        Post post = postService.postPorId(id);
		
		Comentario comentario = new Comentario();
		
		comentario.setPost(post);

        model.addAttribute("categorias", categoriaService.listadoCategoria());
        model.addAttribute("comentario", comentario);
        model.addAttribute("post", post);


        return "post";
    }

    @GetMapping("/categoria/{id}")
    public String mostrarCategoria(@PathVariable Long id,Model model,Authentication auth){

        Categoria categoria = categoriaService.categoriaPorId(id);



        
        model.addAttribute("categoria", categoria);


        return "categoria";
    }

    @PostMapping("/post/guardar-comentario")
    public String guardarComentario(Comentario comentario, Authentication auth,
                    HttpSession session){
                
        String user = auth.getName();
        Optional<Usuario> usuario = usuarioService.getByUsername(user);
         
        comentario.setUsuario(usuario.get());

        comentarioService.saveComentario(comentario);

        

        return "redirect:/";
    }

    @GetMapping("/post/borrar-comentario/{id}")
    public String eleminarCategoria(@PathVariable Long id, Model model){

        comentarioService.eliminarComentario(id);

        return "redirect:/";
    }

    
    @PostMapping("/post/actualizar-comentario")
    public String editarCategoria(Comentario comentario,Authentication auth){

        String user = auth.getName();
        Optional<Usuario> usuario = usuarioService.getByUsername(user);
         
        comentario.setUsuario(usuario.get());

        comentarioService.saveComentario(comentario);

        return "redirect:/";
    }

    
}
