/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;
import entities.User;
import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author damine
 */
public class UserHandler extends DefaultHandler {

    private Vector matchVector;

    public UserHandler() {
        matchVector = new Vector();
    }

    public User[] getUser() {
        User[] personTab = new User[matchVector.size()];
        //System.out.println(matchVector.firstElement().getClass());
        matchVector.copyInto(personTab);
        return personTab;
    }

    String selectedBalise = "";
    User seclected;

    public void startElement(String string, String string1, String qName, Attributes atrbts) throws SAXException {
       
        if (qName.equals("User")) {
            seclected = new User();
        } else if (qName.equals("id")) {
            selectedBalise = "id";
        } else if (qName.equals("tel")) {
            selectedBalise = "tel";
        } else if (qName.equals("username")) {
            selectedBalise = "username";
        } else if (qName.equals("pass")) {
            selectedBalise = "pass";
        }
    }

    public void endElement(String string, String string1, String qName) throws SAXException {
        if (qName.equals("User")) {

            matchVector.addElement(seclected);
            seclected = null;
        } else if (qName.equals("id")) {
            selectedBalise = "";
        } else if (qName.equals("tel")) {
            selectedBalise = "";
        } else if (qName.equals("username")) {
            selectedBalise = "";
        } else if (qName.equals("pass")) {
            selectedBalise = "";
        }
        
    }

    public void characters(char[] chars, int i, int i1) throws SAXException {
        if (seclected!= null) {
            if (selectedBalise.equals("id")) {
                seclected.setId(Integer.parseInt(new String(chars, i, i1)));
                System.out.println(new String(chars, i, i1));
            }
            if (selectedBalise.equals("tel")) {
                seclected.setTel(new String(chars, i, i1));
                System.out.println(new String(chars, i, i1));
            }
            if (selectedBalise.equals("username")) {
                seclected.setUsername(new String(chars, i, i1));
                System.out.println(new String(chars, i, i1));
            }
            if (selectedBalise.equals("pass")) {
                seclected.setPassword(new String(chars, i, i1));
                System.out.println(new String(chars, i, i1));
            }
        }
    }

    

}
