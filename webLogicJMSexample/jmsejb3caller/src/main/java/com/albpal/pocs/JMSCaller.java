package com.albpal.pocs;

import java.util.Hashtable;
import java.io.InputStream;
import java.util.Properties;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Arrays;

import javax.naming.InitialContext;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.QueueSession;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;

import javax.naming.Context;
import javax.naming.NamingException;

import com.albpal.pocs.JMSSender;

//  To execute the code java -cp jmsSender-1.0-SNAPSHOT.jar:/opt/oracle/as/wls12.1.2.0/soft/wlserver/server/lib/* com.oracle.utils.Sender

public class JMSCaller
{
  public final static String JNDI_FACTORY="weblogic.jndi.WLInitialContextFactory";
  public static void main(String[] args) throws Exception
  {
      if (args.length < 1)
      {
        System.out.println("Pass the number of messages to send as parameter.");
        return;
      }
      int numberOfMessageToSend = Integer.valueOf(args[0]);
      int i = 0;
      System.out.println("Number of message to send: " + numberOfMessageToSend);
      DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
      Date dateIni = new Date();
      System.out.println("Fecha inicio: " + dateFormat.format(dateIni));
      try
       {
                 java.io.InputStream is = JMSCaller.class.getClassLoader().getResourceAsStream("jms.properties");
                 java.util.Properties p = new Properties();
                 p.load(is);
                 String url = p.getProperty("url");
                 String ejb = p.getProperty("ejb");
                 String messageSizeOnKB = p.getProperty("messageSizeOnKB");
                 int messageSizeOnBytes = (Integer.valueOf(messageSizeOnKB)) * 1024;
                 char[] data = new char[messageSizeOnBytes];
                 Arrays.fill(data, 'a');
                 String message = new String(data);

                 InitialContext ctx = getInitialContext(url);
                 JMSSender jmsBean=(JMSSender)ctx.lookup(ejb);
                 while (i < numberOfMessageToSend)
                 {
                     jmsBean.sendGivenMessages(1, String.valueOf(i), message);
                     i++;
                 }
       }
       catch(Exception e)
       {
         e.printStackTrace();
       }
       Date dateFin = new Date();
       System.out.println("Fecha Fin: " + dateFormat.format(dateFin));
       long diffMs = dateFin.getTime() - dateIni.getTime();
       System.out.println("Mensages por segundo : " + (numberOfMessageToSend / (diffMs/1000)));
    }

  protected static InitialContext getInitialContext(String url) throws NamingException
  {
      Hashtable<String,String> env = new Hashtable<String,String>();
      env.put(Context.INITIAL_CONTEXT_FACTORY, JNDI_FACTORY);
      env.put(Context.PROVIDER_URL, url);
      env.put("weblogic.jndi.createIntermediateContexts", "true");
      return new InitialContext(env);
  }
}
