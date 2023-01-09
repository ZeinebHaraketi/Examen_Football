package tn.spring.springboot.Services.Implementation;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.spring.springboot.Services.Interfaces.IServiceApprenant;
import tn.spring.springboot.Services.Interfaces.IServiceEquipe;
import tn.spring.springboot.entities.Apprenant;
import tn.spring.springboot.entities.Equipe;
import tn.spring.springboot.entities.Formation;
import tn.spring.springboot.repositories.ApprenantRepository;
import tn.spring.springboot.repositories.EquipeRepository;
import tn.spring.springboot.repositories.FormationRepository;

import java.util.List;

@Service
@Slf4j
public class ServiceEquipeImp implements IServiceEquipe {

    @Autowired
    EquipeRepository equipeRepository ;


    @Override
    public Equipe ajouterEquipe(Equipe equipe) {
        log.info("l'equipe est ajouter");
        return equipeRepository.save(equipe);
    }
}
