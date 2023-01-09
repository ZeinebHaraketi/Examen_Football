package tn.spring.springboot.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import javafx.scene.effect.Bloom;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.builder.ToStringExclude;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@ToString
@Data

public class Joueur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter

    private int idJoueur;
    private String nom ;
    private float taille ;
    @Enumerated(EnumType.STRING)
    private Poste poste ;
    private boolean blessure ;
    private int nbButsCarriere ;

    /*
    @ManyToMany( cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Medecin> medecins ;
*/
/*
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Formation> formations ;
    */
    @ManyToOne
    @JsonIgnore
@ToString.Exclude
    Equipe equipe;
}