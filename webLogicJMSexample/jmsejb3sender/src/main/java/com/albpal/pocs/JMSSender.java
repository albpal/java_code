package com.albpal.pocs;

public interface JMSSender extends java.io.Serializable
{
  public void sendGivenMessages(int numberOfMessageToSend, String id, String message);
}
