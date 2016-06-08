/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omar;

import handler.handlerArticle;
import omar.*;
import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import tnMallMidlet.Login;

/**
 *
 * @author omarblythe
 */
class Film extends Canvas implements CommandListener, Runnable {

    String text = "";
    String keyText = "";
    List lst = new List("stock", List.IMPLICIT);
    entities.Film[] films;
    int x = 0;
    int y = 0;
    int pos = 0;
    int scrollTop = 0;
    int scrollStep = 40;
    int trans = 0;
    int selectorY = 0;
    int selectorI = 0;
    DAO.DAOFilm dao = new DAO.DAOFilm();

    Command cmdRetour = new Command("Retour", Command.EXIT, 0);
    Command cmdNoter = new Command("seance", Command.EXIT, 0);
    Command cmdOk = new Command("Ok", Command.EXIT, 0);

    boolean testDown = true;
    boolean testUp = true;
    Alert al = new Alert("alerte", "Veuillez connecter svp", null, AlertType.ALARM);

    public Film() throws IOException, ParserConfigurationException, SAXException {
        // super("");
        System.out.println("canvas");
        Thread th = new Thread(this);
        th.start();
        run();
        // Midlet.mid.disp.setCurrent(lst);
        x = getWidth();
        y = getHeight() - 25;
        addCommand(cmdRetour);
        addCommand(cmdNoter);
        setCommandListener(this);
        al.addCommand(cmdOk);
        films = dao.select(null);

    }

    public void commandAction(Command c, Displayable d) {

        if (c == cmdRetour) {
            try {
                Login.exam.disp.setCurrent(new Menu());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        if (c == cmdNoter) {
                    System.out.println();
                    Login.exam.disp.setCurrent(new Seance(films[selectorI]));

        }
        if (c == cmdOk) {
            Login.exam.disp.setCurrent(this);

        }
    }

    public void run() {

        lst = new List("Stock", List.IMPLICIT);
        lst.setCommandListener(this);

        // display the result
    }

    protected void paint(Graphics g) {
    g.setColor(255, 255, 255);
    g.fillRect(0, 0, getWidth(), getHeight());

    
       if (films.length > 0) {
            for (int i = 0; i < films.length; i++) {
              //  System.out.println("canvas" + i + articles[i].getNomArticle());
                g.setColor(238, 116, 105);
                g.fillRect(0, y / 3 * i + trans, x, y / 3);
                g.setColor(0, 0, 0);
                g.drawRect(0, y / 3 * i + trans, x, y / 3);
                g.drawString(films[i].getTitre(), (x) - films[i].getTitre().length() * 8, (y / 3 * i + trans) + 10, 0);
                //       g.drawString(articles[i].getNomEnseigne(), 5, (y / 3 * i + trans) + 10, 0);
                g.drawString((films[i].getGenre()), 10, (y / 3 * i + trans) + 30, 0);
                g.drawString(films[i].getNoteIm(), 10, (y / 3 * i + trans) + 50, 0);
                //  g.drawString(stock[i].getTaille(), 10, (y/3*i+trans)+70, 0);
                //  g.drawImage(stars[stock[i].getStar()], 154, (y/3*i+trans)+77, 0);
                //  g.drawImage(like[stock[i].getLike()], 207, (y/3*i+trans)+43, 0);
                pos += y / 3 * i;
            }
            g.setColor(255, 240, 114);
            g.drawRect(0, selectorY, x - 1, y / 3);
        }
      g.setColor(0, 0, 0);

      g.drawString(text, getWidth()/2, 5, Graphics.TOP | Graphics.HCENTER);

    }

    protected void keyPressed(int keyCode) {
        int gameAction = getGameAction(keyCode);
        switch (getGameAction(keyCode)) {
            // Place logic of each action inside the case
            case FIRE:
                System.out.println("entreee");
                System.out.println(text);
                 {
                     if(text==""){text=null;}
            try {
                films = dao.select(text);
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ParserConfigurationException ex) {
                ex.printStackTrace();
            } catch (SAXException ex) {
                ex.printStackTrace();
            }
                }

            case UP:
            case DOWN:
            case LEFT:
                
            case RIGHT:
            case GAME_A:
            case GAME_B:
            case GAME_C:
            case GAME_D:
            default:
                // Print the text of the game action
                keyText = getKeyName(keyCode);
                if (keyCode == -8) {
                    text = "";
                }
                if (keyCode >96 && keyCode<123) {
                    text += keyText;
                     keyText="";
                    System.out.println(keyText);
                }
                                   
                                       System.out.println("text     "+text);
                                               
        }

        if ((gameAction == UP) && testUp) {
            testDown = true;
            if (selectorY == y / 3 * 2) {
                selectorY -= y / 3;
                selectorI--;
            } else if (trans >= 0) {
                selectorY -= y / 3;
                selectorI--;
                testUp = false;
            } else {
                trans += y / 3;
                selectorI--;
            }
        }
        if ((gameAction == DOWN) && testDown) {
            testUp = true;
            if (selectorY == 0) {
                selectorY = y / 3;
                selectorI++;
            } else if (y / 3 * films.length - 1 + trans <= y / 3 * 4) {
                selectorY += y / 3;
                testDown = false;
                selectorI++;
            } else {
                selectorI++;
                trans -= y / 3;
            }
        }
        repaint();
    }

}
