package com.blog.controller;

import java.util.List;

import com.blog.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin-usuarios")
public class UsuarioAdminController {

    @Autowired
    private UsuarioService usuarioService;


    @GetMapping("")
    public String listaUsuarios(Model model){

        model.addAttribute("usuarios", usuarioService.listaUsuarios());

        return "/admin/user/lista-usuarios";
    }
    
}
