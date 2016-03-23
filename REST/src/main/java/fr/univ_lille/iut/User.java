package fr.univ_lille.iut;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
    public static int nbUser;
    private int id;
    private String login;
    private String mdp;
    private String adresse;
    private int codePostal;
    private String ville;
    private String mail;
    private int age;

    public User(String login, String mdp, String adresse, int codePostal, String ville, String mail, int age) {
    	this();
        this.login = login;
        this.mdp = mdp;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.mail = mail;
        this.age = age;
    }

    public User() {
    	this.id = ++nbUser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

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

    public String getMdp() {
        return mdp;
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

    public boolean equals(Object u) {
        return login.equals(((User) u).login) || mail.equals(((User) u).mail);
    }

    public String toString() {
        return login + " " + mail;
    }
}
