/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omar;

import java.io.IOException;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import tnMallMidlet.Login;

/**
 *
 * @author omarblythe
 */
class Visite extends Canvas implements CommandListener{
Image image ;
int x=0;
int y=0;
        Command cmdRetour = new Command("Retour", Command.EXIT, 0);

    public Visite() throws IOException {
       image=Image.createImage("/img/vv.jpg");
       x=0;
       y=0;
        addCommand(cmdRetour);
        setCommandListener(this);
    }

    protected void paint(Graphics g) {
        g.drawImage(image, x, y, 0);
    }

    public void commandAction(Command c, Displayable d) {
if(c==cmdRetour){
    try {
        Login.exam.disp.setCurrent(new Menu());
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}
    }
     protected void keyPressed(int keyCode) {
        int gameAction = getGameAction(keyCode);

        if ((gameAction == UP && y<0) ) {  
           y+=50;
            }
            
        
        if (gameAction == DOWN && y+getHeight()<image.getHeight()) {
           y-=50;
        }
           
        if(gameAction == LEFT && x<0){ x+=50; }
        if (gameAction == RIGHT){ x-=50; }
        
        
        
              
             
    repaint();
}
}

