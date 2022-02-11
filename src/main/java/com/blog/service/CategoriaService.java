package com.blog.service;

import com.blog.model.Categoria;

import java.util.List;

public interface CategoriaService {

    public Categoria save(Categoria categoria);

    void eliminarCategoria(Long id);

    List<Categoria> listadoCategoria();

    Categoria categoriaPorId(Long id);


}
