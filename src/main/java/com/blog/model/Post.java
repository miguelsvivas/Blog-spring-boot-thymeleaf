package com.blog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Post {


    private Long id;
    private  String titulo;
    private String contenido;
    private String imagen;
    private Categoria categoria;
    private Usuario usuario;

    public Post() {
    }

    public Post(Long id, String titulo, String contenido, String imagen, Categoria categoria, Usuario usuario) {
        this.id = id;
        this.titulo = titulo;
        this.contenido = contenido;
        this.imagen = imagen;
        this.categoria = categoria;
        this.usuario = usuario;
    }


}
