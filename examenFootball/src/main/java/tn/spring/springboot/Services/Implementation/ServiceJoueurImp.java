package tn.spring.springboot.Services.Implementation;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.spring.springboot.Services.Interfaces.IServiceEquipe;
import tn.spring.springboot.Services.Interfaces.IServiceJoueur;
import tn.spring.springboot.entities.Division;
import tn.spring.springboot.entities.Equipe;
import tn.spring.springboot.entities.Joueur;
import tn.spring.springboot.entities.Poste;
import tn.spring.springboot.repositories.EquipeRepository;
import tn.spring.springboot.repositories.JoueurRepository;

import java.util.List;

@Service
@Slf4j
public class ServiceJoueurImp implements IServiceJoueur {

    @Autowired
    JoueurRepository joueurRepository ;
    @Autowired
    EquipeRepository equipeRepository ;


    @Override
    public Joueur ajouterJoueurEtAffecterEquipe(Joueur joueur, Integer idEquipe) {

        Equipe equipe = equipeRepository.findById(idEquipe).get();
        joueur.setEquipe(equipe);
        log.info("joueur ajoutée et affecté a l'equipe");
        return          joueurRepository.save(joueur);

    }

    @Override
    public List<Joueur> afficherJoueursParPosteEtTaille(Poste poste, float taille) {
         return joueurRepository.findAllByPosteAndTailleGreaterThan(poste,taille);
    }

    @Override
    public List<Joueur> afficherJoueursDuMatchParDivisionEtPoste(Division division, Poste poste, Integer idMatch) {
        return joueurRepository.findByEquipeDivisionAndPosteAndEquipeMatchFootballsIdMatch(division,poste,idMatch);

    }
    @Override
    public void afficherJoueursPolyvalantDisponible() {

        for(int i =0 ; i<joueurRepository.findByPosteAndNbButsCarriereGreaterThanAndBlessureFalse(Poste.valueOf("DEFENSEUR"), 20).size(); i++ ) {
           log.info("le joueur " +  String.valueOf(joueurRepository.findByPosteAndNbButsCarriereGreaterThanAndBlessureFalse(Poste.valueOf("DEFENSEUR"), 20).get(i).getNom().toString()) + " est polyvalant ");
         }

    }
}
