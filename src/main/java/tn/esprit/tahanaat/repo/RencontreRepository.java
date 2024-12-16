package tn.esprit.tahanaat.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.tahanaat.entity.Rencontre;

import java.time.LocalDate;
import java.util.List;

public interface RencontreRepository extends JpaRepository<Rencontre, Long> {
    @Query("SELECT r FROM Rencontre r WHERE r.dateMatch = ?1")
    List<Rencontre> findByDateMatch(LocalDate date);
}
