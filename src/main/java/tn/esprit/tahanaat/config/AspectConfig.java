package tn.esprit.tahanaat.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class AspectConfig {
    // Ajouter ici les méthodes de configuration des aspects
    @Before("execution(* tn.esprit.tahanaat.service.*.*(..))")
    void journaliser(JoinPoint joinPoint) {
        log.info("Méthode invoquée : " + joinPoint.getSignature().getName());
    }
}
