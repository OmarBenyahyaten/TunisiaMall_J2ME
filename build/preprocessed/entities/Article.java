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
public class Article {
    
    private int idArtcle;
    private String nomArticle;
    private float prixVente;
    private String nomEnseigne;
    private String imageF;

    public int getQuantite() {
        return quantite;
    }

    public Article(int idArtcle, String nomArticle, float prixVente, String nomEnseigne, String imageF, int quantite) {
        this.idArtcle = idArtcle;
        this.nomArticle = nomArticle;
        this.prixVente = prixVente;
        this.nomEnseigne = nomEnseigne;
        this.imageF = imageF;
        this.quantite = quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    private int quantite;

    public float getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(float prixVente) {
        this.prixVente = prixVente;
    }

    public Article() {
    }

    ;


    public int getIdArtcle() {
        return idArtcle;
    }

    public void setIdArtcle(int idArtcle) {
        this.idArtcle = idArtcle;
    }

    public String getNomArticle() {
        return nomArticle;
    }

    public void setNomArticle(String nomArticle) {
        this.nomArticle = nomArticle;
    }

    public String getNomEnseigne() {
        return nomEnseigne;
    }

    public void setNomEnseigne(String nomEnseigne) {
        this.nomEnseigne = nomEnseigne;
    }

    public String toString() {
        return "Article{" + "idArtcle=" + idArtcle + ", nomArticle=" + nomArticle + ", prixVente=" + prixVente + ", nomEnseigne=" + nomEnseigne + ", imageF=" + imageF + ", quantite=" + quantite + '}';
    }


   

    public String getImageF() {
        return imageF;
    }

    public void setImageF(String imageF) {
        this.imageF = imageF;
    }
}
