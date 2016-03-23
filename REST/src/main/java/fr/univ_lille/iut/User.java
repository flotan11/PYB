package fr.univ_lille.iut;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
    private static int nbUser;
    private int id = 0;
    private String login;
    private String mdp;
    private String addesse;
    private int codePostal;
    private String ville;
    private String mail;
    private int age;

    public User(String login, String mpd, String addesse, int codePostal, String ville, String mail, int age) {
        id = nbUser ++;
        this.login = login;
        this.mdp = mpd;
        this.addesse = addesse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.mail = mail;
        this.age = age;
    }

    public User() {}

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getAddesse() {
        return addesse;
    }

    public int getAge() {
        return age;
    }

    public int getCodePostale() {
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

    public void setAddesse(String addesse) {
        this.addesse = addesse;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCodePostale(int codePostal) {
        this.codePostal = codePostal;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public boolean equals(Object u) {
        return login.equals(((User) u).login) || mail.equals(((User) u).mail);
    }

    public String toString() {
        return login + " " + login + " " + mail;
    }
}
