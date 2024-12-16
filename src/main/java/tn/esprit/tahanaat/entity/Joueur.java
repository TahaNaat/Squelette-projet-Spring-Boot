package tn.esprit.tahanaat.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Joueur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nom;
    private String prenom;
    private int num_maillot;
    
    @Enumerated(EnumType.STRING)
    private Poste poste;
    
    @ManyToOne
    @JoinColumn(name = "equipe_id")
    private Equipe equipe;
}
