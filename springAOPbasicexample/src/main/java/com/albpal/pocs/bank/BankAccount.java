package com.albpal.pocs.bank;

public abstract class BankAccount
{
  protected String accountId;
  protected int accountAmount;

  public abstract boolean IsAvailableToTransfer(int amount);
  public abstract boolean IsAvailableToReceive(int amount);

  public void setAccountId(String aID)
  {
      accountId = aID;
  }

  public void deposit(int quantity)
  {
      accountAmount += quantity;
  }

  public void withDraw(int quantity)
  {
      accountAmount -= quantity;
  }

  public String getInformation()
  {
    return "Account type " + getClass().getName() + " with id " + accountId + " has " + accountAmount + "€";
  }
}
