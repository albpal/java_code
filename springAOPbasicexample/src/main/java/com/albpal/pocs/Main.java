package com.albpal.pocs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.albpal.pocs.bank.*;

@SpringBootApplication
public class Main
{
      public static void main(String[] args)
      {
        ApplicationContext ctx = SpringApplication.run(Main.class, args);

        ApplicationContext appContext = new ClassPathXmlApplicationContext(new String[] { "Spring-Example.xml" });

        BankAccount account1 = (BankAccount) appContext.getBean("Account");
        BankAccount account2 = (BankAccount) appContext.getBean("Account");
        TransactionManager tm = (TransactionManager) appContext.getBean("TransactionManager");

        account1.setAccountId("1111111");
        account2.setAccountId("2222222");

        account1.deposit(1000);

        System.out.println("Initial scenario:");
        System.out.println("\t" + account1.getInformation());
        System.out.println("\t" + account2.getInformation());

        tm.transfer(account1, account2, 500);

        System.out.println("Final scenario:");
        System.out.println("\t" + account1.getInformation());
        System.out.println("\t" + account2.getInformation());
      }
}
