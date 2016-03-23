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
@XmlRootElement
public class Evenement {
     private int id;
     public static int nbEvenement;
     private int idUser;
     private String titre;
     private String description;
     private int nbParieur;
     private int nbParieurMin;
     private int miseMin;

    public Evenement(int idUser,String titre, String description, int nbParieur, int nbParieurMin, int miseMin) {
        this();
        this.idUser = idUser;
        this.titre = titre;
        this.description = description;
        this.nbParieur = nbParieur;
        this.nbParieurMin = nbParieurMin;
        this.miseMin = miseMin;
    }

    public Evenement() {
        this.id = ++nbEvenement;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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
