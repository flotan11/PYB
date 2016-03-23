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
public class InfoUser {
    private int idUser;
    private double solde;
    private int pariePerdu;
    private int parieGagner;

    public InfoUser(int idUser, double solde, int pariePerdu, int parieGagner) {
        this.idUser = idUser;
        this.solde = solde;
        this.pariePerdu = pariePerdu;
        this.parieGagner = parieGagner;
    }

    public int getIdUser() {
        return idUser;
    }

    public int getParieGagner() {
        return parieGagner;
    }

    public int getPariePerdu() {
        return pariePerdu;
    }

    public double getSolde() {
        return solde;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setParieGagner(int parieGagner) {
        this.parieGagner = parieGagner;
    }

    public void setPariePerdu(int pariePerdu) {
        this.pariePerdu = pariePerdu;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }
    
    
}
