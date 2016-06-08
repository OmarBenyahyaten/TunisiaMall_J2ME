/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package omar;

/**
 *
 * @author omarblythe
 */
public class Stock {
    int id ;
    String nomArticle;
    float prixVenteGros;
    float prixVenteDetail;
    String Enseigne;
     String genre ;
    String categorie;
    String taille;
    int star;
    int like ;

    public Stock() {
        star =0 ;
        like = 0;
    }

    public Stock(String nomArticle, float prixVenteGros, float prixVenteDetail, String Enseigne, String genre, String categorie, String taille) {
        this.nomArticle = nomArticle;
        this.prixVenteGros = prixVenteGros;
        this.prixVenteDetail = prixVenteDetail;
        this.Enseigne = Enseigne;
        this.genre = genre;
        this.categorie = categorie;
        this.taille = taille;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getNomArticle() {
        return nomArticle;
    }

    public void setNomArticle(String nomArticle) {
        this.nomArticle = nomArticle;
    }

    public float getPrixVenteGros() {
        return prixVenteGros;
    }

    public void setPrixVenteGros(float prixVenteGros) {
        this.prixVenteGros = prixVenteGros;
    }

    public float getPrixVenteDetail() {
        return prixVenteDetail;
    }

    public void setPrixVenteDetail(float prixVenteDetail) {
        this.prixVenteDetail = prixVenteDetail;
    }

    public String getEnseigne() {
        return Enseigne;
    }

    public void setEnseigne(String Enseigne) {
        this.Enseigne = Enseigne;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getTaille() {
        return taille;
    }

    public void setTaille(String taille) {
        this.taille = taille;
    }
    
      public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
