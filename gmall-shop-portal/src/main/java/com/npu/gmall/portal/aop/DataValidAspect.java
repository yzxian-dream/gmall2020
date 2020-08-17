package com.npu.gmall.portal.aop;

import com.npu.gmall.to.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

//利用aop完成统一的数据校验，数据校验出错就返回给前端错误提示
@Slf4j
@Aspect
@Component
public class DataValidAspect {

    /**
     * 目标方法的异常，一般都需要再次抛出去，让别人感知。
     * @param point
     * @return
     */
    @Around("execution(* com.npu.gmall.portal..*Controller.*(..))")
    public Object validAround(ProceedingJoinPoint point){

        Object proceed=null;


        try{
            //获取目标方法参数
            Object[] args = point.getArgs();
            for(Object obj:args){
                if(obj instanceof BindingResult){
                    BindingResult r=(BindingResult)obj;
                    int errorCount = r.getErrorCount();
                    if(errorCount>0){
                        //框架自动校验检测到错误
                        return new CommonResult().validateFailed(r);
                    }
                }
            }
//            log.debug("校验切面开始工作");
//            System.out.println("前置通知");
            //就是我们反射的 method.invoke();
            proceed = point.proceed(point.getArgs());
//            System.out.println("返回通知");
//            log.debug("校验切面将目标方法已经放行...{}",proceed);
        } catch (Throwable t){
            //将异常抛出去被异常方法捕获
            throw new RuntimeException(t);
        }finally {
//            System.out.println("后置通知");
        }
        return proceed;
    }

}
