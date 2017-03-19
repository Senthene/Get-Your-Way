package test.getyourway.MODELE;

/**
 * Created by Sénthène on 09/01/2017.
 */

public class User {

    String mail;
    String nom;
    String prenom;
    Position p; // n'apparaît pas dans la base car c'est une variable

    public User (String m, String n, String pr){

        mail = m;
        nom = n;
        prenom = pr;
    }

    public User (String m, String n, String pr, Position p){

        mail = m;
        nom = n;
        prenom = pr;
        this.p = p;
    }

    public void setMail(String m){
       mail = m;
    }

    public void setPrenom(String p){
        prenom = p;
    }

    public void setNom(String n){
        nom = n;
    }

    public void setPosition(Position p){
        this.p = p;
    }


}
