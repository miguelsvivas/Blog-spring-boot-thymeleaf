package com.blog.controller;

import com.blog.model.Categoria;
import com.blog.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin-categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("")
    public String categorias(Model model){

        model.addAttribute("categorias", categoriaService.listadoCategoria());

        return "/admin/listar-categorias";
    }

    @GetMapping("/crear")
    public String categoriaform(){

        return "/admin/crear-categoria";
    }



    @PostMapping("admin-categorias/crear/save")
    public String guardarCategoria(Categoria categoria, RedirectAttributes redirect){

        categoriaService.save(categoria);
        return "redirect:/admin-categorias";
    }

    @PostMapping("/update")
    public String editarCategoria(Categoria categoria){

        categoriaService.save(categoria);

        return "redirect:/admin-categorias";
    }


    @GetMapping("/delete/{id}")
    public String eleminarCategoria(@PathVariable Long id, Model model){

        categoriaService.eliminarCategoria(id);

        return "redirect:admin/categorias";
    }


}
