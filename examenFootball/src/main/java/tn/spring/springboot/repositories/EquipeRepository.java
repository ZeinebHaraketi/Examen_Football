package tn.spring.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import tn.spring.springboot.entities.Apprenant;
import tn.spring.springboot.entities.Equipe;


@EnableJpaRepositories
public interface EquipeRepository extends JpaRepository<Equipe,Integer> {

}
