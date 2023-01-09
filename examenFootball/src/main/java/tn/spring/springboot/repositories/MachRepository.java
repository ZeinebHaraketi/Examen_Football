package tn.spring.springboot.repositories;

import com.fasterxml.jackson.databind.deser.DataFormatReaders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import tn.spring.springboot.entities.Joueur;
import tn.spring.springboot.entities.MatchFootball;
import tn.spring.springboot.entities.Poste;

import java.util.Date;
import java.util.List;


@EnableJpaRepositories
public interface MachRepository extends JpaRepository<MatchFootball,Integer> {

    public MatchFootball findByDateMatch(Date dateMatch ) ;



}
