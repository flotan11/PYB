/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_lille.iut;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author youdelice
 */
public class Evenement {
     private int id = 0;
     private int idUser;
     private String titre;
     private String description;
     private int nbParieur;
     private int nbParieurMin;
     private int miseMin;

    public Evenement(int idUser,int id,String titre, String description, int nbParieur, int nbParieurMin, int miseMin) {
        this.id = id ++;
        this.idUser = idUser;
        this.titre = titre;
        this.description = description;
        this.nbParieur = nbParieur;
        this.nbParieurMin = nbParieurMin;
        this.miseMin = miseMin;
    }

    public String getDescription() {
        return description;
    }

    public int getMiseMin() {
        return miseMin;
    }

    public int getNbParieur() {
        return nbParieur;
    }

    public int getNbParieurMin() {
        return nbParieurMin;
    }

    public String getTitre() {
        return titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMiseMin(int miseMin) {
        this.miseMin = miseMin;
    }

    public void setNbParieur(int nbParieur) {
        this.nbParieur = nbParieur;
    }

    public void setNbParieurMin(int nbParieurMin) {
        this.nbParieurMin = nbParieurMin;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
     
     
}
