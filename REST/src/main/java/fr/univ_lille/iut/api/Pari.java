/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univ_lille.iut.api;

public class Pari {
    private static int idInc;

    private int id;
    private String mdp;
    private String nom;
    private String sideOne;
    private String sideTwo;
    private String description;
    private int miseSideOne;
    private int miseSideTwo;
    private int coteSideOne;
    private int coteSideTwo;
    private int miseMin;
    private int total;
    private boolean privacy;
    
    public Pari() {
    	this.id = ++idInc;
    }
    
    public Pari(String nom, String description) {
    	this();
    	this.nom = nom;
    	this.description = description;
    }
    
    public Pari(String nom, String sideOne, String sideTwo, String description, int miseMin, boolean privacy) {
    	this();
    	this.nom = nom;
    	this.sideOne = sideOne;
    	this.sideTwo = sideTwo;
    	this.description = description;
    	this.miseMin = miseMin;
    	this.privacy = privacy;
    }

    public Pari(String mdp, String nom, String sideOne, String sideTwo, String description, int miseMin, boolean privacy) {
        this(nom, sideOne, sideTwo, description, miseMin, privacy);
    	this.mdp = mdp;
    }

    public void setCoteSideOne(int coteSideOne) {
        this.coteSideOne = coteSideOne;
    }

    public void setCoteSideTwo(int coteSideTwo) {
        this.coteSideTwo = coteSideTwo;
    }

    public int getCoteSideOne() {
        return coteSideOne;
    }

    public int getCoteSideTwo() {
        return coteSideTwo;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setSideOne(String sideOne) {
        this.sideOne = sideOne;
    }

    public void setSideTwo(String sideTwo) {
        this.sideTwo = sideTwo;
    }

    public void setMiseSideOne(int miseSideOne) {
        this.miseSideOne = miseSideOne;
    }

    public void setMiseSideTwo(int miseSideTwo) {
        this.miseSideTwo = miseSideTwo;
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

    public void setPrivacy(boolean privacy) {
        this.privacy = privacy;
    }

    public String getNom() {
        return nom;
    }

    public String getSideOne() {
        return sideOne;
    }

    public String getSideTwo() {
        return sideTwo;
    }

    public int getTotal() {
        return total;
    }

    public boolean getPrivacy() {
        return privacy;
    }

    public int getMiseMin() {
        return miseMin;
    }

    public int getMiseSideOne() {
        return miseSideOne;
    }

    public int getMiseSideTwo() {
        return miseSideTwo;
    }
    
    public void addMiseSideOne(int mise) {
        this.miseSideOne += mise;
        setTotal(this.total + mise);
        setCoteSideOne(this.total / this.miseSideOne);
    }
    
    public void addMiseSideTwo(int mise) {
        this.miseSideTwo += mise;
        setTotal(this.total + mise);
        setCoteSideTwo(this.total / this.miseSideTwo);
    }
    
}
