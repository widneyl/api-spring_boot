package com.widneydev.pantheon_api.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.widneydev.pantheon_api.modelo.RespostaModelo;
import com.widneydev.pantheon_api.modelo.Usuario;
import com.widneydev.pantheon_api.repositorio.UsuarioRepositorio;

// A anotação @Service é usada no Spring Framework para indicar que uma classe desempenha o papel de um serviço na arquitetura de aplicativos. 
// Isso significa que ela contém a lógica de negócios da sua aplicação
@Service
public class UsuarioServico {
    
    @Autowired
    private RespostaModelo resposta;

    @Autowired
    private UsuarioRepositorio usuario_repositorio;

    //Metodo para cadastrar novos usuarios
    public ResponseEntity<?> cadastrar(Usuario user){
        if(user.getNome().equals("")){
            resposta.setMenssagem("O nome precisa ser preenchido");
            return new ResponseEntity<>(resposta, HttpStatus.BAD_REQUEST);
        }
        else if(user.getEmail().equals("")){
            resposta.setMenssagem("O email precisa ser preenchido");
            return new ResponseEntity<>(resposta, HttpStatus.BAD_REQUEST);
        }
        else if(user.getSenha().equals("")){
            resposta.setMenssagem("A senha precisa ser preenchida");
            return new ResponseEntity<>(resposta, HttpStatus.BAD_REQUEST);
        }
        else{
            return new ResponseEntity<>(usuario_repositorio.save(user), HttpStatus.CREATED);
        }
    }


    //Metodo para Listar os usuarios
    public Iterable<Usuario> listar(){
        return usuario_repositorio.findAll();
    }

}
