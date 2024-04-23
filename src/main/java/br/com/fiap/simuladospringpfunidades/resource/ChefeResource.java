package br.com.fiap.simuladospringpfunidades.resource;

import br.com.fiap.simuladospringpfunidades.entity.Chefe;
import br.com.fiap.simuladospringpfunidades.repository.ChefeRepository;
import br.com.fiap.simuladospringpfunidades.service.ChefeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Permission;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/chefe")
public class ChefeResource {

    @Autowired
    private ChefeService repo;

    @GetMapping
    public List<Chefe> findAll(){
        return repo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Chefe findById(@PathVariable Long id) {
        return repo.findById(id);
    }

    @Transactional
    @PostMapping
    public Chefe save(@RequestBody Chefe chefe) {
        return repo.save(chefe);
    }
}
