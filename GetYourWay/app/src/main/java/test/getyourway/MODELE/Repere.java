package test.getyourway.MODELE;

/**
 * Created by Sénthène on 25/03/2017.
 */

public class Repere {

    private int idRepere;
    private int idEtage;
    private String type;
    private Position position;
    private String dc;
    private int id_dc;
    private String dm;
    private int id_dm;

    public Repere( int idRepere, int idEtage, String type, float positionX, float positionY , String dc, int id_dc, String dm, int id_dm){

        this.idRepere=idRepere;
        this.idEtage=idEtage;
        this.type=type;
        this.position= new Position(positionX, positionY);
        this.dc=dc;
        this.id_dc=id_dc;
        this.dm=dm;
        this.id_dm=id_dm;
    }

    public int getIdRepere() {
        return idRepere;
    }

    public int getIdEtage() {
        return idEtage;
    }

    public String getType() {
        return type;
    }

    public Position getPosition() {
        return position;
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
