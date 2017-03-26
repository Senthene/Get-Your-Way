package test.getyourway.MODELE;

/**
 * Created by Sénthène on 25/03/2017.
 */

public class Etage {

    private int idEtage;
    private int idCarte;
    private int numeroEtage;
    private String dc;
    private int id_dc;
    private String dm;
    private int id_dm;

    public Etage (int idEtage, int idCarte, int numeroEtage, String dc, int id_dc, String dm, int id_dm){

        idEtage=idEtage;
        idCarte=idCarte;
        numeroEtage=numeroEtage;
        dc=dc;
        id_dc=id_dc;
        dm=dm;
        id_dm=id_dm;
    }

    public int getIdEtage() {
        return idEtage;
    }

    public int getIdCarte() {
        return idCarte;
    }

    public int getNumeroEtage() {
        return numeroEtage;
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
