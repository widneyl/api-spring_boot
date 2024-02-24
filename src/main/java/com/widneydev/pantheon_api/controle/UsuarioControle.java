package com.widneydev.pantheon_api.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.widneydev.pantheon_api.modelo.Usuario;
import com.widneydev.pantheon_api.servico.UsuarioServico;


@RestController
@CrossOrigin(origins = "*")
public class UsuarioControle {

    @Autowired 
    private UsuarioServico usuario_servico;
    
    @GetMapping("/")
    public String rota(){
        return "API EM FUNCIONAMENTO";
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody Usuario user){
        return usuario_servico.cadastrar(user);
    }

    @GetMapping("/listar")
    public Iterable<Usuario> listar(){
        return usuario_servico.listar();
    }
}
