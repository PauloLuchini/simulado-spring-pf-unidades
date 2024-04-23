package br.com.fiap.simuladospringpfunidades.resource;

import br.com.fiap.simuladospringpfunidades.entity.Usuario;
import br.com.fiap.simuladospringpfunidades.repository.UsuarioRepository;
import br.com.fiap.simuladospringpfunidades.service.UsuarioService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioResource {

    @Autowired
    private UsuarioService repo;

    @GetMapping
    public List<Usuario> findAll(){
        return repo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Usuario findById(@PathVariable Long id) {
        return repo.findById(id);
    }

    @Transactional
    @PostMapping
    public Usuario save(@RequestBody Usuario usuario) {
        return repo.save(usuario);
    }
}
