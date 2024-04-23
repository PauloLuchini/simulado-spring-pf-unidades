package br.com.fiap.simuladospringpfunidades.service;

import br.com.fiap.simuladospringpfunidades.dto.request.UsuarioRequest;
import br.com.fiap.simuladospringpfunidades.dto.response.UsuarioResponse;
import br.com.fiap.simuladospringpfunidades.entity.Usuario;
import br.com.fiap.simuladospringpfunidades.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService implements ServiceDTO<Usuario, UsuarioRequest, UsuarioResponse> {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario toEntity(UsuarioRequest request) {
        return Usuario.builder()
                .username(request.username())
                .password(request.password())
                .pessoa(request.pessoaId())
                .build();
    }

    @Override
    public UsuarioResponse toResponse(Usuario usuario) {
        return new UsuarioResponse(
                usuario.getId(),
                usuario.getUsername(),
                usuario.getPessoa().getId()
        );
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public List<Usuario> findAll(Example<Usuario> example) {
        return usuarioRepository.findAll(example);
    }

    @Override
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}
