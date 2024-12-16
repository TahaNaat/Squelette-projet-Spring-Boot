package tn.esprit.tahanaat.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.tahanaat.entity.Rencontre;
import tn.esprit.tahanaat.entity.Arbitre;

import java.time.LocalDate;
import java.util.List;

public interface RencontreRepository extends JpaRepository<Rencontre, Long> {
    @Query("SELECT r FROM Rencontre r WHERE r.dateMatch = ?1")
    List<Rencontre> findByDateMatch(LocalDate date);
    @Query("SELECT DISTINCT r.arbitre FROM Rencontre r WHERE r.equipeHome.id = :idEquipe OR r.equipeAway.id = :idEquipe")
    List<Arbitre> recupererArbitresDUneEquipe(Long idEquipe);
    @Query("UPDATE Rencontre r SET r.nbre_but = r.nbre_but + 1 WHERE r.id = :idRencontre AND r.dateMatch = CURRENT_DATE")
    void incrementerNbreBut(Long idRencontre);

}
