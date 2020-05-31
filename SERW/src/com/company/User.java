package com.company;

import java.io.Serializable;

public class User implements Serializable {

    private String login;
    private String parol;

    public User(){}

    public User(String login,String parol){
        this.login=login;
        this.parol=parol;
    }

    public  void setLogin(String login) {
        this.login = login;
    }

    public  void  setParol(String parol){
        this.parol=parol;
    }

    public String getLogin(){
        return login;
    }

    public String getParol(){
        return parol;
    }

    public int ChekLoginParol(String login,String parol){
        if(this.login.equals(login) && this.parol.equals(parol))return 1;
        else return 0;
    }

}
