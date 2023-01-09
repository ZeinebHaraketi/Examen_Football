package tn.spring.springboot.Services.Implementation;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.spring.springboot.Services.Interfaces.IServiceApprenant;
import tn.spring.springboot.Services.Interfaces.IServiceFormateur;
import tn.spring.springboot.entities.Apprenant;
import tn.spring.springboot.entities.Formation;
import tn.spring.springboot.repositories.ApprenantRepository;
import tn.spring.springboot.repositories.FormateurRepository;
import tn.spring.springboot.repositories.FormationRepository;

import java.text.Normalizer;
import java.util.List;

@Service
@Slf4j
public class ServiceApprenantImp implements IServiceApprenant {

    @Autowired
    ApprenantRepository apprenantRepository ;
    @Autowired
    FormationRepository formationRepository ;


    @Override
    public void ajouterApprenant(Apprenant apprenant) {
        apprenantRepository.save(apprenant) ;
        log.info("l'apprenant est ajouté") ;

    }

    @Override
    public void affecterApprenantFormation(Integer idApprenant, Integer idFormation) {

        Apprenant apprenant = apprenantRepository.findById(idApprenant).get() ;
        Formation formation = formationRepository.findById(idFormation).get() ;

        if(apprenantRepository.countApprenantByFormationsTitre("DevOps") < formation.getNbMaxParticipants()) {
            apprenant.getFormations().add(formation);
            formation.getApprenants().add(apprenant);
            apprenantRepository.save(apprenant);
            formationRepository.save(formation);
            log.info("appreant est affecté a la formation ");
        }
        else {
            log.info(" pas de places disponible ");

        }



    }
    //@Scheduled(fixedRate = 2000)
    @Override
    public void getNbrApprenantByFormation() {
        List<Formation> liste = formationRepository.findAll() ;
        for (int i=0 ;i<liste.size() ; i++) {
             log.info(  "la formation :   " +  liste.get(i).getTitre().toString() + "   contient   " +  String.valueOf(apprenantRepository.countApprenantByFormationsIdFormation(liste.get(i).getIdFormation())) + "   apprenants ");
        }


    }
}
