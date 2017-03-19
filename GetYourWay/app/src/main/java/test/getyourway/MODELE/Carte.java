package test.getyourway.MODELE;

import java.util.ArrayList;

/**
 * Created by Sénthène on 09/01/2017.
 */

public class Carte {

    int idCarte;
    String nom;
    String adresse;
    int cp;
    String mail;
    int etage;
    ArrayList <Bloc> ListBloc;

    public Carte (int id, String n , String a, int cp, String m, int e, ArrayList<Bloc> l){

        nom = n;
        adresse = a;
        this. cp = cp;
        mail = m;
        etage = e;
        ListBloc = l;
        idCarte = id;

    }

    public Object getCarte(Carte c){

        return c;
}

    public int getEtage(){
        return etage;
    }

    public ArrayList<Bloc> getBloc (){
        return ListBloc;
    }

}
