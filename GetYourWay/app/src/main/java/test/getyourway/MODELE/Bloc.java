package test.getyourway.MODELE;

/**
 * Created by Sénthène on 09/01/2017.
 */

public class Bloc {

    private int idBloc;
    private  int idEtage;
    private String type;
    private String nom;
    private String dc;
    private int id_dc;
    private String dm;
    private int id_dm;

    public Bloc (int idBloc, int idEtage, String type, String nom, String dc, int id_dc, String dm, int id_dm ){

        this.idBloc=idBloc;
        this.idEtage=idEtage;
        this.type=type;
        this.nom=nom;
        this.dc=dc;
        this.id_dc=id_dc;
        this.dm=dm;
        this.id_dm=id_dm;

    }

    public int getIdBloc() {
        return idBloc;
    }

    public int getIdEtage() {
        return idEtage;
    }

    public String getType() {
        return type;
    }

    public String getNom() {
        return nom;
    }

    public String getDc() {
        return dc;
    }

    public int getId_dc() {
        return id_dc;
    }

    public String getDm() {
        return dm;
    }

    public int getId_dm() {
        return id_dm;
    }
}


