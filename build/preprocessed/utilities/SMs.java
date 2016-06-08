/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilities;

/**
 *
 * @author timoumi med hedi
 */
import javax.microedition.io.*;
import javax.microedition.lcdui.*;
import javax.microedition.midlet.MIDlet;
import javax.wireless.messaging.*;
public class SMs extends MIDlet implements CommandListener,Runnable {
      Display display;
      private TextField toWhom;
      private TextField message;
      private Alert alert;
      private Command send,exit;
      MessageConnection clientConn;
      private Form compose;
      public SMs() {
            display=Display.getDisplay(this);
            compose=new Form("Compose Message");
            toWhom=new TextField("To","",10,TextField.PHONENUMBER);
            message=new TextField("Message","",600,TextField.ANY);
            send=new Command("Send",Command.BACK,0);
            exit=new Command("Exit",Command.SCREEN,5);
            compose.append(toWhom);
            compose.append(message);
            compose.addCommand(send);
            compose.addCommand(exit);
            compose.setCommandListener(this);
      }
      public void startApp() {
            display.setCurrent(compose);
      }
      public void pauseApp() {
      }
      public void destroyApp(boolean unconditional) {
            notifyDestroyed();
      }
      public void commandAction(Command cmd,Displayable disp) {
            if(cmd==exit) {
                  destroyApp(false);
            }
            if(cmd==send) {
               Thread th=new Thread(this);
               th.start();
      }}

    public void run() {
      String mno=toWhom.getString();
                  String msg=message.getString();
                  if(mno.equals("")) {
                        alert = new Alert("Alert");
                        alert.setString("Enter Mobile Number!!!");
                        alert.setTimeout(2000);
                        display.setCurrent(alert);
                  }
                  else {
                        
                  }
            }

}