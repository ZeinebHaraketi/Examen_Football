package tn.spring.springboot.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.Services.Interfaces.IServiceEquipe;
import tn.spring.springboot.Services.Interfaces.IServiceJoueur;
import tn.spring.springboot.entities.Division;
import tn.spring.springboot.entities.Equipe;
import tn.spring.springboot.entities.Joueur;
import tn.spring.springboot.entities.Poste;

import java.util.List;

@RestController
@RequestMapping("/Joueur")
public class JoueurController {


        @Autowired
        IServiceJoueur iServiceJoueur;


    @PostMapping("/ajouterJoueurEtAffecterEquipe/{idEquipe}")
    @ResponseBody
    public Joueur ajouterJoueurEtAffecterEquipe(@RequestBody Joueur joueur, @PathVariable("idEquipe") Integer idEquipe ) {
        return iServiceJoueur.ajouterJoueurEtAffecterEquipe(joueur,idEquipe);
    }


    @GetMapping(value = "/afficherJoueursParPosteEtTaille/{posteJoueur}/{tailleJoueur}")
    @ResponseBody
    public List<Joueur> afficherJoueursParPosteEtTaille(@PathVariable("posteJoueur") Poste posteJoueur, @PathVariable("tailleJoueur") float tailleJoueur) {
        return iServiceJoueur.afficherJoueursParPosteEtTaille(posteJoueur ,tailleJoueur);
    }



    @GetMapping(value = "/afficherJoueursDuMatchParDivisionEtPoste/{division}/{posteJoueur}/{idMatch}")
    @ResponseBody
    public List<Joueur> afficherJoueursDuMatchParDivisionEtPoste(@PathVariable("division") Division division, @PathVariable("posteJoueur") Poste posteJoueur, @PathVariable("idMatch") int idMatch) {
        return iServiceJoueur.afficherJoueursDuMatchParDivisionEtPoste(division,posteJoueur,idMatch);
    }

/*
    @PutMapping("/affecterApprenantFormation/{idApprenant}/{idFormation}")
    @ResponseBody
    public void affecterApprenantFormation( @PathVariable("idApprenant") int idApprenant ,@PathVariable("idFormation") int idFormation ) {
        iServiceApprenant.affecterApprenantFormation(idApprenant ,idFormation);
    }


afficherJoueursDuMatchParDivisionEtPoste

*/

   //afficherJoueursPolyvalantDisponible
   @Scheduled(fixedRate = 3000)

    @GetMapping(value = "/afficherJoueursPolyvalantDisponible/")
    @ResponseBody
    public void afficherJoueursPolyvalantDisponible() {
         iServiceJoueur.afficherJoueursPolyvalantDisponible();
    }


}
