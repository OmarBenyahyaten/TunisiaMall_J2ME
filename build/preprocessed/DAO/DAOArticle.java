/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entities.Article;
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
public class DAOArticle {
    
/**
 *
 * @author mounir
 */
    Article[] articles;
    
    
       public Article[] select(String p) throws IOException, ParserConfigurationException, SAXException{
           String url;
if(p==null)
{
    url="http://localhost/parsing/rechercheArticle2.php";
}else
{ url="http://localhost/parsing/rechercheArticle.php?nomarticle="+p;}
        handlerArticle articleHandler = new handlerArticle();
        // get a parser object
        SAXParser SAXparser = SAXParserFactory.newInstance().newSAXParser();
        // get an InputStream from somewhere (could be HttpConnection, for example)
        HttpConnection hc = (HttpConnection) Connector.open(url);
        DataInputStream dis = new DataInputStream(hc.openDataInputStream());
        SAXparser.parse(dis, articleHandler);
            Article[] articles;
                       articles = articleHandler.getArticle();
        System.out.println("nombre article est                      "+articles.length);
             return articles;
   }
    
}


