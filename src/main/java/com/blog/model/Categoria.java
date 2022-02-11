package com.blog.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "categoria")
	private List<Post> posts;



    public Categoria() {
    }

   

    public Categoria(Long id, String nombre, String descripcion, List<Post> posts) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.posts = posts;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }



    public List<Post> getPosts() {
        return posts;
    }



    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    
}
