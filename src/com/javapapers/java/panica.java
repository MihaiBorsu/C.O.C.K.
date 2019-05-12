package com.javapapers.java;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import bench.test.PCSpecs;

public class panica
{   
	public void SendFromYahoo()
	{
	  	  PCSpecs specs = new PCSpecs();
			  ((PCSpecs) specs).PCSpec();
		  
    // Sender's email ID needs to be mentioned
	String from = "tester_dummy@yahoo.com";
     String pass ="macbookair";
    // Recipient's email ID needs to be mentioned.
     String to = "tester_dummy@yahoo.com";
     String host = "smtp.mail.yahoo.com";

   // Get system properties
   Properties properties = System.getProperties();
   // Setup mail server
   properties.put("mail.smtp.starttls.enable", "true");
   properties.put("mail.smtp.host", host);
   properties.put("mail.smtp.user", from);
   properties.put("mail.smtp.password", pass);
   properties.put("mail.smtp.port", "587");
   properties.put("mail.smtp.auth", "true");

   // Get the default Session object.
   Session session = Session.getDefaultInstance(properties);

   try{
      // Create a default MimeMessage object.
      MimeMessage message = new MimeMessage(session);

      // Set From: header field of the header.
      message.setFrom(new InternetAddress(from));

      // Set To: header field of the header.
      message.addRecipient(Message.RecipientType.TO,
                               new InternetAddress(to));

      // Set Subject: header field
      message.setSubject("PANIC BUTTON TRIGGERED!");

      // Now set the actual message
  	
      message.setText("Panic button has been triggered. Send reinforcements "
      		+ "to the following user: \nHostname: " + specs.hostname +
    		  "\n IPAdress: " + specs.ipadress +
    		   "\n OS Name: " + specs.nameos +
    		    "\n OS Type: " + specs.ostype +
    		     "\n OS Version: " + specs.osversion);
    		        

      // Send message
      Transport transport = session.getTransport("smtp");
      transport.connect(host, from, pass);
      transport.sendMessage(message, message.getAllRecipients());
      transport.close();
      System.out.println("Sent message successfully....");
   }catch (MessagingException mex) {
      mex.printStackTrace();
   }
	}
}