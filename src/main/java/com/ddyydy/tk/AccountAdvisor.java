//package com.ddyydy.tk;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Component;
//
//@Aspect//标志这是一个切面
//@Component//和@Service作用一样，都是在spring容器中声明一个Bean
//public class AccountAdvisor {
//    @Pointcut("execution(* com.ddyydy.tk.*.*(..))")
//    public void pointcut(){}
//    @Before("pointcut()")
//    public void before(JoinPoint jp){
//        System.out.println("我是前置增强！！！");
//    }
//}