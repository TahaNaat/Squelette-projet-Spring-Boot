package tn.esprit.tahanaat.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

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
}
