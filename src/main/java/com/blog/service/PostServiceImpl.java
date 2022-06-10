package com.blog.service;

import com.blog.model.Categoria;
import com.blog.model.Post;
import com.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    PostRepository postRepository;

    @Override
    @Transactional
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Optional<Post> get(Long id) {
        return postRepository.findById(id);
    }

    @Override
    @Transactional
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
    @Transactional
    public List<Post> postsPorId() {
        
        return postRepository.findAllByOrderByIdAsc();
    }

    

}
