package com.example.finalproject;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class MyAspects {

    //////////////////////////////////
    // Create logging at service layer only

    @After(value = "execution(* com.example.finalproject.services..*.*(..))")
    public void afterExecutingService(JoinPoint joinPoint) {
        log.info("Finished executing {}", joinPoint.getSignature().getName());
    }

    @Before(value = "execution(* com.example.finalproject.services..*.*(..))")
    public void beforeExecutingService(JoinPoint joinPoint) {
        log.info("About to execute {} with arguments {}",
                joinPoint.getSignature().getName(),
                joinPoint.getArgs())    ;
    }

    /////////////////////////////////////////////


}
