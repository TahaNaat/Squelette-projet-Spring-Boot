package tn.esprit.tahanaat.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tahanaat.entity.Arbitre;
import tn.esprit.tahanaat.entity.Equipe;
import tn.esprit.tahanaat.entity.Rencontre;
import tn.esprit.tahanaat.repo.ArbitreRepository;
import tn.esprit.tahanaat.repo.EquipeRepository;
import tn.esprit.tahanaat.repo.RencontreRepository;

@Service
@AllArgsConstructor
public class RencontreServiceImpl implements IRencontreService {

    private final RencontreRepository rencontreRepository;
    private final EquipeRepository equipeRepository;
    private final ArbitreRepository arbitreRepository;

    @Override
    public Rencontre ajouterRencontreEtAffecterEquipes(Rencontre rencontre, Long idEquipe1, Long idEquipe2) {
        // Initialize nbre_but to 0
        rencontre.setNbre_but(0);
        
        // Find and set the home team (equipe1)
        Equipe equipe1 = equipeRepository.findById(idEquipe1)
                .orElseThrow(() -> new RuntimeException("Home team not found"));
        rencontre.setEquipeHome(equipe1);
        
        // Find and set the away team (equipe2)
        Equipe equipe2 = equipeRepository.findById(idEquipe2)
                .orElseThrow(() -> new RuntimeException("Away team not found"));
        rencontre.setEquipeAway(equipe2);
        
        // Save and return the rencontre
        return rencontreRepository.save(rencontre);
    }

    @Override
    public void affecterArbitreARencontre(String nom, String prenom, Long idR) throws Exception {
        // Find the rencontre
        Rencontre rencontre = rencontreRepository.findById(idR)
                .orElseThrow(() -> new Exception("Rencontre not found"));

        // Find the arbitre by nom and prenom
        Arbitre arbitre = arbitreRepository.findAll().stream()
                .filter(a -> a.getNom().equals(nom) && a.getPrenom().equals(prenom))
                .findFirst()
                .orElseThrow(() -> new Exception("Arbitre not found"));

        // Check if levels match
        if (arbitre.getNiveau() != rencontre.getNiveau()) {
            throw new Exception("Exception déclanchée");
        }

        // Affect arbitre to rencontre
        rencontre.setArbitre(arbitre);
        rencontreRepository.save(rencontre);
    }
}