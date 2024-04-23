package br.com.fiap.simuladospringpfunidades.service;

import br.com.fiap.simuladospringpfunidades.dto.request.ChefeRequest;
import br.com.fiap.simuladospringpfunidades.dto.response.ChefeResponse;
import br.com.fiap.simuladospringpfunidades.entity.Chefe;
import br.com.fiap.simuladospringpfunidades.entity.Unidade;
import br.com.fiap.simuladospringpfunidades.entity.Usuario;
import br.com.fiap.simuladospringpfunidades.repository.ChefeRepository;
import br.com.fiap.simuladospringpfunidades.repository.UnidadeRepository;
import br.com.fiap.simuladospringpfunidades.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ChefeService implements ServiceDTO<Chefe, ChefeRequest, ChefeResponse> {

    @Autowired
    private ChefeRepository chefeRepository;

    @Autowired
    private UnidadeRepository unidadeRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Chefe toEntity(ChefeRequest request) {
        Unidade unidade = unidadeRepository.findById(request.unidade().id()).orElse(null);
        Usuario usuario = usuarioRepository.findById(request.usuario().id()).orElse(null);
        return Chefe.builder()
                .substituto(request.substituto())
                .inicio(request.inicio())
                .unidade(unidade)
                .usuario(usuario)
                .fim(request.fim())
                .build();
    }

    @Override
    public ChefeResponse toResponse(Chefe chefe) {
        return new ChefeResponse(
                chefe.getId(),
                chefe.getSubstituto(),
                chefe.getUsuario().getId(),
                chefe.getUnidade().getId(),
                chefe.getInicio(),
                chefe.getFim()
        );
    }

    @Override
    public List<Chefe> findAll() {
        return chefeRepository.findAll();
    }

    @Override
    public List<Chefe> findAll(Example<Chefe> example) {
        return List.of();
    }

    @Override
    public Chefe findById(Long id) {
        return null;
    }

    @Override
    public Chefe save(Chefe chefe) {
        return chefeRepository.save(chefe);
    }
}
