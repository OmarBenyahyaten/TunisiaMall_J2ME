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
class SubmitNoteEnseigne extends Form implements Runnable,CommandListener{
    HttpConnection hc;
    DataInputStream dis;
    StringBuffer sb = new StringBuffer();
    int ch;
int idEnseigne ;
int star ;
int idUser=Login.exam.id;
    Alert al = new Alert("alerte", "note enregistrer",null, AlertType.ALARM);
        Alert ale = new Alert("alerte", "erreur",null, AlertType.ALARM);
                     Command cmdOk = new Command("Ok", Command.EXIT, 0);


    public SubmitNoteEnseigne(int idEnseigne,int star) {
        super("");
        this.idEnseigne=idEnseigne;
        this.star=star;
        ale.addCommand(cmdOk);
        al.addCommand(cmdOk);
            setCommandListener(this);

         Thread th = new Thread(this);
            th.start();
    }

    
    public void run() {
        
        try {
                                System.out.println("idArticle = "+idEnseigne);
String url="http://127.0.0.1/parsing/insertNoteEnseigne.php?note=" +star+ "&user=" +idUser+"&enseigne="+idEnseigne;
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
        Login.exam.disp.setCurrent(new NoteArticle());
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}
    }
    
    
}
