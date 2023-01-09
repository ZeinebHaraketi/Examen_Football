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

public class Apprenant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter

    private int idApprenant;
    private String nom ;
    private String prenom ;
    private int telephone ;
    private String email ;

    /*
    @ManyToMany( cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Medecin> medecins ;
*/

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Formation> formations ;
}