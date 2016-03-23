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
public class Pari {
    
    private int idUser;
    private int idEvenement;
    private double valeur;

    public Pari(int idUser, int idEvenement, double valeur) {
        this.idUser = idUser;
        this.idEvenement = idEvenement;
        this.valeur = valeur;
    }

    public int getIdEvenement() {
        return idEvenement;
    }

    public int getIdUser() {
        return idUser;
    }

    public double getValeur() {
        return valeur;
    }

    public void setIdEvenement(int idEvenement) {
        this.idEvenement = idEvenement;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }

    
}
