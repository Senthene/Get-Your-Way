package test.getyourway.MODELE;

/**
 * Created by Sénthène on 09/01/2017.
 */

public class Ligne {


    int idLigne;
    int idBLoc;
    float departX;
    float departY;
    float departZ;
    float finX;
    float finY;
    float finZ;
    float longueur;
    float angle;

    // Pas de depart Z et de fin Z car nous restons dans le 2D

    public Ligne (float dx, float dy, float dz, float fx, float fy, float fz){

        departX = dx;
        departY = dy;
        departZ = dz;
        finX = fx;
        finY = fy;
        finZ = fz;
    }


    public Ligne (int id, int i, float dx, float dy, float fx, float fy, float l, float a){

        idBLoc = i;
        departX = dx;
        departY = dy;
        finX = fx;
        finY = fy;
        longueur = l;
        angle = a;
        idLigne = id;
    }

    public float getDepartX(){
        return departX;
    }

    public float getDepartY(){
        return departY;
    }

    public float getFinX(){
        return finX;
    }

    public float getFinY(){
        return finY;
    }
    public float getLongueur(){
        return longueur;
    }
    public float getAngle(){
        return angle;
    }



}
