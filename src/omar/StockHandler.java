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
public class StockHandler extends DefaultHandler {

    Vector v = new Vector();
    Stock stock;
    String selectedBalise = "";

    public Stock[] getV() {
        Stock[] admins = new Stock[v.size()];
        v.copyInto(admins);
        return admins;
    }
    
    

    public void startElement(String string, String string1, String string2, Attributes atrbts) throws SAXException {
        if (string2.equals("stock")) {
            stock = new Stock();
        }
        else if (string2.equals("idArticle")) {
            selectedBalise = string2;
        }else if (string2.equals("nomArticle")) {
            selectedBalise = string2;
        } else if (string2.equals("prixVenteDetail")) {
            selectedBalise = string2;
        } else if (string2.equals("prixVenteGros")) {
            selectedBalise = string2;
        } else if (string2.equals("enseigne")) {
            selectedBalise = string2;
        } else if (string2.equals("genre")) {
            selectedBalise = string2;
        } else if (string2.equals("categorie")) {
            selectedBalise = string2;
        } else if (string2.equals("taille")) {
            selectedBalise = string2;
        }
        else if (string2.equals("like")) {
            selectedBalise = string2;
        }
    }

    public void endElement(String string, String string1, String string2) throws SAXException {
     if (string2.equals("stock")) {
            v.addElement(stock);
        }else if (string2.equals("idArticle")) {
            selectedBalise = string2;
        } else if (string2.equals("nomArticle")) {
            selectedBalise = "";
        } else if (string2.equals("prixVenteDetail")) {
            selectedBalise = "";
        } else if (string2.equals("prixVenteGros")) {
            selectedBalise = "";
        } else if (string2.equals("enseigne")) {
            selectedBalise = "";
        } else if (string2.equals("genre")) {
            selectedBalise = "";
        } else if (string2.equals("categorie")) {
            selectedBalise = "";
        } else if (string2.equals("taille")) {
            selectedBalise = "";
        }
     else if (string2.equals("like")) {
            selectedBalise = "";
        }
    }

    public void characters(char[] chars, int i, int i1) throws SAXException {
         if (stock != null) {
            if (selectedBalise.equals("nomArticle")) {
                stock.setNomArticle(new String(chars, i, i1));
            }else if (selectedBalise.equals("idArticle")) {
                stock.setId(Integer.parseInt(new String(chars, i, i1)));
            } else if (selectedBalise.equals("prixVenteDetail")) {
                stock.setPrixVenteDetail(Float.parseFloat(new String(chars, i, i1)));
            }else if (selectedBalise.equals("prixVenteGros")) {
                stock.setPrixVenteGros(Float.parseFloat(new String(chars, i, i1)));
            }else if (selectedBalise.equals("enseigne")) {
                stock.setEnseigne(new String(chars, i, i1));
            }else if (selectedBalise.equals("genre")) {
                stock.setGenre(new String(chars, i, i1));
            }else if (selectedBalise.equals("categorie")) {
                stock.setCategorie(new String(chars, i, i1));
            }else if (selectedBalise.equals("taille")) {
                stock.setTaille(new String(chars, i, i1));
            }else if (selectedBalise.equals("like")) {
                stock.setLike(Integer.parseInt(new String(chars, i, i1)));
            }
        }
    }

}
