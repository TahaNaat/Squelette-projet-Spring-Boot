package tn.esprit.tahanaat.service;

import tn.esprit.tahanaat.entity.Rencontre;

public interface IRencontreService {
    Rencontre ajouterRencontreEtAffecterEquipes(Rencontre rencontre, Long idEquipe1, Long idEquipe2);
    void affecterArbitreARencontre(String nom, String prenom, Long idR) throws Exception;
}
