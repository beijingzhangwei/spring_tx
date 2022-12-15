package com.ddyydy.tk;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        if (args.length > 0){
            System.out.println(args[0]);
            RuntimeArgs.setPasswd(args[0]);
            System.out.println(args[1]);
        }
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        AccountService bean = (AccountService) context.getBean("accountService_1");
        bean.changemonkey();//模拟转账
    }
}