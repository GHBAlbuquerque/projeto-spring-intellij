package com.rd.projetospring.primeiroprojeto.service;

import com.rd.projetospring.primeiroprojeto.dto.Usuario;
import com.rd.projetospring.primeiroprojeto.entity.UsuarioEntity;
import com.rd.projetospring.primeiroprojeto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public UsuarioEntity getUsuarioById(BigInteger id) {
        System.out.println("ID: " + id);
        Optional<UsuarioEntity> optional = repository.findById(id);
        return optional.get();
    }

    public List getUsuarios() {
        List<UsuarioEntity> usuarios = repository.findAll();
        return usuarios;
    }

    @Transactional
    public String inserirUsuario(Usuario usuario) {
        UsuarioEntity usuarioEntity = new UsuarioEntity();

        usuarioEntity.setIdTipoUsuario(usuario.getIdTipoUsuario());
        usuarioEntity.setNome(usuario.getNome());
        usuarioEntity.setCpf(usuario.getCpf());

        repository.save(usuarioEntity);
        return "Inserção feita com sucesso!";
    }

    @Transactional
    public String alterarUsuario(Usuario usuario, BigInteger id) {
        UsuarioEntity usuarioEntity = getUsuarioById(id);

        usuarioEntity.setNome(usuario.getNome());
        usuarioEntity.setCpf(usuario.getCpf());
        usuarioEntity.setDtNascimento(usuario.getDtNascimento());

        repository.save(usuarioEntity);

        return "Alteração feita com sucesso!";
    }

    public String deletarUsuario(BigInteger id) {
//        Optional<UsuarioEntity> optional = repository.findById(id);
//        UsuarioEntity usuarioEntity = optional.get();
//        repository.delete(usuarioEntity);

        repository.deleteById(id);

        return "Remoção feita com sucesso!";
    }
}
