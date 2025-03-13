package org.charlie.position.infrastructure.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author Charlie
 * @description 性能检查，打印毫秒日志
 * @title MarkInMsAspect
 * @date 2025/3/13 17:10
 **/
@Aspect
@Component
public class MarkInMsAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * @Description 拦截MarkInMs注解，增加耗时统计，以毫秒计时
     * @Date  2025/3/13 
     * @Param [org.aspectj.lang.ProceedingJoinPoint] 
     * @return java.lang.Object
     * @Author Charlie
     **/
    @Around("@annotation(org.charlie.position.infrastructure.aop.annotation.MarkInMs)")
    public Object MarkInMs(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed(joinPoint.getArgs());
        long cost = System.currentTimeMillis() - start;
        String[] classFullNames = joinPoint.getTarget().getClass().getName().split("\\.");
        String classShortName = classFullNames[classFullNames.length - 1];
        String method = joinPoint.getSignature().getName();
        logger.info("执行方法：【{}.{}】，耗时【{}】毫秒",classShortName,method,cost);
        return result;
    }
}
