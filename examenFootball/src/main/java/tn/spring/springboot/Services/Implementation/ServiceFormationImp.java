package tn.spring.springboot.Services.Implementation;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.spring.springboot.Services.Interfaces.IServiceFormateur;
import tn.spring.springboot.Services.Interfaces.IServiceFormation;
import tn.spring.springboot.entities.Formateur;
import tn.spring.springboot.entities.Formation;
import tn.spring.springboot.repositories.ApprenantRepository;
import tn.spring.springboot.repositories.FormateurRepository;
import tn.spring.springboot.repositories.FormationRepository;

@Service
@Slf4j
public class ServiceFormationImp implements IServiceFormation {

    @Autowired
    FormationRepository formationRepository ;
    @Autowired
    FormateurRepository formateurRepository ;
    @Autowired
    ApprenantRepository apprenantRepository ;


    @Override
    public void ajouterFormation(Formation formation, Integer idFormateur) {

        Formateur formateur = formateurRepository.findById(idFormateur).get() ;
        formation.setFormateur(formateur);
        formationRepository.save(formation);
        log.info("Formation est ajoutée , et affecté au formateur : " + formateur.getNom());



    }

    @Override
    public int getRevenuByFormation(Integer idFormation) {

        Formation formation= formationRepository.findById(idFormation).get();


        return         apprenantRepository.countApprenantByFormationsIdFormation(idFormation)*formation.getFrais() ;

    }
}
