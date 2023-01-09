package tn.spring.springboot.Services.Interfaces;


import tn.spring.springboot.entities.Formation;

public interface IServiceFormation {
 public void ajouterFormation (Formation formation, Integer idFormateur);
 public int  getRevenuByFormation(Integer idFormation);

 }
