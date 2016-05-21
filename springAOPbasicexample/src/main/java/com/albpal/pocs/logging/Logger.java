package com.albpal.pocs.logging;

import com.albpal.pocs.bank.BankAccount;

public class Logger {
    public void informAboutATransactionStarting(BankAccount fromAccount, BankAccount toAccount, int amount)
    {
        System.out.println("***********CALL TO A NEW TRANSACTION *************");
        System.out.println("[Origin]: " + fromAccount.getInformation());
        System.out.println("[Destination]: " + toAccount.getInformation());
        System.out.println("[Amount]: " + amount);
    }

    public void informAboutATransactionEnding(BankAccount fromAccount, BankAccount toAccount, int amount)
    {
        System.out.println("***********END TRANSACTION**************");
    }
}
