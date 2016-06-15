package com.oracle.utils;

import java.util.Hashtable;
import java.io.InputStream;
import java.util.Properties;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

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
import javax.ejb.Stateless;
import javax.ejb.Remote;
import javax.ejb.Asynchronous;

import com.albpal.pocs.JMSSender;

//  To execute the code java -cp jmsSender-1.0-SNAPSHOT.jar:/opt/oracle/as/wls12.1.2.0/soft/wlserver/server/lib/* com.oracle.utils.Sender
@Remote
@Stateless(name="JMSSenderBean", mappedName="JMSSenderBean")
@Asynchronous
public class JMSSenderBean implements JMSSender
{
    public final static String JNDI_FACTORY="weblogic.jndi.WLInitialContextFactory";
    public void sendGivenMessages(int numberOfMessageToSend, String id, String message)
    {
      try
      {
        java.io.InputStream is = JMSSenderBean.class.getClassLoader().getResourceAsStream("jms.properties");
        java.util.Properties p = new Properties();
        p.load(is);
        String url = p.getProperty("url");
        String queueName = p.getProperty("queue");
        String factoryName = p.getProperty("factory");
        //String message = p.getProperty("message");
      	int messages = -1;
        int i = 0;
      	while (i < numberOfMessageToSend)
        {
  	       // get the initial context
  	       InitialContext ctx = getInitialContext(url);
  	       // lookup the queue object
  	       Queue queue = (Queue) ctx.lookup(queueName);
  	       // lookup the queue connection factory
  	       QueueConnectionFactory connFactory = (QueueConnectionFactory) ctx.
  	           lookup(factoryName);
  	       // create a queue connection
  	       QueueConnection queueConn = connFactory.createQueueConnection();
  	       // create a queue session
  	       QueueSession queueSession = queueConn.createQueueSession(false,
  	           Session.AUTO_ACKNOWLEDGE);
  	       // create a queue receiver
  	       QueueSender queueSender = queueSession.createSender(queue);
  	       // start the connection
  	       queueConn.start();
  	       // receive a message
  	       TextMessage msg = queueSession.createTextMessage();

  	       //msg.setText(dateFormat.format(date) + "/100/manzana:50,pera:50");
  	       msg.setText(message);
           //DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
           DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
  	       Date iniDate = new Date();
  	       //System.out.println(id + " " + i + ":" + dateFormat.format(date));

  	       queueSender.send(msg);

  	       Date endDate = new Date();
           long msDiff = endDate.getTime() - iniDate.getTime();
  	       System.out.println(id + " " + i + ": " + dateFormat.format(iniDate) + " -> " + dateFormat.format(endDate) + "(" + dateFormat.format(msDiff) + ")");

  	       // print the message
  	       //System.out.println("sent: " + msg.getText());
  	       queueConn.close();
            i++;
      	}
      }catch(Exception e)
      {
        e.printStackTrace();
      }
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
