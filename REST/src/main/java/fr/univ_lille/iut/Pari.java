/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_lille.iut;
import java.sql.Date;
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
    private Date datef;

    public Pari(int idUser, int idEvenement, double valeur, Date datef) {
        this.idUser = idUser;
        this.idEvenement = idEvenement;
        this.valeur = valeur;
        this.datef = datef;
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
    
    public Date getDatef(){
        return datef;
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
    
    public void setDate(Date datef){
        this.datef = datef;
    }
    
}
