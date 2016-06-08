/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Item;
import javax.microedition.lcdui.ItemCommandListener;
import javax.microedition.lcdui.StringItem;
import javax.microedition.lcdui.TextBox;
import javax.microedition.lcdui.TextField;
import javax.microedition.lcdui.Ticker;
import omar.Menu;
import tnMallMidlet.Login;
import org.w3c.dom.ProcessingInstruction;
import utilities.*;

/**
 *
 * @author timoumi med hedi
 */
public class loginGui extends Form implements CommandListener {

    Ticker t = new Ticker("bienvenue");
    TextField tfNom = new TextField("pseudo", null, 20, TextField.ANY);
    TextField tbPass = new TextField("PIN", "", 20, TextField.ANY | TextField.PASSWORD);
    Command cmValider = new Command("connect", Command.SCREEN, 0);
    Command cmRestaurer = new Command("restaurer", Command.SCREEN, 0);
    Command cmSortir = new Command("Sortir", Command.SCREEN, 0);
    Command prospectoCommand = new Command("create", Command.EXIT, 1);
    Command prospectoCommand1 = new Command("restaure", Command.EXIT, 1);
    String erreur;
    StringItem messageItem2 = new StringItem("", "", Item.HYPERLINK);
    StringItem messageItem = new StringItem("", "", Item.HYPERLINK);

    public loginGui() throws IOException {
        super("login");
        append(tfNom);
        append(tbPass);
        setTicker(t);
        addCommand(cmValider);
        addCommand(cmSortir);
        setCommandListener(this);
        messageItem2.setText("create an account");
        messageItem2.setDefaultCommand(prospectoCommand);
        //messageItem2.setLayout(100);
        append(messageItem2);
        messageItem2.setItemCommandListener(new ItemCommandListener() {
            public void commandAction(Command c, Item item) {
                if (c == prospectoCommand) {
                    Login.exam.disp.setCurrent(new CreateAccount());
                }
            }
        });
    }

    public loginGui(String erreur, String username) throws IOException {
        super("login");

        append(tfNom);
        tfNom.setString(username);
        append(tbPass);
        setTicker(t);
        addCommand(cmValider);
        addCommand(cmSortir);
        this.erreur = erreur;
        System.out.println(erreur);
        setCommandListener(this);
        messageItem2.setText("create an account");
        messageItem2.setDefaultCommand(prospectoCommand);
        
        append(messageItem2);
        messageItem2.setLayout(javax.microedition.lcdui.Item.LAYOUT_NEWLINE_AFTER);
        messageItem2.setItemCommandListener(new ItemCommandListener() {
            public void commandAction(Command c, Item item) {
                if (c == prospectoCommand) {
                   Login.exam.disp.setCurrent(new CreateAccount());
                }
            }
        });
        messageItem.setText("restaure account");
        messageItem.setDefaultCommand(prospectoCommand1);
        append(messageItem);
        messageItem.setItemCommandListener(new ItemCommandListener() {
            public void commandAction(Command c, Item item) {
                if (c == prospectoCommand1) {
                    try {
                        Login.exam.disp.setCurrent(new loginGui(1));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

    }
    public loginGui(String ch) throws IOException
    {
       this();
       tfNom.setString(ch);
       
    }

    public loginGui(int i) throws IOException {
        super("login");
        append(tfNom);
        t.setString("restaurer mot de passe");
        setTicker(t);
        addCommand(cmRestaurer);
        addCommand(cmSortir);
        setCommandListener(this);

    }

    public void commandAction(Command c, Displayable d) {
        if (c == cmSortir) {
            try {
                Login.exam.disp.setCurrent(new Menu());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
           
        }
        if (c == cmValider) {

            ProcessLogin process = new ProcessLogin(this, tfNom.getString(), tbPass.getString());
            process.start();

        }
        if (c == cmRestaurer) {

             ProcessUpdate process = new ProcessUpdate(this, tfNom.getString());
            process.start();
        }
    }

}
