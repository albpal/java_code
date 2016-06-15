package com.oracle.utils;

import java.util.Hashtable;
import java.io.InputStream;
import java.util.Properties;

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

//  To execute the code java -cp jmsSender-1.0-SNAPSHOT.jar:/opt/oracle/as/wls12.1.2.0/soft/wlserver/server/lib/* com.oracle.utils.Sender
@Remote
@Stateless(name="JMSSenderBean", mappedName="JMSSenderBean")
public class JMSSenderBean
{
    public final static String JNDI_FACTORY="weblogic.jndi.WLInitialContextFactory";
    public void sendGivenMessages(int numberOfMessageToSend) throws Exception
    {
      java.io.InputStream is = JMSSenderBean.class.getClassLoader().getResourceAsStream("jms.properties");
      java.util.Properties p = new Properties();
      p.load(is);
      String url = p.getProperty("url");
      String queueName = p.getProperty("queue");
      String factoryName = p.getProperty("factory");
      String message = p.getProperty("message");
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
	       // DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
	       // Date date = new Date();
	       //System.out.println(dateFormat.format(date));
	       TextMessage msg = queueSession.createTextMessage();

	       //msg.setText(dateFormat.format(date) + "/100/manzana:50,pera:50");
	       msg.setText(message);
	       queueSender.send(msg);
	       // print the message
	       System.out.println("sent: " + msg.getText());
	       queueConn.close();
	       	Thread.sleep(10);
          i++;
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
