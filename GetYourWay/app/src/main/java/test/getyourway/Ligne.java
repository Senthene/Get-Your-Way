package test.getyourway;

/**
 * Created by Sénthène on 09/01/2017.
 */

public class Ligne {


    int idLigne;
    int idBLoc;
    double departX;
    double departY;
    double finX;
    double finY;
    double longueur;
    double angle;

    // Pas de depart Z et de fin Z car nous restons dans le 2D

    public Ligne (int id, int i, double dx, double dy, double fx, double fy, double l, double a){

        idBLoc = i;
        departX = dx;
        departY = dy;
        finX = fx;
        finY = fy;
        longueur = l;
        angle = a;
        idLigne = id;
    }

    public double getDepartX(){
        return departX;
    }

    public double getDepartY(){
        return departY;
    }

    public double getFinX(){
        return finX;
    }

    public double getFinY(){
        return finY;
    }
    public double getLongueur(){
        return longueur;
    }
    public double getAngle(){
        return angle;
    }



}
