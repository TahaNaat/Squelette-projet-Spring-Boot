package tn.esprit.tahanaat.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tahanaat.entity.UserTest;

@Repository
public interface UserTestRepo extends JpaRepository<UserTest, Long> {
}
