package tn.spring.springboot.Services.Implementation;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.spring.springboot.Services.Interfaces.IServiceJoueur;
import tn.spring.springboot.Services.Interfaces.IServiceMatch;
import tn.spring.springboot.entities.Equipe;
import tn.spring.springboot.entities.Joueur;
import tn.spring.springboot.entities.MatchFootball;
import tn.spring.springboot.entities.Poste;
import tn.spring.springboot.repositories.EquipeRepository;
import tn.spring.springboot.repositories.JoueurRepository;
import tn.spring.springboot.repositories.MachRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class ServiceMatchImp implements IServiceMatch {

    @Autowired
    MachRepository machRepository;
    @Autowired
    EquipeRepository equipeRepository;
    @Autowired
    JoueurRepository joueurRepository ;


    @Override
    public MatchFootball ajouterMatchFootballEtAffecterEquipe(MatchFootball matchFootball, Integer idEquipe1, Integer idequipe2) {
        Equipe equipe1 = equipeRepository.findById(idEquipe1).get() ;
        Equipe equipe2 = equipeRepository.findById(idequipe2).get() ;

        List<Equipe> equipeList = new ArrayList<>() ;
        equipeList.add(equipe1);
        equipeList.add(equipe2) ;
        matchFootball.setEquipes(equipeList);
       return  machRepository.save(matchFootball);
    }

    @Override
    public MatchFootball reporterMatchFootball(Integer idMatch, Date dateReportes) {
        /*
        MatchFootball matchFootball = machRepository.findById(idMatch).get();
        Equipe equipe1 = null;
        Equipe equipe2 = null;
        Date dateNow = new Date() ;
        for (int i= 0 ; i< matchFootball.getEquipes().size();i++){
            equipe1 = matchFootball.getEquipes().get(0);
            equipe2 = matchFootball.getEquipes().get(1);
        }

        if((joueurRepository.countByEquipeAndBlessureIsTrue(equipe1)+joueurRepository.countByEquipeAndBlessureIsTrue(equipe2))>1 && matchFootball
                .getDateMatch().after(dateNow)) {

            matchFootball.setDateMatch(dateReportes);

        }

        return machRepository.save(matchFootball);
    }

         */
        return null;
    }
}
