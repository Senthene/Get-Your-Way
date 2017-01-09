package test.getyourway;

import java.util.ArrayList;

/**
 * Created by Sénthène on 09/01/2017.
 */

public class Bloc {

    int idBloc;
    String type;
    String nom;
    int idCarte;
    ArrayList <Ligne> listLignes;

    public Bloc (int id, String t, String n, int i, ArrayList<Ligne> l){

        type = t;
        nom = n;
        idCarte = i;
        listLignes = l;
        idBloc = id;
    }

    public String getNomBloc(){
        return nom;
    }

    public String getTypeBloc(){
        return type;
    }

    public ArrayList<Ligne> getLignesBloc(){
        return listLignes;
    }

    public void setLignesBloc(ArrayList<Ligne> l){
        listLignes = l;
    }

}


