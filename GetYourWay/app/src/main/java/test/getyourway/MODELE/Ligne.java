package test.getyourway.MODELE;

/**
 * Created by Sénthène on 09/01/2017.
 */

public class Ligne {


    private int idLigne;
    private int idBloc;
    private float departX;
    private float departY;
    private float departZ;
    private float finX;
    private float finY;
    private float finZ;
    private float longueur;
    private float angle;

    // Pas de depart Z et de fin Z car nous restons dans le 2D

    public Ligne (int idLigne, int idBloc, float departX, float departY, float departZ, float finX, float finY, float finZ, float longueur, float angle){

        this.idLigne=idLigne ;
        this.idBloc=idBloc;
        this.departX=departX;
        this.departY=departY;
        this.departZ=departZ;
        this.finX=finX;
        this.finY=finY;
        this.finZ=finZ;
        this.longueur=longueur;
        this.angle=angle;
    }

    public int getIdLigne() {
        return idLigne;
    }

    public int getIdBloc() {
        return idBloc;
    }

    public float getDepartX() {
        return departX;
    }

    public float getDepartY() {
        return departY;
    }

    public float getDepartZ() {
        return departZ;
    }

    public float getFinX() {
        return finX;
    }

    public float getFinY() {
        return finY;
    }

    public float getFinZ() {
        return finZ;
    }

    public float getLongueur() {
        return longueur;
    }

    public float getAngle() {
        return angle;
    }
}
