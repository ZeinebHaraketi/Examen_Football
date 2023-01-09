package tn.spring.springboot.Services.Implementation;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.spring.springboot.Services.Interfaces.IServiceFormateur;
import tn.spring.springboot.entities.Formateur;
import tn.spring.springboot.entities.Formation;
import tn.spring.springboot.repositories.FormateurRepository;
import tn.spring.springboot.repositories.FormationRepository;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class ServiceFormateurImp implements IServiceFormateur {

    @Autowired
    FormateurRepository formateurRepository ;
    @Autowired
    FormationRepository formationRepository ;


    @Override
    public void ajouterFormateur(Formateur formateur) {

        formateurRepository.save(formateur) ;
        log.info("le formateur est ajouté");

    }

    @Override
    public float getFormateurRemunerationByDate(Integer idFormateur, Date dateDebut, Date dateFin) {
        Formateur formateur = formateurRepository.findById(idFormateur).get() ;
        List<Formation> listeformation = formationRepository.findByFormateurIdFormateurAndDateDebutAfterAndDateFinBefore(formateur.getIdFormateur() , dateDebut ,dateFin);
        int sumheures = 0;
        for (int i=0 ; i<listeformation.size();i++) {
           sumheures += listeformation.get(i).getNbHeures();
       }
       return sumheures*formateur.getTarifHoraire();
    }
}
