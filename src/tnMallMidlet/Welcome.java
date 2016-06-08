/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tnMallMidlet;

import java.io.IOException;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

/**
 *
 * @author omarblythe
 */
class Welcome extends Canvas {
Image i ;
Image m;
int x1;
int x2;
int y;
    public Welcome() throws IOException {
        i=Image.createImage("/img/logo1.png");
        m=Image.createImage("/img/logo2.png");
        x1=-50;
        x2=getWidth();
        y=getHeight();
    }

    protected void paint(Graphics g) {
       
        g.setColor(0,0,0);
        g.fillRect(0, 0, getWidth(), y);
        g.drawImage(i, x1, 100, 0);
        g.drawImage(m, x2, 100, 0);
        x1+=1;
        x2-=1;
    try {
        Thread.sleep(10);
    } catch (InterruptedException ex) {
        ex.printStackTrace();
    }
        if(x1!=75)
        repaint();
        
    }
    
}
