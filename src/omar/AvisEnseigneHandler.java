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
public class AvisEnseigneHandler extends DefaultHandler {

    Vector v = new Vector();
    Avis avis;
    String selectedBalise = "";

    public Avis[] getV() {
        Avis[] admins = new Avis[v.size()];
        v.copyInto(admins);
        return admins;
    }
    
    

    public void startElement(String string, String string1, String string2, Attributes atrbts) throws SAXException {
        if (string2.equals("review")) {
            avis = new Avis();
        }
        else if (string2.equals("user")) {
            selectedBalise = string2;
        }else if (string2.equals("enseigne")) {
            selectedBalise = string2;
        } else if (string2.equals("avis")) {
            selectedBalise = string2;
        } }

    public void endElement(String string, String string1, String string2) throws SAXException {
     if (string2.equals("review")) {
            v.addElement(avis);
        }else if (string2.equals("user")) {
            selectedBalise = string2;
        } else if (string2.equals("enseigne")) {
            selectedBalise = "";
        } else if (string2.equals("avis")) {
            selectedBalise = "";
        }
    }

    public void characters(char[] chars, int i, int i1) throws SAXException {
         if (avis != null) {
            if (selectedBalise.equals("user")) {
                avis.setUser(Integer.parseInt(new String(chars, i, i1)));
            }else if (selectedBalise.equals("enseigne")) {
                avis.setEnseigne(Integer.parseInt(new String(chars, i, i1)));
            } else if (selectedBalise.equals("avis")) {
                avis.setAvis(new String(chars, i, i1));
            }
        }
    }

}
