package com.rd.projetospring.primeiroprojeto.service;

import com.rd.projetospring.primeiroprojeto.dto.Endereco;
import com.rd.projetospring.primeiroprojeto.entity.EnderecoEntity;
import com.rd.projetospring.primeiroprojeto.entity.ServicoPlanoEntity;
import com.rd.projetospring.primeiroprojeto.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    //método para converter uma Entity em um DTO

    //método para converter uma lista de Entities em uma DTO
    public List<Endereco> conversaoEnderecosDTO(List<EnderecoEntity> enderecosEntities) {

        List<Endereco> enderecos = new ArrayList<>();
        for(EnderecoEntity enderecoEntity: enderecosEntities) {
            Endereco endereco = new Endereco();
            endereco.setIdEndereco(enderecoEntity.getIdEndereco());
            endereco.setNrCep(enderecoEntity.getNrCep());
            endereco.setDsBairro(enderecoEntity.getDsBairro());
            endereco.setIdCidade(enderecoEntity.getIdCidade());
            endereco.setDsEndereco(enderecoEntity.getDsEndereco());

            enderecos.add(endereco);
        }

        return enderecos;
    }

    //método Get Endereços
    public List<EnderecoEntity> getEnderecos() {
        List<EnderecoEntity> enderecoEntities = repository.findAll();
        return enderecoEntities;
    }

    //método Get EndereçosDTO
    public List<Endereco> getEnderecosDTO() {
        List<EnderecoEntity> enderecoEntities = getEnderecos();
        List<Endereco> enderecos = conversaoEnderecosDTO(enderecoEntities);

        return enderecos;
    }


}
