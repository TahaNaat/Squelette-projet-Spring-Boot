package tn.esprit.tahanaat.service;

import tn.esprit.tahanaat.entity.Arbitre;
import tn.esprit.tahanaat.entity.Rencontre;

import java.util.List;

public interface IRencontreService {
    Rencontre ajouterRencontreEtAffecterEquipes(Rencontre rencontre, Long idEquipe1, Long idEquipe2);
    void affecterArbitreARencontre(String nom, String prenom, Long idR) throws Exception;
    void incrementerNbreBut(Long idRencontre);
    List<Arbitre> recupererArbitresDUneEquipe(Long idEquipe);
}
