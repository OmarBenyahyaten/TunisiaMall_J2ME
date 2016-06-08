/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import GUI.CreateAccount;
import tnMallMidlet.Login;
import GUI.loginGui;
import GUI.pageAccueil;
import entities.User;
import handler.UserHandler;
import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Command;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author timoumi med hedi
 */
public class ProcessModifier implements Runnable {

    private CreateAccount MIDlet;
    private String login;
    String pass; 
    String mail;
    String tel;
    int id;

    Command oui = new Command("oui", Command.ITEM, 0);
    Command non = new Command("non", Command.ITEM, 0);

    public ProcessModifier(CreateAccount MIDlet, String login,String pass, String mail,String tel,int id) {
        this.login = login;
        this.mail=mail;
        this.pass=pass;
        this.tel=tel;
        this.id=id;
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

    private void transmit() throws IOException, InterruptedException, ParserConfigurationException, SAXException {
PostQuery q = new PostQuery();
        try {
            String result = q.postMethodAdd("http://127.0.0.1/parsing/modifyUser.php",login,pass,mail,tel,Login.id);
            System.out.println(result);
            if ((result.equals("ok"))) {
                
                 Login.exam.disp.setCurrent(new loginGui("erreur",login));
            } else {
                String message="";
                if(result.equals("mail"))
                {
                    message +="mail incorrecte";
                }
                 if(result.equals("mail|username"))
                {
                    message +="mail et username incorrectes";
                }
                  if(result.equals("|username"))
                {
                    message +="username incorrecte";
                }
                  if(result.equals("|pass"))
                {
                    message +="pass incorrecte";
                }
                  if(result.equals("mail|pass"))
                {
                    message +="pass et mail incorrecte";
                }
                  if(result.equals("|username|pass"))
                {
                    message +="username et pass incorrectes";
                }
                  if(result.equals("mail|username|pass"))
                {
                    message +="username , pass et mail sont incorrectes";
                }
                
                Alert a = new Alert("invalid parameters", message, null, AlertType.ALARM);

                a.setTimeout(1000);
                Login.exam.disp.setCurrent(a);
                Thread.sleep(1000);
                Login.exam.disp.setCurrent(new CreateAccount(login,mail,tel));
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    }



