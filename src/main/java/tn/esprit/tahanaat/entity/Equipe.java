package tn.esprit.tahanaat.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nomEquipe;
    private LocalDate dateCreation;
    
    @OneToMany(mappedBy = "equipe", cascade = CascadeType.ALL)
    private Set<Joueur> joueurs;
    
    @OneToMany(mappedBy = "equipeHome")
    private Set<Rencontre> rencontresHome;
    
    @OneToMany(mappedBy = "equipeAway")
    private Set<Rencontre> rencontresAway;
}
