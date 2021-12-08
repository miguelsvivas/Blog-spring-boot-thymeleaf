package com.blog.model;

import java.util.List;

public class Usuario {

    private Long id;
    private String nombre;
    private String correo;
    private List<Post> posts;


    public Usuario() {
    }

    public Usuario(Long id, String nombre, String correo, List<Post> posts) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.posts = posts;
    }



}
