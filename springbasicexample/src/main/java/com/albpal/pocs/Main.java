package com.albpal.pocs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class Main
{
      public static void main(String[] args)
      {
        ApplicationContext ctx = SpringApplication.run(Main.class, args);

        ApplicationContext appContext = new ClassPathXmlApplicationContext(new String[] { "Spring-Example.xml" });

        Vehicle myCar = (Vehicle) appContext.getBean("bmw");

        myCar.foo();
      }
}
