package tn.spring.springboot.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.Services.Interfaces.IServiceApprenant;
import tn.spring.springboot.Services.Interfaces.IServiceFormation;
import tn.spring.springboot.entities.Formation;

import java.util.Date;

@RestController
@RequestMapping("/Formation")
public class FormationController {


        @Autowired
        IServiceFormation iServiceFormation;


    @PostMapping("/addAndAssignToFormateur/{idFormateur}")
    @ResponseBody
    public void addAndAssignToFormateur(@RequestBody Formation formation ,   @PathVariable("idFormateur") int idFormateur) {
        iServiceFormation.ajouterFormation(formation,idFormateur);
    }


    @GetMapping(value = "/getRevenuByFormation/{idFormation}")
    @ResponseBody
    public float getFormateurRemunerationByDate(@PathVariable("idFormation") int idFormation) {
        return iServiceFormation.getRevenuByFormation(idFormation);
    }




}
