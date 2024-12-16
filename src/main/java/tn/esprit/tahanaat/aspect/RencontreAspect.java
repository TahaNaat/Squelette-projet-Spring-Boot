package tn.esprit.tahanaat.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RencontreAspect {
    
    private static final Logger logger = LoggerFactory.getLogger(RencontreAspect.class);
    
    @AfterThrowing(
        pointcut = "execution(* tn.esprit.tahanaat.service.RencontreServiceImpl.affecterArbitreARencontre(..))",
        throwing = "ex"
    )
    public void afterArbitreAffectationException(JoinPoint joinPoint, Exception ex) {
        logger.warn("Il faut affecter un arbitre de meme niveau que la rencontre");
    }
}
