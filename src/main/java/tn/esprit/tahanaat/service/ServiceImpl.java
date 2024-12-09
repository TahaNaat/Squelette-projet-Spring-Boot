package tn.esprit.tahanaat.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tahanaat.entity.UserTest;
import tn.esprit.tahanaat.repo.UserTestRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class ServiceImpl implements IService {
    UserTestRepo userTestRepo;

    @Override
    public UserTest ajouterUser(UserTest userTest) {
        return userTestRepo.save(userTest);
    }
}
