/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package handler;

import entities.Article;
import entities.Film;
import java.util.Vector;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author damine
 */
public class FilmHandler extends DefaultHandler {

    private Vector FilmVector;

    public FilmHandler() {
        FilmVector = new Vector();
    }

    public Film[] getFilm() {
        Film[] personTab = new Film[FilmVector.size()];
      //  System.out.println(FilmVector.firstElement().toString());
        FilmVector.copyInto(personTab);
        return personTab;
    }

    String selectedBalise = "";
    Film seclected;

    public void startElement(String string, String string1, String qName, Attributes atrbts) throws SAXException {

        if (qName.equals("film")) {
            seclected = new Film();
        } else if (qName.equals("film_id")) {
            selectedBalise = "film_id";
        } else if (qName.equals("titre")) {
            selectedBalise = "titre";
        } else if (qName.equals("genre")) {
            selectedBalise = "genre";
        } else if (qName.equals("noteIm")) {
            selectedBalise = "noteIm";
        } else if (qName.equals("synopsis")) {
            selectedBalise = "synopsis";
        } else if (qName.equals("nationalite")) {
            selectedBalise = "nationalite";
        } else if (qName.equals("dateProduction")) {
            selectedBalise = "dateProduction";
        } else if (qName.equals("noteAl")) {
            selectedBalise = "noteAl";
        } else if (qName.equals("realisateur")) {
            selectedBalise = "realisateur";
        }else if (qName.equals("heureSeance")) {
            selectedBalise = "heureSeance";
        }else if (qName.equals("NomJour")) {
            selectedBalise = "NomJour";
        }

    }

    public void endElement(String string, String string1, String qName) throws SAXException {
        if (qName.equals("film")) {

            FilmVector.addElement(seclected);
            seclected = null;
        } else if (qName.equals("film_id")) {
            selectedBalise = "";
        } else if (qName.equals("titre")) {
            selectedBalise = "";
        } else if (qName.equals("genre")) {
            selectedBalise = "";
        } else if (qName.equals("noteIm")) {
            selectedBalise = "";
        } else if (qName.equals("synopsis")) {
            selectedBalise = "";
        } else if (qName.equals("nationalite")) {
            selectedBalise = "";
        } else if (qName.equals("dateProduction")) {
            selectedBalise = "";
        } else if (qName.equals("noteAl")) {
            selectedBalise = "";
        }  else if (qName.equals("realisateur")) {
            selectedBalise = "";
        } else if (qName.equals("heureSeance")) {
            selectedBalise = "";
        }else if (qName.equals("NomJour")) {
            selectedBalise = "";
        }

    }

    public void characters(char[] chars, int i, int i1) throws SAXException {
        if (seclected != null) {
            if (selectedBalise.equals("film_id")) {
                seclected.setFilm_id(Integer.parseInt(new String(chars, i, i1)));
                System.out.println(new String(chars, i, i1));
            }
            if (selectedBalise.equals("titre")) {
                seclected.setTitre(new String(chars, i, i1));
                System.out.println(new String(chars, i, i1));
            }
            if (selectedBalise.equals("genre")) {
                seclected.setGenre((new String(chars, i, i1)));
                System.out.println(new String(chars, i, i1));
            }
            if (selectedBalise.equals("noteIm")) {
                seclected.setNoteIm(new String(chars, i, i1));
                System.out.println(new String(chars, i, i1));
            }
            if (selectedBalise.equals("synopsis")) {
                seclected.setSynopsis(new String(chars, i, i1));
                System.out.println(new String(chars, i, i1));
            }
                        if (selectedBalise.equals("nationalite")) {
                seclected.setNationalite(new String(chars, i, i1));
                System.out.println(new String(chars, i, i1));
            }
                           if (selectedBalise.equals("dateProduction")) {
                seclected.setDateProduction(new String(chars, i, i1));
                System.out.println(new String(chars, i, i1));
            }
                           if (selectedBalise.equals("noteAl")) {
                seclected.setNoteAl((new String(chars, i, i1)));
                System.out.println(new String(chars, i, i1));
            }      
                           if (selectedBalise.equals("realisateur")) {
                seclected.setRealisateur(new String(chars, i, i1));
                System.out.println(new String(chars, i, i1));
            }            if (selectedBalise.equals("heureSeance")) {
                seclected.setHeureSeance(new String(chars, i, i1));
                System.out.println(new String(chars, i, i1));
            }             if (selectedBalise.equals("NomJour")) {
                seclected.setNomJour(new String(chars, i, i1));
                System.out.println(new String(chars, i, i1));
            }
        }
    }

}
