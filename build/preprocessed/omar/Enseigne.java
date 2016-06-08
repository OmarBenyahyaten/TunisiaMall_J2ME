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
public class Enseigne {
     int idEnseigne;
    String nom;
        int store;
    String srcLogo;
int star ;

    public Enseigne() {
        star =0;
    }

    public int getIdEnseigne() {
        return idEnseigne;
    }

    public void setIdEnseigne(int idEnseigne) {
        this.idEnseigne = idEnseigne;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getStore() {
        return store;
    }

    public void setStore(int store) {
        this.store = store;
    }

    public String getSrcLogo() {
        return srcLogo;
    }

    public void setSrcLogo(String srcLogo) {
        this.srcLogo = srcLogo;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }
    

}

