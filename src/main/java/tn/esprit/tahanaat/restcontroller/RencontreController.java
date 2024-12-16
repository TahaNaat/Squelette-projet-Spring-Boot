package tn.esprit.tahanaat.restcontroller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tahanaat.entity.Rencontre;
import tn.esprit.tahanaat.service.IRencontreService;

@RestController
@AllArgsConstructor
@RequestMapping("/rencontre")
public class RencontreController {

    private final IRencontreService rencontreService;

    @PostMapping("/add/{idEquipe1}/{idEquipe2}")
    public Rencontre ajouterRencontreEtAffecterEquipes(
            @RequestBody Rencontre rencontre,
            @PathVariable Long idEquipe1,
            @PathVariable Long idEquipe2) {
        return rencontreService.ajouterRencontreEtAffecterEquipes(rencontre, idEquipe1, idEquipe2);
    }

    @PutMapping("/arbitre/{nom}/{prenom}/{idR}")
    public void affecterArbitreARencontre(
            @PathVariable String nom,
            @PathVariable String prenom,
            @PathVariable Long idR) throws Exception {
        rencontreService.affecterArbitreARencontre(nom, prenom, idR);
    }
}
