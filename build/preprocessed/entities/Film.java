/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author dhia
 */
public class Film {
    private int film_id;
    private String titre;
    private String genre;
    private String noteIm;
    private String synopsis;
    private String nationalite;
    private String dateProduction;
    private String noteAl;
    private String realisateur;
    private String heureSeance;
    private String NomJour;

    public String toString() {
        return "Film{" + "film_id=" + film_id + ", titre=" + titre + ", genre=" + genre + ", noteIm=" + noteIm + ", synopsis=" + synopsis + ", nationalite=" + nationalite + ", dateProduction=" + dateProduction + ", noteAl=" + noteAl + ", realisateur=" + realisateur + ", heureSeance=" + heureSeance + ", NomJour=" + NomJour + '}';
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    

    

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getNoteIm() {
        return noteIm;
    }

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public String getHeureSeance() {
        return heureSeance;
    }

    public void setHeureSeance(String heureSeance) {
        this.heureSeance = heureSeance;
    }

    public String getNomJour() {
        return NomJour;
    }

    public void setNomJour(String NomJour) {
        this.NomJour = NomJour;
    }

    public void setNoteIm(String noteIm) {
        this.noteIm = noteIm;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getDateProduction() {
        return dateProduction;
    }

    public void setDateProduction(String dateProduction) {
        this.dateProduction = dateProduction;
    }

    public String getNoteAl() {
        return noteAl;
    }

    public void setNoteAl(String noteAl) {
        this.noteAl = noteAl;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }
    
}
