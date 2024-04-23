package br.com.fiap.simuladospringpfunidades.service;

import br.com.fiap.simuladospringpfunidades.dto.request.UnidadeRequest;
import br.com.fiap.simuladospringpfunidades.dto.response.UnidadeResponse;
import br.com.fiap.simuladospringpfunidades.entity.Unidade;
import br.com.fiap.simuladospringpfunidades.repository.UnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UnidadeService implements ServiceDTO<Unidade, UnidadeRequest, UnidadeResponse> {

    @Autowired
    private UnidadeRepository unidadeRepository;

    @Override
    public Unidade toEntity(UnidadeRequest request) {
        return Unidade.builder()
                .nome(request.nome())
                .sigla(request.sigla())
                .descricao(request.descricao())
                .macro(request.macro() != null ? unidadeRepository.findById(request.macro().id()).orElse(null) : null)
                .build();
    }

    @Override
    public UnidadeResponse toResponse(Unidade unidade) {
        Long macroId = (unidade.getMacro() != null) ? unidade.getMacro().getId() : null;
        return new UnidadeResponse(
                unidade.getId(),
                unidade.getNome(),
                unidade.getSigla(),
                unidade.getDescricao(),
                macroId
        );
    }


    @Override
    public List<Unidade> findAll() {
        return unidadeRepository.findAll();
    }

    @Override
    public List<Unidade> findAll(Example<Unidade> example) {
        return unidadeRepository.findAll(example);
    }

    @Override
    public Unidade findById(Long id) {
        return unidadeRepository.findById(id).orElse(null);
    }

    @Override
    public Unidade save(Unidade unidade) {
        return unidadeRepository.save(unidade);
    }
}
