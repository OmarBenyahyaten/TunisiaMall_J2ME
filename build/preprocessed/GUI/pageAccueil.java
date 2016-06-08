/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.microedition.lcdui.Form;
import tnMallMidlet.Login;

/**
 *
 * @author timoumi med hedi
 */
public class pageAccueil extends Form {

    public pageAccueil(String title) {
        super(title);
        System.out.println(Login.id);
        System.out.println(Login.username);
    }

    
   
}
