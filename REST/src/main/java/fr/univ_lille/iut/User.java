package fr.univ_lille.iut;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
    private int id = 0;
    private String login;
    private String mdp;
    private String addesse;
    private int codePostale;
    private String ville;
    private String mail;
    private int age;

    public User(int id, String login, String mpd, String addesse, int codePostale, String ville, String mail, int age) {
        this.id = id ++;
        this.login = login;
        this.mdp = mpd;
        this.addesse = addesse;
        this.codePostale = codePostale;
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
        return codePostale;
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

    public void setCodePostale(int codePostale) {
        this.codePostale = codePostale;
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
