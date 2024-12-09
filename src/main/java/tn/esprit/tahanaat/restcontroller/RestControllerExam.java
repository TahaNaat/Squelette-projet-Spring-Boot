package tn.esprit.tahanaat.restcontroller;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.tahanaat.entity.UserTest;
import tn.esprit.tahanaat.service.IService;

@RestController// @RestController annotation is used to create RESTful web services using Spring MVC.
@AllArgsConstructor
public class RestControllerExam {
    IService iService;//injection de Iservice
    @PostMapping("/user-test")
    UserTest ajoutUser(@RequestBody UserTest userTest){
        return iService.ajouterUser(userTest);
    }
}
