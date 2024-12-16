package tn.esprit.tahanaat.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Arbitre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nom;
    private String prenom;
    private String nationalite;
    
    @Enumerated(EnumType.STRING)
    private Niveau niveau;
    
    @OneToMany(mappedBy = "arbitre")
    private Set<Rencontre> rencontres;
}
