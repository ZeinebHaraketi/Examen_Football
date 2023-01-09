package tn.spring.springboot.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.Services.Interfaces.IServiceEquipe;
import tn.spring.springboot.Services.Interfaces.IServiceMatch;
import tn.spring.springboot.entities.Equipe;
import tn.spring.springboot.entities.MatchFootball;

import java.util.Date;

@RestController
@RequestMapping("/match")
public class MatchController {


        @Autowired
        IServiceMatch iServiceMatch;


    @PostMapping("/ajouterMatchFootballEtAffecterEquipe/{idEquipe1}/{idEquipe2}")
    @ResponseBody
    public MatchFootball ajouterMatchFootballEtAffecterEquipe(@RequestBody MatchFootball matchFootball , @PathVariable("idEquipe1") Integer idEquipe1,@PathVariable("idEquipe2") Integer idEquipe2  ) {
        return iServiceMatch.ajouterMatchFootballEtAffecterEquipe(matchFootball,idEquipe1,idEquipe2);
    }

    @PutMapping("/reporterMatchFootball/{idMatch}/{dateReportee}")
    @ResponseBody
    public MatchFootball reporterMatchFootball( @PathVariable("idMatch") int idMatch ,@PathVariable("dateReportee") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateReportee ) {
       return  iServiceMatch.reporterMatchFootball(idMatch,dateReportee);
    }



/*
    @GetMapping(value = "/getNbrApprenantByFormation")
    @ResponseBody
    public void getNbrApprenantByFormation() {
          iServiceApprenant.getNbrApprenantByFormation();
    }


    @PutMapping("/affecterApprenantFormation/{idApprenant}/{idFormation}")
    @ResponseBody
    public void affecterApprenantFormation( @PathVariable("idApprenant") int idApprenant ,@PathVariable("idFormation") int idFormation ) {
        iServiceApprenant.affecterApprenantFormation(idApprenant ,idFormation);
    }


*/
}
