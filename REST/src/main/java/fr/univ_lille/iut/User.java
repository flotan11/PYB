package fr.univ_lille.iut;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
    private static int nbUser;
    private int id;
    
    private String nom;
    private String prenom;
    private String login;
    private String mdp;
    private String adresse;
    private int codePostal;
    private String ville;
    private String mail;
    private int age;
    private String mobile;

    public User(String nom, String prenom, String login, String mdp, String adresse, int codePostal, String ville, String mail, int age, String mobile) {
    	this();
    	this.nom = nom;
    	this.prenom = prenom;
        this.login = login;
        this.mdp = mdp;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.mail = mail;
        this.age = age;
        this.mobile = mobile;
    }

    public User() {
    	this.id = ++nbUser;
    }
    
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    
    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getMdp() { return mdp; }
    
    public String getMail() {
        return mail;
    }

    public String getAdresse() {
        return adresse;
    }

    public int getAge() {
        return age;
    }

    public int getCodePostal() {
        return codePostal;
    }
    
    public int getId() {
        return id;
    }


    public String getVille() {
        return ville;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    
    public void setId(int id) {
    	
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    
    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }

    public boolean equals(Object u) {
        return login.equals(((User) u).login) || mail.equals(((User) u).mail);
    }

    public String toString() {
        return login + " " + mail;
    }
}
