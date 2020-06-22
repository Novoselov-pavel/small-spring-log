package logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class LogAspect {

    /**
     * Логгирование входа в методы
     * @param point JoinPoint
     */
    public void beforeLog(JoinPoint point) {
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
    public void afterTrowing(JoinPoint point, Exception error) throws Throwable {
        Signature signature = point.getSignature();
        Logger logger = LoggerFactory.getLogger(signature.getDeclaringType());
        StringBuilder builder = new StringBuilder();
        Arrays.stream(error.getStackTrace()).forEach(x->builder.append(x.toString()).append("\n"));
        logger.error("Exception in {} message: {}\n{}", signature, error.getMessage(),builder.toString());
        throw error;
    }


}
