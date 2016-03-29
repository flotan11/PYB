/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_lille.iut.api;

/**
 *
 * @author youdelice
 */
public class Pari {
    private static int idInc;

    private int id;
    private String mdp;
    private String nom;
    private String side1;
    private String side2;
    private int miseSide1;
    private int miseSide2;
    private String description;
    private int coteSide1;
    private int coteSide2;
    private int miseMin;
    private int total;
    private boolean prive;
    
    public Pari() {
    	this.id = idInc++;
    }

    public Pari(String mdp, String nom, String side1, String side2, int miseSide1, int miseSide2, String description, int coteSide1, int codeSide2, int miseMin, int total, boolean priver) {
        this();
        this.mdp = mdp;
        this.nom = nom;
        this.side1 = side1;
        this.side2 = side2;
        this.miseSide1 = miseSide1;
        this.miseSide2 = miseSide2;
        this.description = description;
        this.coteSide1 = coteSide1;
        this.coteSide2 = codeSide2;
        this.miseMin = miseMin;
        this.total = total;
        this.prive = priver;
    }

    public void setCoteSide1(int coteSide1) {
        this.coteSide1 = coteSide1;
    }

    public void setCoteSide2(int coteSide2) {
        this.coteSide2 = coteSide2;
    }

    public int getCoteSide1() {
        return coteSide1;
    }

    public int getCoteSide2() {
        return coteSide2;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public String getMdp() {
        return mdp;
    }

    public static void setIdInc(int idInc) {
        Pari.idInc = idInc;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setSide1(String side1) {
        this.side1 = side1;
    }

    public void setSide2(String side2) {
        this.side2 = side2;
    }

    public void setMiseSide1(int miseSide1) {
        this.miseSide1 = miseSide1;
    }

    public void setMiseSide2(int miseSide2) {
        this.miseSide2 = miseSide2;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMiseMin(int miseMin) {
        this.miseMin = miseMin;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setPrive(boolean priver) {
        this.prive = priver;
    }

    public String getNom() {
        return nom;
    }

    public String getSide1() {
        return side1;
    }

    public String getSide2() {
        return side2;
    }

    public int getTotal() {
        return total;
    }

    public boolean isPrive() {
        return prive;
    }

    public int getMiseMin() {
        return miseMin;
    }

    public int getMiseSide1() {
        return miseSide1;
    }

    public int getMiseSide2() {
        return miseSide2;
    }
    
    public void addMiseSide1(int x) {
        miseSide1 += x;
    }
    
    public void addMiseSide2(int x) {
        miseSide2 += x;
    }
    
    
    
    
    
}
