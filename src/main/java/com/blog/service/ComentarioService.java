package com.blog.service;

import com.blog.model.Comentario;

public interface ComentarioService {

    void saveComentario(Comentario comentario);

    void eliminarComentario(Long id);

    //devuleve un objeto comentario buscado por el id
    Comentario buscarPorId(Long id);


}