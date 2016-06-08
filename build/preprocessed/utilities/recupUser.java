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
public class recupUser implements Runnable {

    private CreateAccount MIDlet;
    private String login;

    Command oui = new Command("oui", Command.ITEM, 0);
    Command non = new Command("non", Command.ITEM, 0);

    public recupUser(CreateAccount MIDlet, String login) {
        this.login = login;

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

        UserHandler userHandler = new UserHandler();
        // get a parser object
        SAXParser SAXparser = SAXParserFactory.newInstance().newSAXParser();
        // get an InputStream from somewhere (could be HttpConnection, for example)
        HttpConnection hc = (HttpConnection) Connector.open("http://127.0.0.1/parsing/recup.php?name="+login);
        DataInputStream dis = new DataInputStream(hc.openDataInputStream());
        SAXparser.parse(dis, userHandler);
        // display the result
        User[] u = userHandler.getUser();
        
        
        
            
                Login.exam.disp.setCurrent(new CreateAccount(u[0].getUsername(),u[0].getPassword(),u[0].getTel()));
                
            

    }

}

