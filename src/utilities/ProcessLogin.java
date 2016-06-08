    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import tnMallMidlet.Login;
import GUI.loginGui;
import GUI.pageAccueil;
import java.io.IOException;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Command;
import omar.Menu;

/**
 *
 * @author timoumi med hedi
 */
public class ProcessLogin implements Runnable {

    private loginGui MIDlet;
    private String login;
    private String pass;

    Command oui = new Command("oui", Command.ITEM, 0);
    Command non = new Command("non", Command.ITEM, 0);

    public ProcessLogin(loginGui MIDlet, String login, String pass) {
        this.login = login;
        this.pass = pass;
        this.MIDlet = MIDlet;
    }

    public void run() {
        try {
            transmit();
        } catch (Exception error) {
            System.err.println(error.toString());
        }
    }

    public void start() {

        Thread thread = new Thread(this);
        try {
            thread.start();
        } catch (Exception error) {
        }
    }

    private void transmit() throws IOException, InterruptedException {
        PostQuery q = new PostQuery();
        try {
            System.out.println("a");
            String result = q.postMethod("http://127.0.0.1/parsing/login.php", login, pass);
            System.out.println("b");
            if (!(result.equals("failed"))) {
                Login.id = Integer.parseInt(result.substring(0, result.indexOf('|')));
                Login.username = result.substring(result.indexOf('|') + 1, result.length());
                Login.modifier=1;
                Login.exam.disp.setCurrent(new Menu());
            } else {
                Alert a = new Alert("invalid parameters", "sorry , check your informations", null, AlertType.ALARM);

                a.setTimeout(1000);
                Login.exam.disp.setCurrent(a);
                Thread.sleep(1000);
                Login.exam.disp.setCurrent(new loginGui("erreur", login));
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
