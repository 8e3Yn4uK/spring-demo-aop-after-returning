package com.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by 8e3Yn4uK on 13.03.2019
 */

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {


    @Before("com.aopdemo.aspect.PointcutExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {

        System.out.println("\n Executing @Before advice");


        // display the method signature
        MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("\n Method: " + methodSignature);

        // display method arguments
        Object[] args = theJoinPoint.getArgs();
        for (Object temp : args) {
            System.out.println(temp);
        }

    }
}
