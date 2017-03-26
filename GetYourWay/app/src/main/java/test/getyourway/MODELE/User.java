package test.getyourway.MODELE;

/**
 * Created by Sénthène on 09/01/2017.
 */

public class User {

    private int id_user;
    private String profil;
    private String email;
    private String password;
    private String nom;
    private String prenom;
    private String dc;
    private String dm;
    private int id_dm;
    Position position; // n'apparaît pas dans la base car c'est une variable

    public User (int id_user, String profil, String email, String password, String nom, String prenom, String dc, String dm, int id_dm){

        this.id_user=id_user;
        this.profil=profil;
        this.email=email;
        this.password=password;
        this.nom=nom;
        this.prenom=prenom;
        this.dc=dc;
        this.dm=dm;
        this.id_dm=id_dm;
        this.position = null;
    }


    public int getId_user() {
        return id_user;
    }

    public String getProfil() {
        return profil;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getDc() {
        return dc;
    }

    public String getDm() {
        return dm;
    }

    public int getId_dm() {
        return id_dm;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;

    }
}
