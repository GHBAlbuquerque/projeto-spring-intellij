package com.rd.projetospring.primeiroprojeto.service;

import com.rd.projetospring.primeiroprojeto.dto.Contato;
import com.rd.projetospring.primeiroprojeto.entity.ContatoEntity;
import com.rd.projetospring.primeiroprojeto.entity.TipoContatoEntity;
import com.rd.projetospring.primeiroprojeto.entity.UsuarioEntity;
import com.rd.projetospring.primeiroprojeto.repository.ContatoRepository;
import com.rd.projetospring.primeiroprojeto.repository.TipoContatoRepository;
import com.rd.projetospring.primeiroprojeto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository repository;

    @Autowired
    private TipoContatoRepository tcrepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    //MÉTODO GET -> pega todos os registros
    public List<ContatoEntity> verContatos() {
        List<ContatoEntity> contatos = repository.findAll();
        return contatos;
    }

    public ContatoEntity verContatoById(BigInteger id) {
       //quero achar um contato sõ baseado no id
        Optional<ContatoEntity> optional = repository.findById(id);
        ContatoEntity contatoEntity = optional.get();

        return contatoEntity;
    }

    public String cadastrarContato(Contato contato){
        ContatoEntity contatoEntity = new ContatoEntity();

        //PROCURAR REGISTRO TIPOCONTATO NA MINHA TABELA ATRAVÉS DO ID
        //PARA PEGAR A ENTITY
        BigInteger tipoContatoId = contato.getIdTipoContato().getIdTipoContato();
        TipoContatoEntity tipoContatoEntity = tcrepository.findById(tipoContatoId).get();

        //PEGAR A ENTITY USUARIO
        BigInteger usuarioId = contato.getUsuario().getId();
        UsuarioEntity usuarioEntity = usuarioRepository.findById(usuarioId).get();

        //ATRIBUI OS VALORES NA ENTITY
        contatoEntity.setIdLoja(contato.getIdLoja());
        contatoEntity.setNrDdd(contato.getNrDdd());
        contatoEntity.setNrDdi(contato.getNrDdi());
        contatoEntity.setNrRamal(contato.getNrRamal());
        contatoEntity.setDsContato(contato.getDsContato());
        contatoEntity.setIdTipoContato(tipoContatoEntity);
        contatoEntity.setUsuario(usuarioEntity);

        repository.save(contatoEntity);

        return "Cadastro feito com sucesso!";

    }

    public String alterarContato(Contato contato, BigInteger id) { //ATUALIZAR
        ContatoEntity contatoEntity = verContatoById(id);

        //PARA PEGAR A ENTITY
        BigInteger tipoContatoId = contato.getIdTipoContato().getIdTipoContato();
        TipoContatoEntity tipoContatoEntity = tcrepository.findById(tipoContatoId).get();

        //PEGAR A ENTITY USUARIO
        BigInteger usuarioId = contato.getUsuario().getId();
        UsuarioEntity usuarioEntity = usuarioRepository.findById(usuarioId).get();

        contatoEntity.setIdLoja(contato.getIdLoja());
        contatoEntity.setNrDdd(contato.getNrDdd());
        contatoEntity.setNrDdi(contato.getNrDdi());
        contatoEntity.setNrRamal(contato.getNrRamal());
        contatoEntity.setDsContato(contato.getDsContato());
        contatoEntity.setIdTipoContato(tipoContatoEntity);
        contatoEntity.setUsuario(usuarioEntity);

        repository.save(contatoEntity);

        return "Alteração feita com sucesso!";
    }

    public String deletarContato(BigInteger id) {
        repository.deleteById(id);

        return "Exclusão feita com sucesso!";
    }

    public List<ContatoEntity> verContatosPorUsuario(BigInteger id) {
        UsuarioEntity usuarioEntity = usuarioRepository.findById(id).get();

        List<ContatoEntity> contatos = repository.findByUsuario(usuarioEntity);
        return contatos;
    }

    public List<ContatoEntity> verContatosPorLoja(BigInteger idLoja) {

        List<ContatoEntity> contatos = repository.findByIdLoja(idLoja);
        return contatos;
    }


}
