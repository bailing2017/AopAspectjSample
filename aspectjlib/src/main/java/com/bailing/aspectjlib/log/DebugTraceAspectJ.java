package com.bailing.aspectjlib.log;

import com.bailing.aspectjlib.func.DebugLog;
import com.bailing.aspectjlib.func.StopWatch;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * Desc:
 * Creator ling
 * Date:   2017/11/27 0027 11:09
 */
@Aspect
public class DebugTraceAspectJ {

    private static final String POINTCUT_METHOD =
        "execution(@com.bailing.aspectjlib.log.DebugTrace * *(..))";

    private static final String POINTCUT_CONSTRUCTOR =
        "execution(@com.bailing.aspectjlib.log.DebugTrace *.new(..))";

    @Pointcut(POINTCUT_METHOD + "||" + POINTCUT_CONSTRUCTOR)
    public void methodAnnotatedWithDebugTrace() {
    }


    @Around("methodAnnotatedWithDebugTrace()")
    public Object weaveJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        DebugTrace debugTrace = methodSignature.getMethod().getAnnotation(DebugTrace.class);
        if (debugTrace == null) {
            return joinPoint.proceed();
        }

        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();

        final StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object result = joinPoint.proceed();
        stopWatch.stop();

        DebugLog.log(className, buildLogMessage(methodName, stopWatch.getTotalTimeMillis()));

        return result;
    }

    /**
     * Create a log message.
     *
     * @param methodName     A string with the method name.
     * @param methodDuration Duration of the method in milliseconds.
     * @return A string representing message.
     */
    private static String buildLogMessage(String methodName, long methodDuration) {
        StringBuilder message = new StringBuilder();
        message.append("Gintonic --> ");
        message.append(methodName);
        message.append(" --> ");
        message.append("[");
        message.append(methodDuration);
        message.append("ms");
        message.append("]");

        return message.toString();
    }
}
