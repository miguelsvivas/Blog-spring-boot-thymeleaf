package com.blog.service;

import com.blog.model.Categoria;
import com.blog.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.transaction.Transactional;

@Service
public class CategoriaServiceImpl implements CategoriaService{

    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public void eliminarCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }

    @Override
    public List<Categoria> listadoCategoria() {

     

        return categoriaRepository.findAll();
    }

    @Override
    @Transactional
    public Categoria categoriaPorId(Long id) {
        
        return categoriaRepository.findById(id).orElse(null);
    }
}
