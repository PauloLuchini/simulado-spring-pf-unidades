package br.com.fiap.simuladospringpfunidades.service;

import br.com.fiap.simuladospringpfunidades.dto.request.PessoaRequest;
import br.com.fiap.simuladospringpfunidades.dto.response.PessoaResponse;
import br.com.fiap.simuladospringpfunidades.entity.Pessoa;
import br.com.fiap.simuladospringpfunidades.entity.Tipo;
import br.com.fiap.simuladospringpfunidades.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PessoaService implements ServiceDTO<Pessoa, PessoaRequest, PessoaResponse> {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private TipoService tipoService;

    @Override
    public Pessoa toEntity(PessoaRequest request) {
        Tipo tipo = tipoService.findById(request.tipo().getId());
        return Pessoa.builder()
                .nome(request.nome())
                .sobrenome(request.sobrenome())
                .email(request.email())
                .nascimento(request.nascimento())
                .tipo(tipo)
                .build();
    }

    @Override
    public PessoaResponse toResponse(Pessoa pessoa) {
        return new PessoaResponse(
                pessoa.getId(),
                pessoa.getNome(),
                pessoa.getSobrenome(),
                pessoa.getEmail(),
                pessoa.getNascimento(),
                pessoa.getTipo()
        );
    }

    @Override
    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    @Override
    public List<Pessoa> findAll(Example<Pessoa> example) {
        return List.of();
    }

    @Override
    public Pessoa findById(Long id) {
        return null;
    }

    @Override
    public Pessoa save(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }
}
