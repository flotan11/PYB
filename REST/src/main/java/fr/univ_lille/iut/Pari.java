/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_lille.iut;
import java.sql.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Pari {
    
    private int idPari;
    private int idUser;
    private int idEvent;
    private double valeur;
    
    public Pari(int idUser, int idEvent, double valeur) {
    	idPari = 100000*idUser + idEvent;
        this.idUser = idUser;
        this.idEvent = idEvent;
        this.valeur = valeur;
    }
    
    public int getIdPari() { return idPari; }
    public void setIdPari(int idPari) { this.idPari = idPari; }

    public int getIdUser() { return idUser; }
    public void setIdUser(int idUser) { this.idUser = idUser; }

    public int getIdEvent() { return idEvent; }
    public void setIdEvent(int idEvent) { this.idEvent = idEvent; }

    public double getValeur() { return valeur; }
    public void setValeur(double valeur) { this.valeur = valeur; }

}
