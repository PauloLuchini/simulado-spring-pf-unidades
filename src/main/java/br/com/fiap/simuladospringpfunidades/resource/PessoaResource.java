package br.com.fiap.simuladospringpfunidades.resource;

import br.com.fiap.simuladospringpfunidades.entity.Pessoa;
import br.com.fiap.simuladospringpfunidades.repository.PessoaRepository;
import br.com.fiap.simuladospringpfunidades.service.PessoaService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaResource {

    @Autowired
    private PessoaService repo;

    @GetMapping
    public List<Pessoa> findAll(){
        return repo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Pessoa findById(@PathVariable Long id) {
        return repo.findById(id);
    }

    @Transactional
    @PostMapping
    public Pessoa save(@RequestBody Pessoa pessoa) {
        return repo.save(pessoa);
    }
}
