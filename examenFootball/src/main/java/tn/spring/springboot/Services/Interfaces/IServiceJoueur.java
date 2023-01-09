package tn.spring.springboot.Services.Interfaces;


import tn.spring.springboot.entities.Division;
import tn.spring.springboot.entities.Joueur;
import tn.spring.springboot.entities.Poste;

import java.util.List;

public interface IServiceJoueur {

 public Joueur ajouterJoueurEtAffecterEquipe(Joueur joueur,Integer idEquipe) ;
 public List<Joueur> afficherJoueursParPosteEtTaille(Poste poste , float taille ) ;
 public List<Joueur> afficherJoueursDuMatchParDivisionEtPoste(Division division ,Poste poste , Integer idMatch ) ;
 public void afficherJoueursPolyvalantDisponible() ;

}
