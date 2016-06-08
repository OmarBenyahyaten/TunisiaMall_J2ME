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
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import tnMallMidlet.Login;

/**
 *
 * @author omarblythe
 */
class NoteEnseigne extends Canvas  implements  CommandListener, Runnable{
    Enseigne[] enseigne;
    int x=0;
    int y=0;
    int pos=0;
    int scrollTop=0;
    int scrollStep=40;
    int trans=0;
    int selectorY=0;
    int selectorI=0;
    Image[] stars= {Image.createImage("/img/star1.jpg"),Image.createImage("/img/star2.jpg"),Image.createImage("/img/star3.jpg")
    ,Image.createImage("/img/star4.jpg"),Image.createImage("/img/star5.jpg")}  ;
            Command cmdRetour = new Command("Retour", Command.EXIT, 0);
                        Command cmdNoter = new Command("Noter", Command.EXIT, 0);
boolean testDown = true ;
boolean testUp = true ;
 Command cmdOk = new Command("Ok", Command.EXIT, 0);
     Alert al = new Alert("alerte", "Veuillez connecter svp",null, AlertType.ALARM);


    public NoteEnseigne() throws IOException {
       // super("");
          Thread th = new Thread(this);
        th.start();
        run();
       // Midlet.mid.disp.setCurrent(lst);
       x=getWidth();
       y=getHeight()-25;
        addCommand(cmdRetour);
        addCommand(cmdNoter);
        setCommandListener(this);
       //trans=y;
       
  //     int i=1;
//       stars[i]= Image.createImage("/img/star1.jpg");
       
    }

   

    public void commandAction(Command c, Displayable d) {

if (c== cmdRetour){try {
     Login.exam.disp.setCurrent(new Menu());
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}
if (c== cmdNoter) {
if (Login.exam.id==-1){
Login.exam.disp.setCurrent(al);

}
else {
                    //System.out.println("idArticle = "+stock[selectorI].getId());
SubmitNoteEnseigne N = new SubmitNoteEnseigne(enseigne[selectorI].getIdEnseigne(),enseigne[selectorI].getStar()+1);

       
}

}
if(c==cmdOk){
Login.exam.disp.setCurrent(this);

}}
    public void run() {
        
        try {
            
            EnseigneHandler enseigneHandler = new EnseigneHandler();
            // get a parser object
            SAXParser SAXparser = SAXParserFactory.newInstance().newSAXParser();
            // get an InputStream from somewhere (could be HttpConnection, for example)
            HttpConnection hc = (HttpConnection) Connector.open("http://127.0.0.1/parsing/getEnseigne.php");
            DataInputStream dis = new DataInputStream(hc.openDataInputStream());
            SAXparser.parse(dis, enseigneHandler);
            
            // display the result
            enseigne = enseigneHandler.getV();
          
            
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
  if (enseigne.length > 0) {
     

                for (int i = 0; i < enseigne.length; i++) {
                    g.setColor(238,116,105);
                                                        g.fillRect(0, y/3*i+trans, x, y/3);
                                                        
                                                        g.setColor(0,0,0);
                                                           g.drawRect(0, y/3*i+trans, x, y/3);
                                                           
                g.drawString(enseigne[i].getNom(), (x)-enseigne[i].getNom().length()*8, (y/3*i+trans)+10, 0);
                g.drawString(enseigne[i].getNom(), 5, (y/3*i+trans)+10, 0);
                g.drawString("Store N°"+Integer.toString(enseigne[i].getStore()), 10, (y/3*i+trans)+30, 0);
//                g.drawString(stock[i].getCategorie(), 10, (y/3*i+trans)+50, 0);
//                g.drawString(stock[i].getTaille(), 10, (y/3*i+trans)+70, 0);
                g.drawImage(stars[enseigne[i].getStar()], 154, (y/3*i+trans)+77, 0);





                    pos+= y/3*i;
                    
                }
                		//g.translate(x, scrollStep);

//                                   g.fillRect(0, y/3*1, x, y/3);
//                                    g.fillRect(0, y/3*2, x, y/3);

g.setColor(255,240,114);
     g.drawRect(0,selectorY, x-1, y/3);

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
            else if (y/3*enseigne.length-1+trans <=y/3*4){
            selectorY+=y/3;
            testDown=false ;
            selectorI++;
            }
            else{
                selectorI++;
           trans-=y/3;
        }
           
        }
        
         if(gameAction==RIGHT){
               if (enseigne[selectorI].getStar()<4){
                System.out.println(enseigne[selectorI].getStar()+1);
            enseigne[selectorI].setStar( enseigne[selectorI].getStar()+1);}
            }
              if(gameAction==LEFT){
                  if (enseigne[selectorI].getStar()>0){
            enseigne[selectorI].setStar( enseigne[selectorI].getStar()-1);}
            }
              
              if (gameAction == FIRE){
            try {
                Login.exam.disp.setCurrent(new AvisEnseigne(enseigne[selectorI].getIdEnseigne()));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
              }
    repaint();
}

}
