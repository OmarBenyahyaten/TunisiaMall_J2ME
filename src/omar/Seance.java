/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omar;

import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;
import entities.Film;
import java.io.IOException;
import javax.microedition.lcdui.List;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import tnMallMidlet.Login;

/**
 *
 * @author dhia
 */
public class Seance extends Canvas implements CommandListener, Runnable {
    List lst = new List("stock", List.IMPLICIT);

    entities.Film film = new Film();
    Command cmdRetour = new Command("Retour", Command.EXIT, 0);

    public Seance(Film x) {
        film=x;
        addCommand(cmdRetour);
        setCommandListener(this);


    }

    protected void paint(Graphics g) {
        g.setColor(255, 255, 255);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(0, 0, 0);
        g.drawString((film.getTitre()), 10,10, 0);
        g.drawString(film.getNomJour() + " a " + film.getHeureSeance(), 10, 30, 0);
        g.drawString("genre :"+film.getGenre(), 10, 50, 0);
        g.drawString("realisateur: "+film.getRealisateur(), 10, 70, 0);
        g.drawString("nationalite :"+film.getNationalite(), 10,90, 0);
        g.drawString("synopsis"+film.getSynopsis(), 10,110, 0);



                   



    }

    public void commandAction(Command c, Displayable d) {
        if (c == cmdRetour) {
            try {
                try {
                    Login.exam.disp.setCurrent(new omar.Film());
                    System.out.println("film");
                } catch (ParserConfigurationException ex) {
                    ex.printStackTrace();
                } catch (SAXException ex) {
                    ex.printStackTrace();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void run() {
            lst = new List("Stock", List.IMPLICIT);
        lst.setCommandListener(this);
    }

}
