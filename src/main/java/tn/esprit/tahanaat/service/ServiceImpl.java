package tn.esprit.tahanaat.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.esprit.tahanaat.entity.Rencontre;
import tn.esprit.tahanaat.entity.UserTest;
import tn.esprit.tahanaat.repo.RencontreRepository;
import tn.esprit.tahanaat.repo.UserTestRepo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ServiceImpl implements IService {
    UserTestRepo userTestRepo;
        private static final Logger logger = LoggerFactory.getLogger(ServiceImpl.class);

 private final RencontreRepository rencontreRepository;

    @Override
    public UserTest ajouterUser(UserTest userTest) {
        return userTestRepo.save(userTest);
    }
   @Scheduled(cron = "*/60 * * * * *")//cron = "second minute hour day month year"
   //@Scheduled(fixedDelay = 60000)//ms
    void testScheduler(){
        log.info("affichage test scheduler");
    }
     @Scheduled(cron = "0 0 8 * * ?") // Every day at 08:00:00
    public void rencontreDeDateSys() {
        LocalDate today = LocalDate.now();
        List<Rencontre> rencontres = rencontreRepository.findByDateMatch(today);

        logger.info("**** Les rencontres d'aujourd'hui ****");
        for (Rencontre rencontre : rencontres) {
            logger.info("Rencontre entre {} et {} à {}", 
                rencontre.getEquipeHome().getNomEquipe(), 
                rencontre.getEquipeAway().getNomEquipe(), 
                rencontre.getNomStade());
        }
    }
}
