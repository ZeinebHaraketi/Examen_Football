package tn.spring.springboot.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.Services.Interfaces.IServiceApprenant;
import tn.spring.springboot.Services.Interfaces.IServiceEquipe;
import tn.spring.springboot.entities.Apprenant;
import tn.spring.springboot.entities.Equipe;

@RestController
@RequestMapping("/Equipe")
public class EquipeController {


        @Autowired
        IServiceEquipe iServiceEquipe;


    @PostMapping("/add")
    @ResponseBody
    public Equipe addEquipe(@RequestBody Equipe equipe ) {
        return iServiceEquipe.ajouterEquipe(equipe);
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
