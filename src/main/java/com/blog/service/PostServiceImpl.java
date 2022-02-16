package com.blog.service;

import com.blog.model.Categoria;
import com.blog.model.Post;
import com.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    PostRepository postRepository;

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Optional<Post> get(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public List<Post> listadoPosts() {

        return postRepository.findAll();
    }

    @Override
    public void eliminarPost(Long id) {
        postRepository.deleteById(id);
    }

    @Override
    public Post postPorId(Long id) {


        return postRepository.findById(id).orElse(null);
   
    }

    @Override
    public List<Post> postsPorId() {
        
        return postRepository.findAllByOrderByIdAsc();
    }

    

}
