package tn.spring.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import tn.spring.springboot.entities.Division;
import tn.spring.springboot.entities.Equipe;
import tn.spring.springboot.entities.Joueur;
import tn.spring.springboot.entities.Poste;

import java.util.List;


@EnableJpaRepositories
public interface JoueurRepository extends JpaRepository<Joueur,Integer> {


    List<Joueur> findAllByPosteAndTailleGreaterThan(Poste poste, float taille) ;
   List<Joueur> findByEquipeDivisionAndPosteAndEquipeMatchFootballsIdMatch(Division equipe_division, Poste poste, Integer equipe_matchFootballs_idMatch);
    List<Joueur> findByPosteAndNbButsCarriereGreaterThanAndBlessureFalse(Poste poste, int nbButsCarriere);
    int countByEquipeAndBlessureIsTrue(Equipe equipe);

}
