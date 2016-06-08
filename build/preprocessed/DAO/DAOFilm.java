/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Film;
import handler.FilmHandler;
import handler.handlerArticle;
import java.io.DataInputStream;
import java.io.IOException;
import javax.microedition.io.Connector;
import javax.microedition.io.HttpConnection;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author dhia
 */
public class DAOFilm {
    

    Film[] films;
    
    
       public Film[] select(String p) throws IOException, ParserConfigurationException, SAXException{
           String url;
if(p==null)
{
    url="http://localhost/parsing/rechercheFilm.php";
}else
{ url="http://localhost/parsing/rechercheFilm2.php?nomfilm="+p;}
       FilmHandler filmHandler = new FilmHandler();
        // get a parser object
        SAXParser SAXparser = SAXParserFactory.newInstance().newSAXParser();
        // get an InputStream from somewhere (could be HttpConnection, for example)
        HttpConnection hc = (HttpConnection) Connector.open(url);
        DataInputStream dis = new DataInputStream(hc.openDataInputStream());
        SAXparser.parse(dis, filmHandler);
            Film[] films;
                       films = filmHandler.getFilm();
        System.out.println("nombre article est                      "+films.length);
           for (int i = 0; i < films.length; i++) {
               System.out.println(films[i]);
               
           }
             return films;
   }
    
}


