package tn.spring.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import tn.spring.springboot.entities.Apprenant;
import tn.spring.springboot.entities.Formateur;


@EnableJpaRepositories
public interface ApprenantRepository extends JpaRepository<Apprenant,Integer> {


    public int  countApprenantByFormationsTitre(String formations_titre) ;
    public int  countApprenantByFormationsIdFormation(int formations_idFormation) ;

}
