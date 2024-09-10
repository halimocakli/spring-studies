package com.halim.educativeschool.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Slf4j
@Aspect
@Component
public class LoggerAspect
{
    @Around("execution(* com.halim.educativeschool..*.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable
    {
        log.info(STR."\{joinPoint.getSignature().toString()} method execution start");

        Instant start = Instant.now();
        Object returnObj = joinPoint.proceed();
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();

        log.info(STR."Time took to execute \{joinPoint.getSignature().toString()} method is : \{timeElapsed}");
        log.info(STR."\{joinPoint.getSignature().toString()} method execution end");

        return returnObj;
    }

    @AfterThrowing(value = "execution(* com.halim.educativeschool.*.*(..))", throwing = "ex")
    public void logException(JoinPoint joinPoint, Exception ex)
    {
        log.error(STR."\{joinPoint.getSignature()} An exception happened due to : \{ex.getMessage()}");
    }
}
