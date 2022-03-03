package com.blog.controller;

import com.blog.model.Rol;
import com.blog.model.RolNombre;
import com.blog.model.Usuario;
import com.blog.service.RolService;
import com.blog.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;



import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

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
    public String register(Model model){

        Usuario usuario = new Usuario();

        model.addAttribute("usuario", usuario);
        return "registro";
    }

    @PostMapping("/save")
    public String saveUser(@Valid Usuario usuario, BindingResult resultado, String username,String password,Model model){

        if(resultado.hasErrors()){

            model.addAttribute("usuario", usuario);

           return "registro";
        }

        
        usuario.setUsername(username);
        usuario.setPassword(passwordEncoder.encode(password));
        
        Rol rolUser = rolService.getByRolNombre(RolNombre.ADMIN).get();
        //Rol rolUser = rolService.getByRolNombre(RolNombre.USER).get();

        Set<Rol> roles = new HashSet<Rol>();

        
        // roles.add(rolUser1);
        roles.add(rolUser);

        usuario.setRoles(roles);

        

        usuarioService.save(usuario);

        

        return "redirect:/login";
    }

}
