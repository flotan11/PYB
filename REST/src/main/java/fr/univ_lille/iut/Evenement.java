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

     public static int nbEvenements;
     private int id;
     
     private int idUser;
     private String titre;
     private String description;
     private int nbParieurs;
     private int nbParieursMin;
     private int miseMin;

    public Evenement(int idUser, String titre, String description, int nbParieurs, int nbParieursMin, int miseMin) {
        this();
        this.idUser = idUser;
        this.titre = titre;
        this.description = description;
        this.nbParieurs = nbParieurs;
        this.nbParieursMin = nbParieursMin;
        this.miseMin = miseMin;
    }

    public Evenement() {
        this.id = ++nbEvenements;
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

    public int getNbParieurs() {
        return nbParieurs;
    }

    public int getNbParieusrMin() {
        return nbParieursMin;
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

    public void setNbParieurs(int nbParieurs) {
        this.nbParieurs = nbParieurs;
    }

    public void setNbParieursMin(int nbParieursMin) {
        this.nbParieursMin = nbParieursMin;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
     
     
}
