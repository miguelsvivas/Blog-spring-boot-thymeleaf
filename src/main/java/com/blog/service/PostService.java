package com.blog.service;


import com.blog.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {

    public Post save(Post post);

    public Optional<Post> get(Long id);

    Post postPorId(Long id);

    List<Post> listadoPosts();

    void eliminarPost(Long id);

    List<Post> postsPorId();

    
}
