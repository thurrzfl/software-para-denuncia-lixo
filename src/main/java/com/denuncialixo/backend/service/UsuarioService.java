//criado por Arthur
//data: 25/05/2026
// aqui é onde ficam as regras da aplicação.

package com.denuncialixo.backend.service;

import com.denuncialixo.backend.model.Usuario;
import com.denuncialixo.backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario cadastrarUsuario(Usuario usuario) {
        if (usuarioRepository.emailJaExiste(usuario.getEmail())) {
            throw new RuntimeException("Email já cadastrado!");
        }
       usuario.setDataCriacao(LocalDateTime.now());
        usuario.setRole(Usuario.Role.USUARIO);
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.buscarPorId(id);
    }

    public Usuario atualizarUsuario(Long id, Usuario usuarioAtualizado) {
        Usuario usuario = usuarioRepository.buscarPorId(id)
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
        usuario.setNome(usuarioAtualizado.getNome());
        usuario.setFotoPerfil(usuarioAtualizado.getFotoPerfil());
        return usuarioRepository.save(usuario);
    }

    public void deletarUsuario(Long id) {
        Usuario usuario = usuarioRepository.buscarPorId(id)
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
        usuarioRepository.delete(usuario);
    }
}