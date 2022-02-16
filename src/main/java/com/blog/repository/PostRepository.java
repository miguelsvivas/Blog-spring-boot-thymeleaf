package com.blog.repository;

import java.util.List;


import com.blog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

    //  List<Post> findByCategoria(Categoria categoria);
     
     public List<Post> findAllByOrderByIdAsc();

}
