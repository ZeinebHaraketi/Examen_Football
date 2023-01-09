package tn.spring.springboot.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@ToString
@Data

public class MatchFootball implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter

    private int idMatch;
    private String libelle ;
     private String pays ;
     private Date dateMatch ;


    @ManyToMany( cascade = CascadeType.ALL )
    @JsonIgnore
    private List<Equipe> equipes ;

/*
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Formation> formations ;
    */
 
}