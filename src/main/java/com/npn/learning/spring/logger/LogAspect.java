package com.npn.learning.spring.logger;

import com.npn.learning.spring.annotation.AroundWithParameters;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Aspect
@Component
public class LogAspect {

    /**
     * Создание условия через @Pointcut вызов по названию метода.
     * ВНИМАНИЕ! Если в условиях что-нибудь исключено, то если данные объекты добавлены в другом @Pointcut то они все
     * равно будут исключены из итоговой выборки.
     * То есть выполнение происходит не: выборка по Pointcut1 + выборка по Pointcut2 а создаем общее выражение
     * (Pointcut1 + Pointcut2) и потом это выражение выполняем
     *
     */
    @Pointcut("execution(public * com.npn.learning.spring.model.*.*(..)) && !execution(* get*(..)) && !execution(* set*(..))")
    public void pointcutAllExcludeGetAndSet() {}

    /**
     * Создание условия через @Pointcut.
     */
    @Pointcut("execution(public * com.npn.learning.spring.model.interfacesample.*.*(..)))")
    public void interfaceSampleMethod() {}

    /**
     * Логгирование входа в методы
     * @param point JoinPoint
     */
    @Before("pointcutAllExcludeGetAndSet()")
    public void beforeLog(JoinPoint point) {
        Signature signature = point.getSignature();
        Logger logger = LoggerFactory.getLogger(signature.getDeclaringType());
        logger.debug("Enter the method {} args {}",signature, point.getArgs());
    }

    /**
     * Логгирование входа в методы см. примечание у @Pointcut
     * @param point JoinPoint
     */
    @Before("interfaceSampleMethod()")
    public void beforeLogInterface(JoinPoint point) {
        Signature signature = point.getSignature();
        Logger logger = LoggerFactory.getLogger(signature.getDeclaringType());
        logger.debug("Enter the method {} args {}",signature, point.getArgs());
    }

    /**
     * Логгирование исключений
     * @param point JoinPoint
     * @param error Exception
     * @throws Throwable Exception
     */
    @AfterThrowing(value = "execution(* com.npn.learning.spring.model.*.*(..))", throwing = "error")
    public void afterTrowing(JoinPoint point, Exception error) throws Throwable {
        Signature signature = point.getSignature();
        Logger logger = LoggerFactory.getLogger(signature.getDeclaringType());
        StringBuilder builder = new StringBuilder();
        Arrays.stream(error.getStackTrace()).forEach(x->builder.append(x.toString()).append("\n"));
        logger.error("Exception in {} message: {}\n{}", signature, error.getMessage(),builder.toString());
        throw error;
    }

    /**
     * Аспект типа Around
     *
     * @param point ProceedingJoinPoint
     * @return результат срабатывания функции
     * @throws Throwable
     */
    @Around("@annotation(com.npn.learning.spring.annotation.Around)")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Signature signature = point.getSignature();
        long start = System.currentTimeMillis();
        Logger logger = LoggerFactory.getLogger("Time");
        Object proceed = point.proceed();
        long time = System.currentTimeMillis() - start;
        logger.debug("Method {} executing {} ms",signature,time);
        return proceed;
    }

    /**
     * Аспект типа Around c аннотацией с параметрами
     * @param point ProceedingJoinPoint
     * @param around аннотация
     * @return результат срабатывания функции
     * @throws Throwable
     */
    @Around("execution(* com.npn.learning.spring.model.*.*(..)) && @annotation(around)")
    public Object aroundWithAnnotationWithParameters(ProceedingJoinPoint point, AroundWithParameters around) throws Throwable {
        Signature signature = point.getSignature();
        Logger logger = LoggerFactory.getLogger("aroundWithAnnotationWithParameters");
        logger.debug("Method {} count = {} value = {}",signature,around.count(),around.value());
        return point.proceed();
    }

    /**
     * Аспект типа Around с аннотацией и определяющийся по параметрам функции
     *
     * @param point ProceedingJoinPoint
     * @param arg1 аргументы функции
     * @param arg2 аргументы функции
     * @return результат срабатывания функции
     * @throws Throwable
     */
    @Around(value = "args(arg1,arg2,..) && @annotation(com.npn.learning.spring.annotation.Around)", argNames = "point,arg1,arg2")
    public Object aroundWithParameter(ProceedingJoinPoint point, String arg1, int arg2) throws Throwable {
        Signature signature = point.getSignature();
        Logger logger = LoggerFactory.getLogger("aroundWithParameters");
        logger.debug("Method {} arg1 = {} arg2 = {}",signature,arg1,arg2);
        return point.proceed();
    }


}
