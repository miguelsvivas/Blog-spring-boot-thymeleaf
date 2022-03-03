package com.blog.controller;

import java.util.List;
import java.util.Optional;

import com.blog.model.Rol;
import com.blog.model.Usuario;
import com.blog.service.RolService;
import com.blog.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin-usuarios")
public class UsuarioAdminController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RolService rolService;


    @GetMapping("")
    public String listaUsuarios(Model model){

        model.addAttribute("usuarios", usuarioService.listaUsuarios());

        return "admin/user/lista-usuarios";
    }

    
    @GetMapping("/edit/{id}")
    public String editPost(@PathVariable Long id, Model model){
        Usuario usuario = new Usuario();
        Optional<Usuario> optionalPost = usuarioService.getUsuarioById(id);
        List<Rol> listaRoles = rolService.listRoles();
        usuario = optionalPost.get();

        model.addAttribute("listaRoles", listaRoles);


        model.addAttribute("usuario", usuario);

        return "admin/user/editar-usuario";
    }

    @PostMapping("/edit/save")
    public String saveUser(Usuario user){

        usuarioService.save(user);

        return "redirect:/admin-usuarios";
    }

    
    @GetMapping("/delete/{id}")
    public String eleminarUsuario(@PathVariable Long id, Model model){

        usuarioService.eliminarUsuario(id);


        return "redirect:/admin-usuarios";
    }
    
}
