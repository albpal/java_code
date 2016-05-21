package com.albpal.pocs.bank;

public class NormalAccount extends BankAccount
{
  @Override
  public boolean IsAvailableToTransfer(int amount)
  {
    if (accountAmount >= amount)
      return true;
    return false;
  }

  @Override
  public boolean IsAvailableToReceive(int amount)
  {
    return true;
  }
}
