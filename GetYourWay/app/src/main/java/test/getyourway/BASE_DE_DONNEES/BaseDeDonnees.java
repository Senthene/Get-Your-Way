package test.getyourway.BASE_DE_DONNEES;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import test.getyourway.MODELE.Bloc;
import test.getyourway.MODELE.Carte;
import test.getyourway.MODELE.Etage;
import test.getyourway.MODELE.Liaison;
import test.getyourway.MODELE.Ligne;
import test.getyourway.MODELE.Repere;
import test.getyourway.MODELE.User;

/**
 * Created by Sénthène on 19/03/2017.
 */

public class BaseDeDonnees extends SQLiteOpenHelper{

    private static String DATABASE_NAME = "BDD_GET_YOUR_WAY.db";
    private int DATABASE_VERSION = 1;
    private ArrayList<Carte> listeCarte;
    private ArrayList<Bloc> listeBloc;
    private ArrayList<Ligne> listeLigne;
    private ArrayList<Liaison> listeLiaison;
    private ArrayList<Repere> listeRepere;
    private ArrayList<User> listeUser;
    private ArrayList<Etage> listeEtage;

    // TABLE USER
    private static String j01_list_user= "j01_list_user";

    private String J01_ID_USER = "J01_ID_USER ";
    private String J01_PROFIL = "J01_PROFIL";
    private String J01_EMAIL = "J01_EMAIL";
    private String J01_PASSWORD = "J01_PASSWORD";
    private String J01_NOM = "J01_NOM";
    private String J01_PRENOM = "J01_PRENOM ";
    private String J01_DC = "J01_DC";
    private String J01_DM = "J01_DM ";
    private String J01_ID_DM = "J01_ID_DM";

    // TABLE CARTE
    private static String j03_list_carte = "j03_list_carte";

    private String J03_ID_CARTE = "J03_ID_CARTE";
    private String J03_PLACE_ID = "J03_PLACE_ID";
    private String J03_LATITUDE= "J03_LATITUDE";
    private String J03_LONGITUDE= "J03_LONGITUDE";
    private String J03_NOM= "J03_NOM";
    private String J03_ADRESSE= "J03_ADRESSE";
    private String J03_CP= "J03_CP";
    private String J03_DC= "J03_DC";
    private String J03_ID_UC= "J03_ID_UC";
    private String J03_DM= "J03_DM";
    private String J03_ID_DM= "J03_ID_DM";

    // TABLE BLOC
    private static String j04_bloc = "j04_bloc";

    private String J04_ID_BLOC = "J04_ID_BLOC";
    private String J04_ID_ETAGE = "J04_ID_ETAGE";
    private String J04_TYPE= "J04_TYPE";
    private String J04_NOM= "J04_NOM";
    private String J04_DC= "J04_DC";
    private String J04_ID_DC= "J04_ID_DC";
    private String J04_DM= "J04_DM";
    private String J04_ID_DM= "J04_ID_DM";

    // TABLE LIGNE
    private static String j05_ligne= "j05_ligne";

    private String J05_ID_LINE = "J05_ID_LINE ";
    private String J05_ID_BLOC = "J05_ID_BLOC";
    private String J05_Depart_X = "J05_Depart_X";
    private String J05_Depart_Y = "J05_Depart_Y";
    private String J05_Depart_Z = "J05_Depart_Z";
    private String J05_Fin_X = "J05_Fin_X ";
    private String J05_Fin_Y = "J05_Fin_Y";
    private String J05_Fin_Z = "J05_Fin_Z";
    private String J05_Longueur = "J05_Longueur";
    private String J05_Angle = "J05_Angle";

    // TABLE ETAGE
    private static String j06_etage= "j06_etage";

    private String J06_ID_ETAGE = "J06_ID_ETAGE ";
    private String J06_ID_CARTE = "J06_ID_CARTE";
    private String J06_NUMERO_ETAGE = "J06_NUMERO_ETAGE";
    private String J06_DC = "J06_DC";
    private String J06_ID_DC = "J06_ID_DC";
    private String J06_DM = "J06_DM ";
    private String J06_ID_DM = "J06_ID_DM";

    // TABLE LIAISON
    private static String j07_liaison = "j07_liaison";

