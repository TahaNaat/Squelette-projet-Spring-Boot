package tn.esprit.tahanaat.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rencontre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private LocalDate dateMatch;
    private int nbre_but;
    private String nomStade;
    
    @Enumerated(EnumType.STRING)
    private Niveau niveau;
    
    @ManyToOne
    @JoinColumn(name = "arbitre_id")
    private Arbitre arbitre;
    
    @ManyToOne
    @JoinColumn(name = "equipe_home_id")
    private Equipe equipeHome;
    
    @ManyToOne
    @JoinColumn(name = "equipe_away_id")
    private Equipe equipeAway;
}
