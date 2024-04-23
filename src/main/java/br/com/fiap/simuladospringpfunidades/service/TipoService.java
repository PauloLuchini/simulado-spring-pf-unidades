package br.com.fiap.simuladospringpfunidades.service;

import br.com.fiap.simuladospringpfunidades.dto.request.TipoRequest;
import br.com.fiap.simuladospringpfunidades.dto.response.TipoResponse;
import br.com.fiap.simuladospringpfunidades.entity.Tipo;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class TipoService implements ServiceDTO<Tipo, TipoRequest, TipoResponse> {

    @Override
    public Tipo toEntity(TipoRequest request) {
        return null;
    }

    @Override
    public TipoResponse toResponse(Tipo tipo) {
        return new TipoResponse(
                tipo.getId(),
                tipo.getNome(),
                tipo.getSigla()
        );
    }

    @Override
    public List<Tipo> findAll() {
        return Arrays.asList(Tipo.values());
    }

    @Override
    public List<Tipo> findAll(Example<Tipo> example) {
        return List.of();
    }

    @Override
    public Tipo findById(Long id) {
        return null;
    }

    @Override
    public Tipo save(Tipo tipo) {
        return null;
    }
}
