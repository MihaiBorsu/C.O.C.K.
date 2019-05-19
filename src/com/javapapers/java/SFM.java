package com.javapapers.java;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.JOptionPane;

import bench.test.PCSpecs;
import bench.test.executor;

public class SFM
{   
	public void SendFromYahoo()
	{
  	  PCSpecs specs = new PCSpecs();
		  specs.PCSpec();
      executor ex = new executor();
		  ex.execute();
		  
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
      message.setSubject("Just another set of results.");

      // Now set the actual message
  	
      message.setText("Hostname: " + specs.hostname +
    		  "\n IPAdress: " + specs.ipadress +
    		   "\n OS Name: " + specs.nameos +
    		    "\n OS Type: " + specs.ostype +
    		     "\n OS Version: " + specs.osversion +
    		      "\n CPU Identifier: " + specs.proc1 +
    		       "\n CPU Architecture: " + specs.proc2 +
    		        "\n CPU ArchitEW6432: " + specs.proc3 +
    		         "\n CPU Nr Cores: " + specs.proc4 +
    		         "\n SCORE: " + ex.score);
    		        

      // Send message
      Transport transport = session.getTransport("smtp");
      transport.connect(host, from, pass);
      transport.sendMessage(message, message.getAllRecipients());
      transport.close();
      System.out.println("Sent message successfully....");
	  JOptionPane.showMessageDialog(null,"Your score is: "+ ex.score);
   }catch (MessagingException mex) {
      mex.printStackTrace();
   }
	}
}