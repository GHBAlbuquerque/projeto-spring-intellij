package com.rd.projetospring.primeiroprojeto.service;

import com.rd.projetospring.primeiroprojeto.dto.*;
import com.rd.projetospring.primeiroprojeto.entity.*;
import com.rd.projetospring.primeiroprojeto.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private UfService ufService;
    @Autowired
    private GeneroService generoService;
    @Autowired
    private PlanosService planosService;
    @Autowired
    private EnderecoService enderecoService;


    //CONVERSÕES ***********************************************************************************
    //Converter de Entity para DTO
    public Usuario conversaoUsuarioDTO(UsuarioEntity usuarioEntity) {

        Usuario usuario = new Usuario();
        usuario.setId(usuarioEntity.getIdUsuario());
        usuario.setIdTipoUsuario(usuarioEntity.getIdTipoUsuario());
        usuario.setCpf(usuarioEntity.getCpf());
        usuario.setNome(usuarioEntity.getCpf());
        usuario.setDtNascimento(usuarioEntity.getDtNascimento());

        return usuario;
    }

    //Converter de List Entity para List DTO
    // public List<Usuario> conversaoUsuariosDTO(List<UsuarioEntity> usuarioEntities) {
    //
    //}

    //Converter de DTO para Entity
    //public UsuarioEntity conversaoUsuarioEntity(Usuario usuario) {
    //
    //}


    //PÁGINAS DE FORMULÁRIO *************************************************************************
    //Formulário de cadastro vazio
    public FormularioCadastro getFormularioCadastro() {
        FormularioCadastro formularioCadastro = new FormularioCadastro();

        formularioCadastro.setUfs(ufService.getUfsDTO());
        formularioCadastro.setGenero(generoService.getGenerosDTO());
        formularioCadastro.setPlanos(planosService.getPlanosDTO());
        return formularioCadastro;
    }

    //Formulário já com dados do Usuário preenchidos
    public FormularioMeusDados getFormularioMeusDados(BigInteger id) {
        FormularioCadastro formularioCadastro = getFormularioCadastro();
        FormularioMeusDados formularioMeusDados = new FormularioMeusDados();

           Boolean teste = repository.existsById(id);
           if(teste) {
               //buscar entities
               Optional<UsuarioEntity> optional = repository.findById(id);
               UsuarioEntity usuarioEntity = optional.get();
               List<EnderecoEntity> enderecosEntities = usuarioEntity.getEnderecos();

               //pegar DTOs
               List<Endereco> enderecos = enderecoService.conversaoEnderecosDTO(usuarioEntity.getEnderecos());
               Usuario usuario = conversaoUsuarioDTO(usuarioEntity);

               //inserir enderecos no usuário
               usuario.setEnderecos(enderecos);

               //buscar objeto loginUsuario
               //Optional<LoginUsuarioEntity> optional = repository.findByIdUsuario(id);
                //email e senha

               //buscar idPlano no contrato
               //Optional<ContratoEntity> optional = repository.findByIdUsuario(id);
               //plano escolhido

               //buscar objeto contato
               //Optional<ContatoEntity> optional = repository.findByIdUsuario(id);

               formularioMeusDados.setUsuario(usuario);
               //formularioMeusDados.setLoginUsuario();
               //formularioMeusDados.setContato();
               //formularioMeusDados.setIdPlano();

           }

                formularioMeusDados.setUfs(formularioCadastro.getUfs());
                formularioMeusDados.setGenero(formularioCadastro.getGenero());
                formularioMeusDados.setPlanos(formularioCadastro.getPlanos());

                return formularioMeusDados;
    }


    //RETORNO MÉTODOS HTTP *************************************************************************
    public UsuarioEntity getUsuarioById(BigInteger id) {
        //System.out.println("ID: " + id);
        Optional<UsuarioEntity> optional = repository.findById(id);
        return optional.get();
    }

    public List<UsuarioEntity> getUsuarios() {
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



