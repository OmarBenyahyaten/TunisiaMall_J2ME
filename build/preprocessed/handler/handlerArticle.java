/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import entities.Article;
import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author damine
 */
public class handlerArticle extends DefaultHandler {

    private Vector ArticleVector;

    public handlerArticle() {
        ArticleVector = new Vector();
    }

    public Article[] getArticle() {
        Article[] personTab = new Article[ArticleVector.size()];
      //  System.out.println(ArticleVector.firstElement().toString());
        ArticleVector.copyInto(personTab);
        return personTab;
    }

    String selectedBalise = "";
    Article seclected;

    public void startElement(String string, String string1, String qName, Attributes atrbts) throws SAXException {

        if (qName.equals("article")) {
            seclected = new Article();
        } else if (qName.equals("idArticle")) {
            selectedBalise = "idArticle";
        } else if (qName.equals("nomArticle")) {
            selectedBalise = "nomArticle";
        } else if (qName.equals("prixVenteDetail")) {
            selectedBalise = "prixVenteDetail";
        } else if (qName.equals("quantite")) {
            selectedBalise = "quantite";
        } else if (qName.equals("imageF")) {
            selectedBalise = "imageF";
        } else if (qName.equals("enseigne")) {
            selectedBalise = "enseigne";
        }
    }

    public void endElement(String string, String string1, String qName) throws SAXException {
        if (qName.equals("article")) {

            ArticleVector.addElement(seclected);
            seclected = null;
        } else if (qName.equals("idArticle")) {
            selectedBalise = "";
        } else if (qName.equals("nomArticle")) {
            selectedBalise = "";
        } else if (qName.equals("prixVenteDetail")) {
            selectedBalise = "";
        } else if (qName.equals("quantite")) {
            selectedBalise = "";
        } else if (qName.equals("imageF")) {
            selectedBalise = "";
        } else if (qName.equals("enseigne")) {
            selectedBalise = "";
        }

    }

    public void characters(char[] chars, int i, int i1) throws SAXException {
        if (seclected != null) {
            if (selectedBalise.equals("idArticle")) {
                seclected.setIdArtcle(Integer.parseInt(new String(chars, i, i1)));
                System.out.println(new String(chars, i, i1));
            }
            if (selectedBalise.equals("nomArticle")) {
                seclected.setNomArticle(new String(chars, i, i1));
                System.out.println(new String(chars, i, i1));
            }
            if (selectedBalise.equals("prixVenteDetail")) {
                seclected.setPrixVente(Float.parseFloat(new String(chars, i, i1)));
                System.out.println(new String(chars, i, i1));
            }
            if (selectedBalise.equals("quantite")) {
                seclected.setQuantite(Integer.parseInt(new String(chars, i, i1)));
                System.out.println(new String(chars, i, i1));
            }
            if (selectedBalise.equals("imageF")) {
                seclected.setImageF(new String(chars, i, i1));
                System.out.println(new String(chars, i, i1));
            }
                        if (selectedBalise.equals("enseigne")) {
                seclected.setNomEnseigne(new String(chars, i, i1));
                System.out.println(new String(chars, i, i1));
            }
        }
    }

}
