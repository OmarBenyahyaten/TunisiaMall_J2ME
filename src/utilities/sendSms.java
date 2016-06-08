/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import javax.microedition.io.Connector;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Form;
import javax.wireless.messaging.MessageConnection;
import javax.wireless.messaging.TextMessage;

/**
 *
 * @author timoumi med hedi
 */
public class sendSms {
    public static void sendit(String paramString1, String paramString2)
 {
     MessageConnection clientConn;
  
   try {
        clientConn = (MessageConnection)Connector.open("sms://"+paramString1);
                        
                        
                              TextMessage textmessage = (TextMessage) clientConn.newMessage(MessageConnection.TEXT_MESSAGE);
                              textmessage.setAddress("sms://"+paramString1);
                              textmessage.setPayloadText(paramString2);
                              clientConn.send(textmessage);
                        }
                        catch(Exception e)
                        {
                              System.out.println("unsend");
                        }
    
    
   
 }
    
}
