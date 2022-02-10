package com.blog.service;

import com.blog.model.Comentario;
import com.blog.repository.ComentarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComentarioServiceImpl implements ComentarioService{

    @Autowired
    ComentarioRepository comentarioRepository;

    @Override
    public void saveComentario(Comentario comentario) {
        
         comentarioRepository.save(comentario);
        
    }

    @Override
    public void eliminarComentario(Long id) {
       comentarioRepository.deleteById(id);
        
    }

    @Override
    public Comentario buscarPorId(Long id) {
        return comentarioRepository.findById(id).orElse(null);
    }

    
    
}
