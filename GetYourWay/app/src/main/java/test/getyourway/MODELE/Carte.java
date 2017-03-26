package test.getyourway.MODELE;

/**
 * Created by Sénthène on 09/01/2017.
 */

public class Carte {

    private int idCarte;
    private int placeId;
    private float latitude;
    private float longitude;
    private String nom;
    private String adresse;
    private int cp;
    private String dc;
    private int id_uc;
    private String dm;
    private int id_dm;

    public Carte (int idCarte ,int placeId, float latitude, float longitude, String nom , String adresse, int cp, String dc, int id_uc, String dm, int id_dm){

        this.idCarte=idCarte;
        this.placeId=placeId;
        this.latitude=latitude;
        this.longitude=longitude;
        this.nom=nom;
        this.adresse=adresse;
        this.cp=cp;
        this.dc=dc;
        this.id_uc=id_uc;
        this.dm=dm;
        this.id_dm=id_dm;


    }

    public Object getCarte(Carte c){

        return c;
}

    public float getLatitude() {
        return latitude;
    }

    public int getId_dm() {
        return id_dm;
    }

    public int getId_uc() {
        return id_uc;
    }

    public String getDm() {
        return dm;
    }

    public String getDc() {
        return dc;
    }

    public int getCp() {
        return cp;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getNom() {
        return nom;
    }

    public float getLongitude() {
        return longitude;
    }

    public int getPlaceId() {
        return placeId;
    }

    public int getIdCarte() {
        return idCarte;
    }


}
