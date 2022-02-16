package com.blog.service;

import com.blog.model.Usuario;
import com.blog.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listaUsuarios(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> getUsuarioById(Long id){
        return usuarioRepository.findById(id);
    }

    public Optional<Usuario> getByUsername(String username){
        return usuarioRepository.findByUsername(username);
    }

    public Usuario buscarUsuarioPorNombre(String username){
        return usuarioRepository.findByUsername(username).orElse(null);
    }

    public void save(Usuario usuario){
        usuarioRepository.save(usuario);
    }

    public boolean existsById(Long id){
        return usuarioRepository.existsById(id);
    }

    public boolean existsByUsername(String username){
        return usuarioRepository.existsByUsername(username);
    }

    
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    
}
