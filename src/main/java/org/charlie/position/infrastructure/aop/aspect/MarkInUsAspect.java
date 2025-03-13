package org.charlie.position.infrastructure.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author Charlie
 * @description 性能检查，打印毫秒、纳秒日志
 * @title MarkInMsAspect
 * @date 2025/3/13 17:10
 **/
@Aspect
@Component
public class MarkInUsAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * @return java.lang.Object
     * @Description 拦截MarkInMs注解，增加耗时统计，以毫秒、纳秒计时
     * @Date 2025/3/13
     * @Param [org.aspectj.lang.ProceedingJoinPoint]
     * @Author Charlie
     **/
    @Around("@annotation(org.charlie.position.infrastructure.aop.annotation.MarkInUs)")
    public Object MarkInMs(ProceedingJoinPoint joinPoint) throws Throwable {
        // 获取纳秒值
        long start = System.nanoTime();
        Object result = joinPoint.proceed(joinPoint.getArgs());
        // 微秒
        long costInMicrosecond = (System.nanoTime() - start) / 1000;
        // 毫秒
        long costInMillisecond = (System.nanoTime() - start) / 1000000;
        String[] classFullNames = joinPoint.getTarget().getClass().getName().split("\\.");
        String classShortName = classFullNames[classFullNames.length - 1];
        String method = joinPoint.getSignature().getName();
        logger.info("执行方法：【{}.{}】，耗时【{}】毫秒，【{}】微秒", classShortName, method, costInMillisecond, costInMicrosecond);
        return result;
    }
}
