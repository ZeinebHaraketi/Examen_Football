package tn.spring.springboot.entities;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@ToString
@Data

public class Formateur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter

    private int idFormateur;
    private String nom;
    private String prenom;
    private float tarifHoraire;
    private String email;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "formateur")

    private List<Formation> formations;

}