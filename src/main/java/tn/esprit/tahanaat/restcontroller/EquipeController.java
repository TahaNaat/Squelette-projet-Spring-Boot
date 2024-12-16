package tn.esprit.tahanaat.restcontroller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tahanaat.entity.Equipe;
import tn.esprit.tahanaat.service.IEquipeService;

@RestController
@AllArgsConstructor
@RequestMapping("/equipe")
public class EquipeController {

    private final IEquipeService equipeService;

    @PostMapping("/add")
    public Equipe ajouterEquipeEtJoueurs(@RequestBody Equipe equipe) {
        return equipeService.ajouterEquipeEtJoueurs(equipe);
    }
}
