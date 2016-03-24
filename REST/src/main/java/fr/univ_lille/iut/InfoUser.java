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
    private int parisPerdus;
    private int parisGagnes;
    private int argentGagner;
    private int argentPerdu;

    public InfoUser(int idUser, double solde, int parisPerdus, int parisGagnes, int argentGagner, int argentPerdu) {
        this.idUser = idUser;
        this.solde = solde;
        this.parisPerdus = parisPerdus;
        this.parisGagnes = parisGagnes;
        this.argentGagner = argentGagner;
        this.argentPerdu = argentPerdu;
    }

    public int getIdUser() {
        return idUser;
    }

    public int getParisGagnes() {
        return parisGagnes;
    }

    public int getParisPerdus() {
        return parisPerdus;
    }

    public double getSolde() {
        return solde;
    }

    public int getArgentGagner() {
        return argentGagner;
    }

    public int getArgentPerdu() {
        return argentPerdu;
    }
    
    

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setParisGagnes(int parisGagnes) {
        this.parisGagnes = parisGagnes;
    }

    public void setParisPerdus(int parisPerdus) {
        this.parisPerdus = parisPerdus;
    }

    public void setArgentGagner(int argentGagner) {
        this.argentGagner = argentGagner;
    }

    public void setArgentPerdu(int argentPerdu) {
        this.argentPerdu = argentPerdu;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }
    
    
}
