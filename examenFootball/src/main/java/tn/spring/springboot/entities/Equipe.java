package tn.spring.springboot.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
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

public class Equipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter

    private int idEquipe;
    private String nomEquipe ;
    @Enumerated(EnumType.STRING)
    private Division division ;
    private String pays ;


    @ManyToMany( cascade = CascadeType.ALL, mappedBy = "equipes")
    @JsonIgnore
    private List<MatchFootball> matchFootballs ;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="equipe")
    @JsonIgnore
    private List<Joueur> joueurs;

}