package com.blog.service;

import com.blog.model.RolNombre;
import com.blog.model.Rol;
import com.blog.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    public void saveRole(Rol rol){
        rolRepository.save(rol);
    }

    public void guardarRol(Rol rol) {
       rolRepository.save(rol);

    }

    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return rolRepository.findByRolNombre(rolNombre);
    }

    public boolean existsByRrolNombre(RolNombre rolNombre) {
        return rolRepository.existsByRolNombre(rolNombre);
    }
}
