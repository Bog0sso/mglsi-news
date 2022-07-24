package com.utilisateur.domaine;

public class Utilisateur {
    private int id;
    private String login;
    private String password;

    public Utilisateur() {
    }

    public Utilisateur(String login, String password) {
        super();
        this.login = login;
        this.password = password;
    }
    public int getId() {
        return id;
    }
    public String getLogin() {
        return login;
    }
    public String getPassword() {
        return password;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public void setPassword(String password) {
        this.password = password;
    }

}
