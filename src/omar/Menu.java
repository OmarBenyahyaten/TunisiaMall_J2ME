/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omar;

import GUI.CreateAccount;
import GUI.loginGui;
import GUI.pageAccueil;
import entities.User;
import googlemapapi.Midlet;
import java.io.IOException;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import tnMallMidlet.Login;
import utilities.ProcessUpdate;
import utilities.recupUser;

/**
 *
 * @author omarblythe
 */
public class Menu extends Canvas implements CommandListener{
Image img; 
int i ;
        Command cmdValider = new Command("Valider", Command.EXIT, 0);
        Command cmdExit = new Command("Exit", Command.EXIT, 0);
    private Object omar;

    public Menu() throws IOException {
            img= Image.createImage("/img/1.jpg");
            i=1 ;
    }

    protected void paint(Graphics g) {
        addCommand(cmdValider);
        addCommand(cmdExit);
        setCommandListener(this);
                g.drawImage(img,0,0,0);

    }

    public void commandAction(Command c, Displayable d) {

if (c==cmdValider){
    try {
        if(i==5)
        {
       Login.exam.disp.setCurrent(new NoteEnseigne());
        }
        
         if(i==2)
        {
            Login.exam.disp.setCurrent(new Article());
        }
          if(i==4)
        {
            Retriever12 r=new Retriever12();
            r.start();
            System.out.println();
            Login.exam.disp.setCurrent(new GoogleMapsPathCanvas(Login.exam, d, r.a, r.b));
        }
          if(i==7)
        {
            Login.exam.disp.setCurrent(new Film());
        }
        if(i==1)
        {
            if (Login.exam.id!=-1) {
                        Login.exam.disp.setCurrent(new CreateAccount(Login.username));
                    } else {
                      Login.exam.disp.setCurrent(new loginGui());
                    }
            
        }
        if(i==6)
        {
       Login.exam.disp.setCurrent(new NoteArticle());
        }
        if(i==8)
        {
               Login.exam.disp.setCurrent(new Visite());

        }
      
    } catch (IOException ex) {
        ex.printStackTrace();
    } catch (ParserConfigurationException ex) {
        ex.printStackTrace();
    } catch (SAXException ex) {
        ex.printStackTrace();
    }
}
if(c==cmdExit){
    Login.exam.destroyApp(false);
Login.exam.notifyDestroyed();
}
    }
    
    protected void keyPressed(int keyCode) {
        int gameAction = getGameAction(keyCode);

        if ((gameAction == LEFT) ) {
            if (i==1){
             try {
                i=8;
                img= Image.createImage("/img/"+i+".jpg");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            }else {
            try {
                i--;
                img= Image.createImage("/img/"+i+".jpg");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            }
        }
        if ((gameAction == RIGHT)) {
           if (i==8){
               try {
                   i=1;
                   img= Image.createImage("/img/"+i+".jpg");
               } catch (IOException ex) {
                   ex.printStackTrace();
               }
}
           else {
            try {
                i++;
                img= Image.createImage("/img/"+i+".jpg");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
           }

        
        
        }
       
        repaint();
    }
    
}
