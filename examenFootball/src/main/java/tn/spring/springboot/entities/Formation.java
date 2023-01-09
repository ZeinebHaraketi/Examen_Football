package tn.spring.springboot.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@ToString
@Data

public class Formation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter

    private int idFormation;
    private String titre ;
    @Enumerated(EnumType.STRING)
    private Niveau niveau ;
    private Date dateDebut ;
    private Date dateFin ;
    private int nbHeures;
    private int nbMaxParticipants;
    private int frais;


    @ManyToMany(cascade = CascadeType.ALL , mappedBy = "formations")
    private List<Apprenant> apprenants ;

    @ManyToOne
    private  Formateur formateur ;

}