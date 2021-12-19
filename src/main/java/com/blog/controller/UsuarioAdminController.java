package com.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/usuarios")
public class UsuarioAdminController {

    @GetMapping("")
    public String listaUsuarios(){

        return "/admin/user/lista-usuarios";
    }
    
}
