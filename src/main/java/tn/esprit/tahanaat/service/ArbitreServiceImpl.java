package tn.esprit.tahanaat.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tahanaat.entity.Arbitre;
import tn.esprit.tahanaat.repo.ArbitreRepository;

@Service
@AllArgsConstructor
public class ArbitreServiceImpl implements IArbitreService {
    
    private final ArbitreRepository arbitreRepository;
    
    @Override
    public Arbitre ajouterArbitre(Arbitre arbitre) {
        return arbitreRepository.save(arbitre);
    }
}
