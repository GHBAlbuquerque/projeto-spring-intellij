package com.rd.projetospring.primeiroprojeto.service;

import com.rd.projetospring.primeiroprojeto.dto.Planos;
import com.rd.projetospring.primeiroprojeto.dto.ServicoPlano;
import com.rd.projetospring.primeiroprojeto.entity.PlanosEntity;
import com.rd.projetospring.primeiroprojeto.entity.ServicoPlanoEntity;
import com.rd.projetospring.primeiroprojeto.repository.PlanosRepository;
import com.rd.projetospring.primeiroprojeto.repository.ServicoPlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlanosService {

    @Autowired private PlanosRepository repository;
    @Autowired private ServicoPlanoRepository servRepository;
    @Autowired private ServicoPlanoService spService;

    //método conversão lista para DTO
    public List<Planos> conversaoPlanosDTO(List<PlanosEntity> planosEntities, List<Planos> planos) {

        for(PlanosEntity planoEntity: planosEntities) {
            Planos plano = new Planos();
            plano.setIdPlano(planoEntity.getIdPlano());
            plano.setDsPlano(planoEntity.getDsPlano());
            plano.setVlPlano(planoEntity.getVlPlano());
            plano.setNmPlano(planoEntity.getNmPlano());

            List<ServicoPlano> servicosPlanoDTO = spService.servicosPlanoDTO(planoEntity.getServicos());

            //colocar servicos planos
            plano.setServicos(servicosPlanoDTO);
            planos.add(plano);
        }

        return planos;
    }

    //método conversão entity para dto
    public Planos conversaoPlanoDTO(PlanosEntity planoEntity, Planos plano) {

        plano.setIdPlano(planoEntity.getIdPlano());
        plano.setNmPlano(planoEntity.getNmPlano());
        plano.setDsPlano(planoEntity.getDsPlano());
        plano.setVlPlano(planoEntity.getVlPlano());

        return plano;
    }

    //get 1 plano DTO
    public Planos getPlanoDTO(BigInteger id) {

        Optional<PlanosEntity> optional = repository.findById(id);
        PlanosEntity planoEntity = optional.get();

        Planos plano = new Planos();
        plano = conversaoPlanoDTO(planoEntity,plano);
        return plano;
    }

    //get lista planos Entity
    public List<PlanosEntity> getPlanos() {
        List<PlanosEntity> planos = repository.findAll();
        return planos;
    }

    //get lista planos DTO
    public List<Planos> getPlanosDTO() {
        List<PlanosEntity> planosEntities = getPlanos();
        List<Planos> planos = new ArrayList<>();
        planos = conversaoPlanosDTO(planosEntities, planos);

        return planos;
    }

    @Transactional
    public String cadastrarPlano(Planos plano) {
        PlanosEntity planoEntity = new PlanosEntity();

        planoEntity.setNmPlano(plano.getNmPlano());
        planoEntity.setDsPlano(plano.getDsPlano());
        planoEntity.setVlPlano(plano.getVlPlano());

        //TODO
        List<ServicoPlanoEntity> listaServPlano = new ArrayList<>();
        for(ServicoPlano servico : plano.getServicos()) {
//            ServPlanoEntity servPlanoEntity = new ServPlanoEntity();
//            servPlanoEntity.setIdServicoPlano(servico.getIdServicoPlano());
//            servPlanoEntity.setDsServico(servico.getDsServico());

            BigInteger idServicoPlano = servico.getIdServicoPlano();
            Optional<ServicoPlanoEntity> optional = servRepository.findById(idServicoPlano);
            ServicoPlanoEntity servPlanoEntity = optional.get();
            listaServPlano.add(servPlanoEntity);
        }

        planoEntity.setServicos(listaServPlano);

        repository.save(planoEntity);

        return "Inserção feita com sucesso!";
    }

    @Transactional
    public String alterarPlano(Planos plano, BigInteger id) {
        Optional<PlanosEntity> optional = repository.findById(id);
        PlanosEntity planoEntity = optional.get();

        planoEntity.setNmPlano(plano.getNmPlano());
        planoEntity.setDsPlano(plano.getDsPlano());
        planoEntity.setVlPlano(plano.getVlPlano());

        repository.save(planoEntity);

        return "Alteração feita com sucesso!";
    }

    public String deletarPlano(BigInteger id) {
//        Optional<UsuarioEntity> optional = repository.findById(id);
//        UsuarioEntity usuarioEntity = optional.get();
//        repository.delete(usuarioEntity);

        repository.deleteById(id);

        return "Remoção feita com sucesso!";
    }

}
