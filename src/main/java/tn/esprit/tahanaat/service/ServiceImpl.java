package tn.esprit.tahanaat.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.tahanaat.entity.UserTest;
import tn.esprit.tahanaat.repo.UserTestRepo;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ServiceImpl implements IService {
    UserTestRepo userTestRepo;

    @Override
    public UserTest ajouterUser(UserTest userTest) {
        return userTestRepo.save(userTest);
    }
   @Scheduled(cron = "*/60 * * * * *")//cron = "second minute hour day month year"
   //@Scheduled(fixedDelay = 60000)//ms
    void testScheduler(){
        log.info("affichage test scheduler");
    }
}
