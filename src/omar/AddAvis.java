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
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import tnMallMidlet.Login;

/**
 *
 * @author omarblythe
 */
class AddAvis extends Form implements Runnable,CommandListener{
    HttpConnection hc;
    DataInputStream dis;
    StringBuffer sb = new StringBuffer();
    int ch;
int idEnseigne ;
int idUser=Login.exam.id;
    Alert al = new Alert("alerte", "Avis enregistrer",null, AlertType.ALARM);
        Alert ale = new Alert("alerte", "erreur",null, AlertType.ALARM);
                     Command cmdOk = new Command("Ok", Command.EXIT, 0);

String avis ;
    public AddAvis(String avis,int idEnseigne) {
        super("");
        this.avis=avis;
        this.idEnseigne=idEnseigne;
        ale.addCommand(cmdOk);
        al.addCommand(cmdOk);
            al.setCommandListener(this);
            ale.setCommandListener(this);

         Thread th = new Thread(this);
            th.start();
    }

    
    public void run() {
        
        try {
String url="http://127.0.0.1/parsing/addAvisEnseigne.php?user=" +idUser+"&enseigne="+idEnseigne+"&avis="+avis;
            System.out.println(url);
            hc = (HttpConnection) Connector.open(url);
            dis = new DataInputStream(hc.openDataInputStream());
            while ((ch = dis.read()) != -1) {
                sb.append((char) ch);
            }
            if ("successfully added".equalsIgnoreCase(sb.toString().trim())) {
        Login.exam.disp.setCurrent(al);
            } else {
                       Login.exam.disp.setCurrent(ale);

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        
    }
    }

    public void commandAction(Command c, Displayable d) {
if (c==cmdOk){
    try {
        System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq"+idEnseigne);
        Login.exam.disp.setCurrent(new AvisEnseigne(idEnseigne));
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}
    }
    
    
}
