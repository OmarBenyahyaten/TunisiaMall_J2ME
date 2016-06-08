/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omar;

import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Canvas;


import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.TextBox;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import tnMallMidlet.Login;

/**
 *
 * @author omarblythe
 */
class AvisEnseigne extends Canvas  implements  CommandListener, Runnable{
    Avis[] avisEnseigne;
    int x=0;
    int y=0;
    int pos=0;
    int scrollTop=0;
    int scrollStep=40;
    int trans=0;
    int selectorY=0;
    int selectorI=0;
    int idEnseigne;
            Command cmdRetour = new Command("Retour", Command.EXIT, 0);
                        Command cmdAdd = new Command("Add", Command.EXIT, 0);
    TextBox t = new TextBox("AJOUTER AVIS", null, 256, 0);

boolean testDown = true ;
boolean testUp = true ;
 Command cmdOk = new Command("Ok", Command.EXIT, 0);
  Command cmdValider = new Command("Valider", Command.EXIT, 0);
    Command cmdBack = new Command("Back", Command.EXIT, 0);


     Alert al = new Alert("alerte", "Veuillez connecter svp",null, AlertType.ALARM);


    public AvisEnseigne(int idEnseigne) throws IOException {
       // super("");
       this.idEnseigne=idEnseigne;
          Thread th = new Thread(this);
        th.start();
        run();
       // Midlet.mid.disp.setCurrent(lst);
       x=getWidth();
       y=getHeight()-25;
        addCommand(cmdRetour);
        addCommand(cmdAdd);
                        t.addCommand(cmdBack);
                                t.addCommand(cmdValider);

t.setCommandListener(this);
        setCommandListener(this);

        
       //trans=y;
       
  //     int i=1;
//       stars[i]= Image.createImage("/img/star1.jpg");
       
    }

   

    public void commandAction(Command c, Displayable d) {
if (c==cmdBack){     Login.exam.disp.setCurrent(this);
}
if(c==cmdValider){Login.exam.disp.setCurrent(new AddAvis(t.getString(),idEnseigne));}
if (c== cmdRetour){try {
     Login.exam.disp.setCurrent(new Menu());
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}
if (c==cmdAdd){
     if(Login.exam.id == -1){
Login.exam.disp.setCurrent(al);

     
     }else {
Login.exam.disp.setCurrent(t);}
}

}
    public void run() {
        
        try {
            
            AvisEnseigneHandler avisEnseigneHandler = new AvisEnseigneHandler();
            // get a parser object
            SAXParser SAXparser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            String url="http://127.0.0.1/parsing/getAvisEnseigne.php?enseigne="+idEnseigne;
            HttpConnection hc = (HttpConnection) Connector.open("http://127.0.0.1/parsing/getAvisEnseigne.php?enseigne="+idEnseigne);
            System.out.println(url);
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            SAXparser.parse(dis, avisEnseigneHandler);
            
            // display the result
            avisEnseigne = avisEnseigneHandler.getV();
            System.out.println(avisEnseigne.length);
            
          //  Midlet.mid.disp.setCurrent(lst);
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (SAXException ex) {
            ex.printStackTrace();
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace();
        }
    }

    protected void paint(Graphics g) {
        g.setFont(Font.getFont(Font.FACE_PROPORTIONAL, Font.STYLE_BOLD, Font.SIZE_SMALL));
         g.setColor(238,116,105);
   g.fillRect(0, 0, x, y);
  if (avisEnseigne.length > 0) {
     

                for (int i = 0; i < avisEnseigne.length; i++) {
                    g.setColor(238,116,105);
                                                        g.fillRect(0, y/3*i+trans, x, y/3);
                                                        
                                                        g.setColor(0,0,0);
                                                           g.drawRect(0, y/3*i+trans, x, y/3);
                                                           
                g.drawString(avisEnseigne[i].getAvis(), 10, (y/3*i+trans)+10, 0);
//                g.drawString(enseigne[i].getNom(), 5, (y/3*i+trans)+10, 0);
//                g.drawString("Store N°"+Integer.toString(enseigne[i].getStore()), 10, (y/3*i+trans)+30, 0);
//                g.drawString(stock[i].getCategorie(), 10, (y/3*i+trans)+50, 0);
//                g.drawString(stock[i].getTaille(), 10, (y/3*i+trans)+70, 0);





                    pos+= y/3*i;
                    
                }
                		//g.translate(x, scrollStep);

//                                   g.fillRect(0, y/3*1, x, y/3);
//                                    g.fillRect(0, y/3*2, x, y/3);

g.setColor(255,240,114);
     g.drawRect(0,selectorY, x-1, y/3);

            }
  else {
    g.setColor(238,116,105);
   g.fillRect(0, 0, x, y);
           g.setColor(0,0,0);
   g.drawString("pas d'avis disponible ", 10, 0, 0);
                                                        
  }
    }
    
    protected void keyPressed(int keyCode) {
        int gameAction = getGameAction(keyCode);

        if ((gameAction == UP) && testUp ) {  
            testDown=true ;
            if(selectorY==y/3*2){
            selectorY-=y/3;
            selectorI--;
            } else if (trans >= 0){
            selectorY-=y/3;
            selectorI--;
            testUp=false;
            }
            else{
trans+=y/3;
selectorI -- ;}
        }
        if ((gameAction == DOWN) && testDown  ) {
            testUp=true;
            if (selectorY==0) {selectorY=y/3; selectorI++;}
            else if (y/3*avisEnseigne.length-1+trans <=y/3*4){
            selectorY+=y/3;
            testDown=false ;
            selectorI++;
            }
            else{
                selectorI++;
           trans-=y/3;
        }
           
        }
        
        
              
             
    repaint();
}

}
