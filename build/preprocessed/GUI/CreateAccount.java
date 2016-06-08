/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Item;
import javax.microedition.lcdui.ItemCommandListener;
import javax.microedition.lcdui.TextField;
import javax.microedition.lcdui.Ticker;
import tnMallMidlet.Login;
import utilities.ProcessAdd;
import utilities.ProcessLogin;
import java.*;
import utilities.ProcessModifier;
import utilities.recupUser;

/**
 *
 * @author timoumi med hedi
 */
public class CreateAccount extends Form implements CommandListener {

    Ticker t = new Ticker("creer un compte");
    TextField tfNom = new TextField("pseudo", null, 20, TextField.ANY);
    TextField tbPass = new TextField("PIN", "", 20, TextField.ANY | TextField.PASSWORD);
    TextField tbPassCon = new TextField("PIN confirm", "", 20, TextField.ANY | TextField.PASSWORD);
    TextField tfmail = new TextField("mail", null, 30, TextField.ANY);
    TextField tel = new TextField("tel", null, 20, TextField.NUMERIC);
    Command cmValider = new Command("connect", Command.SCREEN, Command.OK);
    int modifier=0;

    public CreateAccount() {
        
        super("create account");
        append(tfNom);
        append(tbPass);
        append(tel);
        append(tfmail);
        addCommand(cmValider);
        setTicker(t);
        setCommandListener(this);

    }
     public CreateAccount(String username,String mail,String tele) {
        super("create account");
        tfNom.setString(username);
        append(tfNom);
        append(tbPass);
        tel.setString(tele);
        append(tel);
        tfmail.setString(mail);
        append(tfmail);
        addCommand(cmValider);
        setTicker(t);
        setCommandListener(this);

    }
     
 public CreateAccount(String username) 
 {
     super("modifier account");
     modifier=1;
     System.out.println(Login.exam.id);
      if (Login.exam.id!=-1)
      {
          recupUser procc = new recupUser(this, username);
          procc.start();
      }
 }
 
    public void commandAction(Command c, Displayable d) {
        if (c == cmValider) {
if(Login.modifier==1)
{
    
   ProcessModifier f=new ProcessModifier(this, tfNom.getString(), tbPass.getString(), tfmail.getString(), tel.getString(),Login.id);
     f.start();
}else
{      ProcessAdd process = new ProcessAdd(this, tfNom.getString(), tbPass.getString(), tfmail.getString(), tel.getString());
            process.start();

        }
    }

}
}