package com.albpal.pocs.bank;

public class TransactionManager
{
  public void transfer(BankAccount fromAccount, BankAccount toAccount, int amount)
  {
    if (fromAccount.IsAvailableToTransfer(amount) && toAccount.IsAvailableToReceive(amount))
    {
      fromAccount.withDraw(amount);
      toAccount.deposit(amount);
    }
  }
}
