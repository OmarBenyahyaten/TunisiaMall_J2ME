/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tnMallMidlet;

import javax.microedition.lcdui.Display;
import javax.microedition.midlet.*;
import GUI.loginGui;
import entities.Film;
import java.io.IOException;
import javax.microedition.lcdui.Displayable;
import javax.microedition.media.Manager;
import javax.microedition.media.MediaException;
import javax.microedition.media.Player;
import omar.GoogleMapsPathCanvas;
import omar.*;


/**
 * @author timoumi med hedi
 */
public class Login extends MIDlet {
       public Display disp = Display.getDisplay(this);
        public static Login exam;
        public static int id;
        public static String username;
         public static int modifier=0;
         public Displayable d=new GoogleMapsPathCanvas(this, null, 12.2, 12.2);
       
    
    public void startApp() {
         try {
                          exam = this ;

             Player p = null;
             p = Manager.createPlayer(getClass().getResourceAsStream("/img/welcome.mp3"), "audio/mp3");
             p.setLoopCount(1);
             p.start();
             disp.setCurrent(new Welcome());
             Thread.sleep(3500);
             p.stop();
             try {
                 id=-1;
                 username="";
                 
                 disp.setCurrent(new Menu());
             } catch (IOException ex) {
                 ex.printStackTrace();
             }
         } catch (IOException ex) {
             ex.printStackTrace();
         } catch (MediaException ex) {
               ex.printStackTrace();
           } catch (InterruptedException ex) {
               ex.printStackTrace();
           }
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }
    public void over() {
        Retriever12 r=new Retriever12();
        r.start();
        
   disp.setCurrent(new GoogleMapsPathCanvas(this, d,r.a,r.b));
      

        
        
       
        
    }
    
}
