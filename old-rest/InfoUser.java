/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_lille.iut;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement

public class InfoUser {

    private int idUser;
    private double solde;
    private int parisGagnes;
    private int parisPerdus;
    private double argentGagne;
    private double argentPerdu;

    public InfoUser(int idUser, double solde, int parisPerdus, int parisGagnes, double argentGagne, double argentPerdu) {
        this.idUser = idUser;
        this.solde = solde;
        this.parisGagnes = parisGagnes;
        this.parisPerdus = parisPerdus;
        this.argentGagne = argentGagne;
        this.argentPerdu = argentPerdu;
    }

    public int getIdUser() { return idUser; }
    public void setIdUser(int idUser) { this.idUser = idUser; }

    public double getSolde() { return solde; }
    public void setSolde(double solde) { this.solde = solde; }
    
    public int getParisGagnes() { return parisGagnes; }
    public void setParisGagnes(int parisGagnes) { this.parisGagnes = parisGagnes; }

    public int getParisPerdus() { return parisPerdus; }
    public void setParisPerdus(int parisPerdus) { this.parisPerdus = parisPerdus; }

    public double getArgentGagne() { return argentGagne; }
    public void setArgentGagne(double argentGagne) { this.argentGagne = argentGagne; }

    public double getArgentPerdu() { return argentPerdu; }
    public void setArgentPerdu(double argentPerdu) { this.argentPerdu = argentPerdu; }
    
}
