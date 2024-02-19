package com.widneydev.pantheon_api.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.widneydev.pantheon_api.modelo.Usuario;

//O repositório em uma aplicação Spring, tem como objetivo, dispor funcionalidades de manipulação de registros com algum banco de dados, 
//também é conhecido como camada de persistência.
@Repository
public interface UsuarioRepositorio extends CrudRepository<Usuario, Integer> {
    
}
