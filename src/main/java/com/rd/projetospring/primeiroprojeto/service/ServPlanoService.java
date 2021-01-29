package com.rd.projetospring.primeiroprojeto.service;

import com.rd.projetospring.primeiroprojeto.dto.ServPlano;
import com.rd.projetospring.primeiroprojeto.entity.ServPlanoEntity;
import com.rd.projetospring.primeiroprojeto.repository.ServPlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class ServPlanoService {

    @Autowired
    private ServPlanoRepository repository;

    public ServPlano verServPlano(BigInteger id) {

        Optional<ServPlanoEntity> optional = repository.findById(id);
        ServPlanoEntity servPlanoEntity = optional.get();

        ServPlano servPlano = new ServPlano();
        servPlano.setIdServicoPlano(servPlanoEntity.getIdServicoPlano());
        servPlano.setDsServico(servPlanoEntity.getDsServico());

        return servPlano;
    }

    public List verServsPlano(BigInteger id) {
        List<ServPlanoEntity> ServsPlano = repository.findAll();
        return ServsPlano;
    }

    @Transactional
    public String cadastrarServPlano(ServPlano servPlano) {
        ServPlanoEntity servPlanoEntity = new ServPlanoEntity();

        servPlanoEntity.setDsServico(servPlano.getDsServico());

        repository.save(servPlanoEntity);

        return "Inserção feita com sucesso!";
    }

    @Transactional
    public String alterarServPlano(ServPlano servPlano, BigInteger id) {
        Optional<ServPlanoEntity> optional = repository.findById(id);
        ServPlanoEntity servPlanoEntity = optional.get();

        servPlanoEntity.setDsServico(servPlano.getDsServico());

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
