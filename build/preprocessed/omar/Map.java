/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omar;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.List;
import tnMallMidlet.Login;

/**
 *
 * @author omarblythe
 */
class Map extends Form implements CommandListener{
List lst = new List("Examples", List.IMPLICIT);
    public Map() {
        super("");
         lst.append("Zooming maps", null);
        lst.append("Using Paths", null);
        
        lst.setCommandListener(this);
        Login.exam.disp.setCurrent(lst);
        
    }

    public void commandAction(Command c, Displayable d) {
 if(c==List.SELECT_COMMAND)
        {
            switch(lst.getSelectedIndex())
			{
			case 0:
				Login.exam.disp.setCurrent(new GoogleMapsZoomCanvas(Login.exam, d));
				break;
			case 1:
                        {
                            Retriever12 r=new Retriever12();
        r.start();
        System.out.println(r.a);
        System.out.println(r.b);
				Login.exam.disp.setCurrent(new GoogleMapsPathCanvas(Login.exam, d,r.a,r.b));
				break;}
			
			}
        }    }
    
}
