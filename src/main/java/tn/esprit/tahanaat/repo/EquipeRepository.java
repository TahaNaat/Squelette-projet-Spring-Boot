package tn.esprit.tahanaat.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tahanaat.entity.Equipe;

public interface EquipeRepository extends JpaRepository<Equipe, Long> {
}
