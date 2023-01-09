package tn.spring.springboot.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.Services.Interfaces.IServiceApprenant;
import tn.spring.springboot.Services.Interfaces.IServiceFormateur;
import tn.spring.springboot.entities.Apprenant;

@RestController
@RequestMapping("/Apprenant")
public class ApprenantController {


        @Autowired
        IServiceApprenant iServiceApprenant;


    @PostMapping("/add")
    @ResponseBody
    public void addApprenant(@RequestBody Apprenant apprenant) {
        iServiceApprenant.ajouterApprenant(apprenant);
    }


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



}
