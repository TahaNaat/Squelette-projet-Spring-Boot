package tn.esprit.tahanaat.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tahanaat.entity.Equipe;
import tn.esprit.tahanaat.entity.Joueur;
import tn.esprit.tahanaat.repo.EquipeRepository;

@Service
@AllArgsConstructor
public class EquipeServiceImpl implements IEquipeService {
    
    private final EquipeRepository equipeRepository;
    
    @Override
    public Equipe ajouterEquipeEtJoueurs(Equipe equipe) {
        // Set the equipe reference for each joueur
        if (equipe.getJoueurs() != null) {
            equipe.getJoueurs().forEach(joueur -> joueur.setEquipe(equipe));
        }
        // Save the equipe which will cascade save the joueurs due to CascadeType.ALL
        return equipeRepository.save(equipe);
    }
}