    private String J07_ID_LIAISON = "J07_ID_LIAISON";
    private String J07_ID_ETAGE_CURRENT = "J07_ID_ETAGE_CURRENT";
    private String J07_NUMERO_ETAGE_CURRENT= "J07_NUMERO_ETAGE_CURRENT";
    private String J07_ID_ETAGE= "J07_ID_ETAGE";
    private String J07_NUMERO_ETAGE= "J07_NUMERO_ETAGE";
    private String J07_POSITION_X= "J07_POSITION_X";
    private String J07_POSITION_Y= "J07_POSITION_Y";
    private String J07_TYPE= "J07_TYPE";

    // TABLE REPERE
    private static String j08_repere= "j08_repere";

    private String J08_ID_REPERE = "J08_ID_REPERE ";
    private String J08_ID_ETAGE = "J08_ID_ETAGE";
    private String J08_TYPE = "J08_ID_ETAGE";
    private String J08_POSITION_X= "J08_POSITION_X";
    private String J08_POSITION_Y= "J08_POSITION_Y";
    private String J08_DC = "J08_DC";
    private String J08_ID_DC = "J08_ID_DC";
    private String J08_DM = "J08_DM ";
    private String J08_ID_DM = "J08_ID_DM";



    public BaseDeDonnees(Context context){

        super(context, DATABASE_NAME, null, 1 );


    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db = this.getWritableDatabase();
        // CREATION DE LA TABLE USER
        db.execSQL("CREATE TABLE "+ j01_list_user +" (" +J01_ID_USER+ " INTEGER PRIMARY KEY, "
                                                    + J01_PROFIL + " TEXT , "+ J01_EMAIL + " TEXT, "+ J01_PASSWORD +
                                                         " TEXT, "+ J01_NOM +" TEXT, "+ J01_PRENOM +" TEXT, "+J01_DC+" TEXT, "+ J01_DM+" TEXT,"+J01_ID_DM+" INTEGER )");

        // CREATION DE LA TABLE CARTE
        db.execSQL("CREATE TABLE "+ j03_list_carte +" (" +J03_ID_CARTE+ " INTEGER PRIMARY KEY, "
                                                        + J03_PLACE_ID + " INTEGER , "+ J03_LATITUDE + " REAL, "+ J03_LONGITUDE +
                                                            " REAL, "+ J03_NOM +" TEXT, "+ J03_ADRESSE +" TEXT, "+ J03_CP+ " INTEGER, "+J03_DC+" TEXT, "
                                                            +J03_ID_UC +" INTEGER, "+ J03_DM+" TEXT, "+ J03_ID_DM+ " INTEGER )");
        // CREATION DE LA TABLE BLOC
        db.execSQL("CREATE TABLE "+ j04_bloc +" (" +J04_ID_BLOC+ " INTEGER PRIMARY KEY, "
                                                        + J04_ID_ETAGE + " INTEGER , "+ J04_TYPE + " TEXT, "+ J04_NOM +" TEXT, "+J04_DC+" TEXT, "
                                                            +J04_ID_DC +" INTEGER, "+ J03_DM+" TEXT, "+ J03_ID_DM+ " INTEGER )");

        // CREATION DE LA TABLE LIGNE
        db.execSQL("CREATE TABLE "+ j05_ligne +" (" +J05_ID_LINE+ " INTEGER PRIMARY KEY, "
                                                        + J05_ID_BLOC+ " INTEGER , "+ J05_Depart_X + " REAL, "+ J05_Depart_Y +
                                                            " REAL, "+ J05_Depart_Z +" REAL, "+ J05_Fin_X+" REAL, "+J05_Fin_Y +" REAL, "
                                                                + J05_Fin_Z +" REAL , "+ J05_Longueur +" REAL , "+ J05_Angle +" REAL)");

        // CREATION DE LA TABLE ETAGE
        db.execSQL("CREATE TABLE "+ j06_etage +" (" +J06_ID_ETAGE+ " INTEGER PRIMARY KEY, "
                                                        + J06_ID_CARTE + " INTEGER , "+ J06_NUMERO_ETAGE +
                                                            " INTEGER, "+J03_DC+" TEXT, " +J06_ID_DC +" INTEGER, "+ J06_DM+" TEXT, "+ J06_ID_DM+ " INTEGER )");

        // CREATION DE LA TABLE LIAISON
        db.execSQL("CREATE TABLE "+ j07_liaison +" (" +J07_ID_LIAISON+ " INTEGER PRIMARY KEY, "
                                                        + J07_ID_ETAGE_CURRENT + " INTEGER , "+ J07_NUMERO_ETAGE_CURRENT + " INTEGER, "+ J07_ID_ETAGE +
                                                            " INTEGER, "+ J07_NUMERO_ETAGE +" INTEGER, "+ J07_POSITION_X +" REAL, "+ J07_POSITION_Y+ " REAL, "+J07_TYPE+
                                                                " TEXT)");

        // CREATION DE LA TABLE REPERE
        db.execSQL("CREATE TABLE "+ j08_repere +" (" +J08_ID_REPERE+ " INTEGER PRIMARY KEY, "
                                                        + J08_ID_ETAGE + " INTEGER , "+ J08_TYPE + " TEXT, "+ J08_POSITION_X +
                                                            " REAL, "+ J08_POSITION_Y+" REAL, "+ J08_DC+" TEXT, "
                                                                +J08_ID_DC +" INTEGER, "+ J08_DM+" TEXT, "+ J08_ID_DM+ " INTEGER )");

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+ j01_list_user);
        db.execSQL("DROP TABLE IF EXISTS "+ j03_list_carte);
        db.execSQL("DROP TABLE IF EXISTS "+ j04_bloc);
        db.execSQL("DROP TABLE IF EXISTS "+ j05_ligne);
        db.execSQL("DROP TABLE IF EXISTS "+ j06_etage);
        db.execSQL("DROP TABLE IF EXISTS "+ j07_liaison);
        db.execSQL("DROP TABLE IF EXISTS "+ j08_repere);
        onCreate(db);
    }


    // INSERTION DES TABLES DANS LA BASE DE DONNEES



    public boolean insertCarte (int idCarte ,int placeId, float latitude, float longitude, String nom , String adresse, int cp, String dc, int id_uc, String dm, int id_dm){

        if (!isCarteExist(nom)) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues valeurs = new ContentValues();

            valeurs.put(J03_ID_CARTE, idCarte);
            valeurs.put(J03_PLACE_ID, placeId);
            valeurs.put(J03_LATITUDE, latitude);
            valeurs.put(J03_LONGITUDE, longitude);
            valeurs.put(J03_NOM, nom);
            valeurs.put(J03_ADRESSE, adresse);
            valeurs.put(J03_CP, cp);
            valeurs.put(J03_DC, dc);
            valeurs.put(J03_ID_UC, id_uc);
            valeurs.put(J03_DM, dm);
            valeurs.put(J03_ID_DM, id_dm);
            //db.insert(j03_list_carte, null, valeurs);

            long result = db.insert(j03_list_carte, "", valeurs);
            if (result == -1) {
                return false;
            } else return true;
        }
        else return false;
    }


    public boolean isCarteExist (String nom){
        Cursor res = this.getAllCarteByName(nom);
        if(res.getCount() ==0){
            return false;
        }
        else return true;
    }


    public boolean insertBloc (int idBloc, int idEtage, String type, String nom, String dc, int id_dc, String dm, int id_dm){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valeurs = new ContentValues();

        valeurs.put(J04_ID_BLOC, idBloc);
        valeurs.put(J04_ID_ETAGE, idEtage);
        valeurs.put(J04_TYPE, type);
        valeurs.put(J04_NOM, nom);
        valeurs.put(J04_DC, dc);
        valeurs.put(J04_ID_DC, id_dc);
        valeurs.put(J04_DM, dm);
        valeurs.put(J04_ID_DM, id_dm);

        long result = db.insert(j04_bloc,null, valeurs);
        if(result == -1){
            return false;
        }
        else return true;
    }

    public boolean insertLigne (int idLigne, int idBloc, float departX, float departY, float departZ, float finX, float finY, float finZ, float longueur, float angle){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valeurs = new ContentValues();

        valeurs.put(J05_ID_LINE, idLigne);
        valeurs.put(J05_ID_BLOC, idBloc);
        valeurs.put(J05_Depart_X, departX);
        valeurs.put(J05_Depart_Y, departY);
        valeurs.put(J05_Depart_Z, departZ);
        valeurs.put(J05_Fin_X, finX);
        valeurs.put(J05_Fin_Y, finY);
        valeurs.put(J05_Fin_Z, finZ);
        valeurs.put(J05_Longueur, longueur);
        valeurs.put(J05_Angle, angle);

        long result = db.insert(j05_ligne,null, valeurs);
        if(result == -1){
            return false;
        }
        else return true;
    }

    public boolean insertUser (int id_user, String profil, String email, String password, String nom, String prenom, String dc, String dm, int id_dm){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valeurs = new ContentValues();

        valeurs.put(J05_ID_LINE, id_user);
        valeurs.put(J05_ID_BLOC, profil);
        valeurs.put(J05_Depart_X, email);
        valeurs.put(J05_Depart_Y, password);
        valeurs.put(J05_Depart_Z, nom);
        valeurs.put(J05_Fin_X, prenom);
        valeurs.put(J05_Fin_Y, dc);
        valeurs.put(J05_Fin_Z, dm);
        valeurs.put(J05_Longueur, id_dm);

        long result = db.insert(j01_list_user,null, valeurs);
        if(result == -1){
            return false;
        }
        else return true;
    }

    public boolean insertEtage (int idEtage, int idCarte, int numeroEtage, String dc, int id_dc, String dm, int id_dm){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valeurs = new ContentValues();

        valeurs.put(J06_ID_ETAGE, idEtage);
        valeurs.put(J06_ID_CARTE, idCarte);
        valeurs.put(J06_NUMERO_ETAGE, numeroEtage);
        valeurs.put(J06_DC, dc);
        valeurs.put(J06_ID_DC, id_dc);
        valeurs.put(J06_DM, dm);
        valeurs.put(J06_ID_DM, id_dm);

        long result = db.insert(j06_etage,null, valeurs);
        if(result == -1){
            return false;
        }
        else return true;
    }

    public boolean insertLiaison (int idLiaison , int idEtageActuel, int numeroEtageActuel, int idEtage, int numeroEtage, float positionX , float positionY,String type){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valeurs = new ContentValues();

        valeurs.put(J07_ID_LIAISON, idLiaison);
        valeurs.put(J07_ID_ETAGE_CURRENT, idEtageActuel);
        valeurs.put(J07_NUMERO_ETAGE_CURRENT, numeroEtageActuel);
        valeurs.put(J07_ID_ETAGE, idEtage);
        valeurs.put(J07_NUMERO_ETAGE, numeroEtage);
        valeurs.put(J07_POSITION_X, positionX);
        valeurs.put(J07_POSITION_Y, positionY);
        valeurs.put(J07_TYPE, type);

        long result = db.insert(j07_liaison,null, valeurs);
        if(result == -1){
            return false;
        }
        else return true;
    }

    public boolean insertRepere (int idRepere, int idEtage, String type, float positionX, float positionY , String dc, int id_dc, String dm, int id_dm){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valeurs = new ContentValues();

        valeurs.put(J08_ID_REPERE, idRepere);
        valeurs.put(J08_ID_ETAGE, idEtage);
        valeurs.put(J08_TYPE, type);
        valeurs.put(J08_POSITION_X, positionX);
        valeurs.put(J08_POSITION_Y, positionY);
        valeurs.put(J08_DC, dc);
        valeurs.put(J08_ID_DC, id_dc);
        valeurs.put(J08_DM, dm);
        valeurs.put(J08_ID_DM, id_dm);

        long result = db.insert(j08_repere,null, valeurs);
        if(result == -1){
            return false;
        }
        else return true;
    }




    // RECUPERER TOUTES LES DONNEES D'UNE TABLE A PARTIR D'UN IDENTIFIANT




    public Cursor getAllBloc (int idCarte){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * from "+ j04_bloc+ ", "+ j06_etage +" WHERE "+J06_ID_CARTE+ " =" +idCarte+ " " +
                "AND "+ J04_ID_ETAGE+ " = " +J06_ID_ETAGE, null);
        return res;
    }
    public Cursor getAllLigne (int idCarte){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * from "+ j05_ligne+ ", "+ j04_bloc+", "+ j06_etage+" WHERE "+J06_ID_CARTE+" =" +idCarte+"" +
                                    " AND " + J04_ID_ETAGE+ " = " +J06_ID_ETAGE+" AND "+ J05_ID_BLOC+" = " +J05_ID_BLOC , null);
        return res;
    }
    public Cursor getAllCarte (){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * from "+ j03_list_carte, null);
        return res;
    }

    public Cursor getAllCarteByName (String name){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * from "+ j03_list_carte+ " WHERE "+J03_NOM+" =" +name, null);
        return res;
    }

    public Cursor getAllEtage (int idCarte){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * from "+ j06_etage+ " WHERE "+ J06_ID_CARTE+" =" +idCarte, null);
        return res;
    }

    public Cursor getAllRepere (int idCarte){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * from "+ j08_repere+ ", "+ j06_etage +" WHERE "+J06_ID_CARTE+ " =" +idCarte+ " " +
                "AND "+ J08_ID_ETAGE+ " = " +J06_ID_ETAGE, null);
        return res;
    }

    public Cursor getAllLiaison (int idCarte){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * from "+ j07_liaison+ ", "+ j06_etage+" WHERE "+J06_ID_CARTE+" =" +idCarte+"" +
                "                    AND " + J06_ID_ETAGE +" = " +J07_ID_ETAGE_CURRENT, null);
        return res;
    }




    // RECUPERER TOUTES LES DONNEES D'UNE TABLE SOUS FORME DE LISTE A PARTIR DE L'IDENTIFIANT





    public ArrayList<Carte> getListeCarte(){
        listeCarte = new ArrayList<>();
        Cursor res = this.getAllCarte();
        if(res.getCount() ==0){
            return null;
        }
        else {
            if (res.moveToFirst()){
                do {
                    Carte carte = new Carte(res.getInt(0),res.getInt(1), res.getFloat(2), res.getFloat(3), res.getString(4), res.getString(5), res.getInt(6),res.getString(7), res.getInt(8), res.getString(9), res.getInt(10));
                    listeCarte.add(carte);
                } while (res.moveToNext());
            }
            return listeCarte;
        }

    }

    public ArrayList<Bloc> getListeBloc(int id){
        listeBloc = new ArrayList<>();
        Cursor res = this.getAllBloc(id);
        if(res.getCount() ==0){
            return null;
        }
        else {
            if (res.moveToFirst()){
                do {
                    Bloc bloc = new Bloc(res.getInt(0),res.getInt(1), res.getString(2), res.getString(3), res.getString(4),res.getInt(5), res.getString(6), res.getInt(7));
                    listeBloc.add(bloc);
                } while (res.moveToNext());
            }
            return listeBloc;
        }

    }


    public ArrayList<Ligne> getListeLigne(int id){
        listeLigne = new ArrayList<>();
        Cursor res = this.getAllLigne(id);
        if(res.getCount() ==0){
            return null;
        }
        else {
            if (res.moveToFirst()){
                do {
                    Ligne ligne = new Ligne(res.getInt(0), res.getInt(1), res.getFloat(2), res.getFloat(3), res.getFloat(4), res.getFloat(5), res.getFloat(6), res.getFloat(7), res.getFloat(8), res.getFloat(9));
                    listeLigne.add(ligne);
                } while (res.moveToNext());
            }
            return listeLigne;
        }
    }

    public ArrayList<Etage> getListeEtage(int id){
        listeEtage = new ArrayList<>();
        Cursor res = this.getAllEtage(id);
        if(res.getCount() ==0){
            return null;
        }
        else {
            if (res.moveToFirst()){
                do {
                    Etage etage = new Etage(res.getInt(0), res.getInt(1), res.getInt(2), res.getString(3), res.getInt(4), res.getString(5), res.getInt(6));
                    listeEtage.add(etage);
                } while (res.moveToNext());
            }
            return listeEtage;
        }
    }

    public ArrayList<Repere> getListeRepere(int id){
        listeRepere = new ArrayList<>();
        Cursor res = this.getAllRepere(id);
        if(res.getCount() ==0){
            return null;
        }
        else {
            if (res.moveToFirst()){
                do {
                    Repere repere = new Repere(res.getInt(0), res.getInt(1), res.getString(2), res.getFloat(3), res.getFloat(4), res.getString(5), res.getInt(6), res.getString(7), res.getInt(8));
                    listeRepere.add(repere);
                } while (res.moveToNext());
            }
            return listeRepere;
        }
    }

    public ArrayList<Liaison> getListeLiaison(int id){
        listeLiaison = new ArrayList<>();
        Cursor res = this.getAllLiaison(id);
        if(res.getCount() ==0){
            return null;
        }
        else {
            if (res.moveToFirst()){
                do {
                    Liaison liaison = new Liaison (res.getInt(0), res.getInt(1), res.getInt(2), res.getInt(3), res.getInt(4), res.getFloat(5), res.getFloat(6), res.getString(7));
                    listeLiaison.add(liaison);
                } while (res.moveToNext());
            }
            return listeLiaison;
        }
    }


    public boolean supprimerCarte(int idCarte){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valeurs = new ContentValues();

        long result = db.delete(j03_list_carte,J03_ID_CARTE + " = " +idCarte,null);

        // RENTRER DANS CETE METHODE TUES LES METHODES DELETE DES AUTRES TABLES


        if(result == 0){
            return false;
        }
        else return true;

    }


    // Méthode permettant de récupérer le nombre d'étage par bâtiment

    public int getCarteNbEtage(int idcarte){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * from "+ j06_etage+ " WHERE "+J06_ID_CARTE+" =" +idcarte, null);
        return res.getCount();
    }

}

