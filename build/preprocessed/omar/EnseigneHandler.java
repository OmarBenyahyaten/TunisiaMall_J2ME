/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omar;

import java.util.Vector;
import javax.microedition.lcdui.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author omar
 */
public class EnseigneHandler extends DefaultHandler {

    Vector v = new Vector();
    Enseigne enseigne;
    String selectedBalise = "";

    public Enseigne[] getV() {
        Enseigne[] admins = new Enseigne[v.size()];
        v.copyInto(admins);
        return admins;
    }
    
    

    public void startElement(String string, String string1, String string2, Attributes atrbts) throws SAXException {
        if (string2.equals("enseigne")) {
            enseigne = new Enseigne();
        } else if (string2.equals("idEnseigne")) {
            selectedBalise = string2;
        } else if (string2.equals("nom")) {
            selectedBalise = string2;
        } else if (string2.equals("store")) {
            selectedBalise = string2;
        } else if (string2.equals("srcLogo")) {
            selectedBalise = string2;
        }
    }

    public void endElement(String string, String string1, String string2) throws SAXException {
     if (string2.equals("enseigne")) {
            v.addElement(enseigne);
        } else if (string2.equals("idEnseigne")) {
            selectedBalise = "";
        } else if (string2.equals("nom")) {
            selectedBalise = "";
        } else if (string2.equals("store")) {
            selectedBalise = "";
        } else if (string2.equals("srcLogo")) {
            selectedBalise = "";
        } 
    }

    public void characters(char[] chars, int i, int i1) throws SAXException {
         if (enseigne != null) {
            if (selectedBalise.equals("idEnseigne")) {
                enseigne.setIdEnseigne(Integer.parseInt(new String(chars, i, i1)));
            } else if (selectedBalise.equals("nom")) {
                enseigne.setNom(new String(chars, i, i1));
            }else if (selectedBalise.equals("store")) {
                enseigne.setStore(Integer.parseInt(new String(chars, i, i1)));
            }else if (selectedBalise.equals("srcLogo")) {
                enseigne.setSrcLogo(new String(chars, i, i1));
            }
        }
    }

}
