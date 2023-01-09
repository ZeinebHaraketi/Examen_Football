package tn.spring.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import tn.spring.springboot.entities.Apprenant;
import tn.spring.springboot.entities.Formation;

import java.util.Date;
import java.util.List;


@EnableJpaRepositories
public interface FormationRepository extends JpaRepository<Formation,Integer> {

    public List<Formation>  findByFormateurIdFormateurAndDateDebutAfterAndDateFinBefore(int formateur_idFormateur , Date dateDebut , Date dateFin) ;

}
