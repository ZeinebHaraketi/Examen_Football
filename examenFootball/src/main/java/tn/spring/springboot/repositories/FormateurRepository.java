package tn.spring.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import tn.spring.springboot.entities.Formateur;


@EnableJpaRepositories
public interface FormateurRepository extends JpaRepository<Formateur,Integer> {

}
