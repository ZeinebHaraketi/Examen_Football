package tn.spring.springboot.Services.Interfaces;


import tn.spring.springboot.entities.Formateur;

import java.util.Date;

public interface IServiceFormateur {

   public void ajouterFormateur(Formateur formateur) ;
   public float  getFormateurRemunerationByDate(Integer idFormateur, Date dateDebut, Date dateFin) ;
}
