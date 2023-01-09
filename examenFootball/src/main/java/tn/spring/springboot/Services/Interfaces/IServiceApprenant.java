package tn.spring.springboot.Services.Interfaces;


import tn.spring.springboot.entities.Apprenant;

public interface IServiceApprenant {

 public void ajouterApprenant(Apprenant apprenant) ;
 public void affecterApprenantFormation (Integer idApprenant, Integer idFormation);
 public void  getNbrApprenantByFormation () ;

}
