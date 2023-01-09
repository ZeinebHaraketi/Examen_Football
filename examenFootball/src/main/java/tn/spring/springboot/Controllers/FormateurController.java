package tn.spring.springboot.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.spring.springboot.Services.Interfaces.IServiceFormateur;
import tn.spring.springboot.entities.Formateur;

import java.util.Date;

@RestController
@RequestMapping("/Formateur")
public class FormateurController {


        @Autowired
        IServiceFormateur iServiceFormateur;


    @PostMapping("/add")
    @ResponseBody
    public void addFormateur(@RequestBody Formateur formateur) {
        iServiceFormateur.ajouterFormateur(formateur);
    }

    @GetMapping(value = "/getFormateurRemunerationByDate/{idFormateur}/{startDate}/{finDate}")
    @ResponseBody
    public float getFormateurRemunerationByDate(@PathVariable("idFormateur") int idFormateur ,  @PathVariable("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate ,  @PathVariable("finDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date finDate) {
         return iServiceFormateur.getFormateurRemunerationByDate(idFormateur ,startDate ,finDate);
    }




}
