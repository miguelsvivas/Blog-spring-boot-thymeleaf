package com.blog.service;


import com.blog.model.Post;

import java.util.List;

public interface PostService {

    public Post save(Post post);

    List<Post> listadoPosts();
}
