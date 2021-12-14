package com.blog.repository;

import com.blog.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    //consulta para encontrar el usuario
    Optional<Usuario> findByUsername(String username);

    boolean existsByUsername(String username);
}
