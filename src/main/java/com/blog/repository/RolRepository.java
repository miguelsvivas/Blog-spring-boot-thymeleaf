package com.blog.repository;

import com.blog.model.RolNombre;
import com.blog.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {

    Optional<Rol> findByRolNombre(RolNombre rolNombre);

    boolean existsByRolNombre(RolNombre rolNombre);
}
