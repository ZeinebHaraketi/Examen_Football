package tn.spring.springboot.Services.Interfaces;


import tn.spring.springboot.entities.Joueur;
import tn.spring.springboot.entities.MatchFootball;
import tn.spring.springboot.entities.Poste;

import java.util.Date;
import java.util.List;

public interface IServiceMatch {

public MatchFootball ajouterMatchFootballEtAffecterEquipe(MatchFootball matchFootball , Integer idEquipe1 , Integer idequipe2) ;
public  MatchFootball reporterMatchFootball(Integer idMatch  , Date dateReportes) ;
}
