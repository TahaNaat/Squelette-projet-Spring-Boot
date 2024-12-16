package tn.esprit.tahanaat.restcontroller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tahanaat.entity.Arbitre;
import tn.esprit.tahanaat.service.IArbitreService;

@RestController
@AllArgsConstructor
@RequestMapping("/arbitre")
public class ArbitreController {

    private final IArbitreService arbitreService;

    @PostMapping("/add")
    public Arbitre ajouterArbitre(@RequestBody Arbitre arbitre) {
        return arbitreService.ajouterArbitre(arbitre);
    }
}
