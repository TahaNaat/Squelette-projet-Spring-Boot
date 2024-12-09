package tn.esprit.tahanaat.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
@Slf4j
public class AspectConfig {
    // Ajouter ici les méthodes de configuration des aspects
    @AfterReturning("execution(* tn.esprit.tahanaat.service.*.ajouter*(..))")//etoile si type de return non specifiee ; void si pas de return
    void journaliser(JoinPoint joinPoint) {
        log.info("C'est une methode d'ajout : " + joinPoint.getSignature().getName());
    }
    @AfterReturning("execution(* tn.esprit.tahanaat.service.*.affecter*(..))")
    void journaliser1(JoinPoint joinPoint) {
        log.info("C'est une methode d'ajout : " + joinPoint.getSignature().getName());
    }
    @Around("execution(* tn.esprit.tahanaat.service.*.affecter*(..))")//calculer le temps d'execution
    Object calculerTempsExecution(ProceedingJoinPoint pjp ) throws Throwable{
        LocalDateTime debut = LocalDateTime.now();
        Object obj = pjp.proceed();
        LocalDateTime fin = LocalDateTime.now();
        long duree = java.time.Duration.between(debut, fin).toMillis();
        log.info("Temps d'execution de la methode : " + pjp.getSignature().getName() + " est " + duree + " millisecondes");
        return obj;
     }
}
