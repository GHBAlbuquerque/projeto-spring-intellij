package com.rd.projetospring.primeiroprojeto.service;

import com.rd.projetospring.primeiroprojeto.dto.ServicoPlano;
import com.rd.projetospring.primeiroprojeto.entity.ServicoPlanoEntity;
import com.rd.projetospring.primeiroprojeto.repository.ServicoPlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServicoPlanoService {

    @Autowired
    private ServicoPlanoRepository repository;


    //Conversão Lista Entity em DTO
    public List<ServicoPlano> servicosPlanoDTO(List<ServicoPlanoEntity> servicosPlano) {
        List<ServicoPlano> servicosPlanoDTO = new ArrayList<>();

        for(ServicoPlanoEntity servPlanoEntity: servicosPlano){
            ServicoPlano servPlano = new ServicoPlano();
            servPlano.setIdServicoPlano(servPlanoEntity.getIdServicoPlano());
            servPlano.setDsServico(servPlano.getDsServico());
            servicosPlanoDTO.add(servPlano);
        }
        return servicosPlanoDTO;
    }

    public List<ServicoPlanoEntity> getServicosPlano() {
        List<ServicoPlanoEntity> servicosPlano = repository.findAll();
        return servicosPlano;
    }

    public ServicoPlano getServicoPlano(BigInteger id) {

        Optional<ServicoPlanoEntity> optional = repository.findById(id);
        ServicoPlanoEntity servPlanoEntity = optional.get();

        ServicoPlano servicoPlano = new ServicoPlano();
        servicoPlano.setIdServicoPlano(servPlanoEntity.getIdServicoPlano());
        servicoPlano.setDsServico(servPlanoEntity.getDsServico());

        return servicoPlano;
    }


    public  List<ServicoPlano> getServicoPlanoDTO() {
        List<ServicoPlanoEntity> servPlanoEntity = getServicosPlano();
        List<ServicoPlano> servicosPlanoDTO = servicosPlanoDTO(servPlanoEntity);
        return servicosPlanoDTO;
    }

    @Transactional
    public String cadastrarServPlano(ServicoPlano servicoPlano) {
        ServicoPlanoEntity servPlanoEntity = new ServicoPlanoEntity();

        servPlanoEntity.setDsServico(servicoPlano.getDsServico());

        repository.save(servPlanoEntity);

        return "Inserção feita com sucesso!";
    }

    @Transactional
    public String alterarServPlano(ServicoPlano servicoPlano, BigInteger id) {
        Optional<ServicoPlanoEntity> optional = repository.findById(id);
        ServicoPlanoEntity servPlanoEntity = optional.get();

        servPlanoEntity.setDsServico(servicoPlano.getDsServico());

        repository.save(servPlanoEntity);

        return "Alteração feita com sucesso!";
    }

    public String deletarServPlano(BigInteger id) {
//        Optional<UsuarioEntity> optional = repository.findById(id);
//        UsuarioEntity usuarioEntity = optional.get();
//        repository.delete(usuarioEntity);

        repository.deleteById(id);

        return "Remoção feita com sucesso!";
    }
}
