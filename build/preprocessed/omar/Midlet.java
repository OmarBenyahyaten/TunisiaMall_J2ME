package omar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.List;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
import omar.GoogleMapsPathCanvas;
import omar.GoogleMapsZoomCanvas;

public class Midlet extends MIDlet implements CommandListener {
  
    public Display disp;
    List lst = new List("Examples", List.IMPLICIT);
public Midlet()
{
        this.disp = Display.getDisplay(this);
    
}
    public void startApp() {
        
        lst.append("Zooming maps", null);
        lst.append("Using Paths", null);
        
        lst.setCommandListener(this);
        disp.setCurrent(lst);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    public void commandAction(Command c, Displayable d) {
        if(c==List.SELECT_COMMAND)
        {
            switch(lst.getSelectedIndex())
			{
			case 0:
				
				break;
			case 1:
                        {
                            Retriever12 r=new Retriever12();
        r.start();
        System.out.println(r.a);
        System.out.println(r.b);
				disp.setCurrent(new GoogleMapsPathCanvas(this, d,r.a,r.b));
				break;}
			
			}
        }
    }
}
