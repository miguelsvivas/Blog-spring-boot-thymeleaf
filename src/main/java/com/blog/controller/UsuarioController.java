package com.blog.controller;

import com.blog.model.Rol;
import com.blog.model.RolNombre;
import com.blog.model.Usuario;
import com.blog.service.RolService;
import com.blog.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RolService rolService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("/registro")
    public String register(){

        return "registro";
    }

    @PostMapping("/save")
    public String saveUser(String username,String password){

        Usuario user = new Usuario();

        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        Rol rolUser = rolService.getByRolNombre(RolNombre.ADMIN).get();

        Set<Rol> roles = new HashSet<Rol>();

        roles.add(rolUser);

        user.setRoles(roles);

        usuarioService.save(user);

        return "redirect:/login";
    }

}
