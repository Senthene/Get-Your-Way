package test.getyourway.MODELE;

/**
 * Created by Sénthène on 25/03/2017.
 */

public class Liaison {

    private int idLiaison;
    private int idEtageActuel;
    private int numeroEtageActuel;
    private int idEtage;
    private int numeroEtage;
    private Position position;
    private String type;

    public Liaison(int idLiaison , int idEtageActuel, int numeroEtageActuel, int idEtage, int numeroEtage, float positionX , float positionY,String type){

        this.idLiaison=idLiaison;
        this.idEtageActuel=idEtageActuel;
        this.numeroEtageActuel=numeroEtageActuel;
        this.idEtage=idEtage;
        this.numeroEtage=numeroEtage;
        this.position = new Position(positionX, positionY);
        this.type=type;
    }

    public int getIdLiaison() {
        return idLiaison;
    }

    public int getIdEtageActuel() {
        return idEtageActuel;
    }

    public int getNumeroEtageActuel() {
        return numeroEtageActuel;
    }

    public int getIdEtage() {
        return idEtage;
    }

    public int getNumeroEtage() {
        return numeroEtage;
    }

    public Position getPosition() {
        return position;
    }

    public String getType() {
        return type;
    }
}
