/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_lille.iut;
import java.sql.Date;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Evenement {

     public static int nbEvenements;
     private int id;
     
     private int idUser;
     private String titre;
     private int cote;
     private String description;
     private int nbParieurs;
     private int nbParieursMin;
     private int miseMin;
     private Date datef;
     private boolean prive;
     private int somme;
     private String equipe1,equipe2;

    public Evenement(int idUser, String titre, String description, int nbParieurs, int nbParieursMin, int miseMin, int cote, Date datef, boolean prive,int somme,String equipe1, String equipe2) {
        this();
        this.idUser = idUser;
        this.titre = titre;
        this.description = description;
        this.nbParieurs = nbParieurs;
        this.nbParieursMin = nbParieursMin;
        this.miseMin = miseMin;
        this.cote = cote;
        this.datef = datef;
        this.prive = prive;
        this.somme = somme;
        this.equipe1=equipe1;
        this.equipe2=equipe2;
    }

    public Evenement() {
        this.id = ++nbEvenements;
    }


    public static int getNbEvenements() { return nbEvenements; }
    
    public int getSomme() { return somme; }
    public void setSomme(int somme) { this.somme = somme; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdUser() { return idUser; }
    public void setIdUser(int idUser) { this.idUser = idUser; }

    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }

    public int getCote() { return cote; }
    public void setCote(int cote) { this.cote = cote; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getNbParieurs() { return nbParieurs; }
    public void setNbParieurs(int nbParieurs) { this.nbParieurs = nbParieurs; }

    public int getNbParieursMin() { return nbParieursMin; }
    public void setNbParieursMin(int nbParieursMin) { this.nbParieursMin = nbParieursMin; }

    public int getMiseMin() { return miseMin; }
    public void setMiseMin(int miseMin) { this.miseMin = miseMin; }

    public Date getDatef() { return datef; }
    public void setDatef(Date datef) { this.datef = datef; }
	
	public boolean getPrive() { return prive; }
    public void setPrive(boolean prive) { this.prive = prive; }

    public String getEquipe1() { return equipe1; }
    public void setEquipe1(String equipe) { this.equipe1 = equipe; }

    public String getEquipe2() { return equipe2; }
    public void setEquipe2(String equipe) { this.equipe2 = equipe; }
    
}
