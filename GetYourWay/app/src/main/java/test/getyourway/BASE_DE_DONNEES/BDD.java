package test.getyourway.BASE_DE_DONNEES;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import test.getyourway.MODELE.Bloc;
import test.getyourway.MODELE.Carte;
import test.getyourway.MODELE.Ligne;

/**
 * Created by Sénthène on 19/03/2017.
 */

public class BDD extends SQLiteOpenHelper{

    private static String DATABASE_NAME = "BD_GET_YOUR_WAY.db";
    private int DATABASE_VERSION = 1;
    private ArrayList<Carte> listeCarte;
    private ArrayList<Bloc> listeBloc;
    private ArrayList<Ligne> listeLigne;

    // TABLE CARTE
    private static String j03_carte = "j03_carte";

    private static String J03_IdCarte = "J03_IdCarte";
    private String J03_Nom = "J03_Nom";
    private String J03_Adresse = "J03_Adresse";
    private String J03_CP = "J03_CP";
    private String J03_Email = "J03_Email";
    private String J03_Etage = "J03_Etage";

    // TABLE BLOC
    private static String j04_bloc = "j04_bloc";

    private static String J04_IdBloc = "J04_IdBloc";
    private String J04_Type = "J04_Type";
    private String J04_Nom = "J04_Nom";
    private String J04_IdCarte = "J04_IdCarte";

    // TABLE LIGNE
    private static String j05_ligne= "j05_ligne";

    private static String J05_IdLigne = "J05_IdLigne ";
    private String J05_IdCarte = "J05_IdCarte";
    private String J05_Depart_X = "J05_Depart_X";
    private String J05_Depart_Y = "J05_Depart_Y";
    private String J05_Depart_Z = "J05_Depart_Z";
    private String J05_Fin_X = "J05_Fin_X ";
    private String J05_Fin_Y = "J05_Fin_Y";
    private String J05_Fin_Z = "J05_Fin_Z";
    private String J05_Longueur = "J05_Longueur";
    private String J05_Angle = "J05_Angle";


    public BDD (Context context){

        super(context, DATABASE_NAME, null, 1 );


    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        // CREATION DE LA TABLE CARTE
        db.execSQL("CREATE TABLE "+ j03_carte +" (" +J03_IdCarte+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
                                                        + J03_Nom + " TEXT , "+ J03_Adresse + " TEXT, "+ J03_CP +
                                                            " INTEGER, "+ J03_Email +" TEXT, "+ J03_Etage +" INTEGER)");
        // CREATION DE LA TABLE BLOC
        db.execSQL("CREATE TABLE "+ j04_bloc +" (" +J04_IdBloc+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
                                                         + J04_Type+ " TEXT , "+ J04_Nom  + " TEXT,  "+ J04_IdCarte  +" INTEGER)");

        // CREATION DE LA TABLE LIGNE
        db.execSQL("CREATE TABLE "+ j05_ligne +" (" +J05_IdLigne+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
                                                        + J05_IdCarte+ " INTEGER , "+ J05_Depart_X + " INTEGER, "+ J05_Depart_Y +
                                                            " INTEGER, "+ J05_Depart_Z +" INTEGER, "+ J05_Fin_X+" INTEGER, "+J05_Fin_Y +" INTEGER, "
                                                                + J05_Fin_Z +" INTEGER , "+ J05_Longueur +" INTEGER , "+ J05_Angle +" INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+ j03_carte );
        db.execSQL("DROP TABLE IF EXISTS "+ j04_bloc );
        db.execSQL("DROP TABLE IF EXISTS "+ j05_ligne );
        onCreate(db);
    }

    public boolean insertCarte (String n, String a, int cp, String e, int etage){

        if (!isCarteExist(n)) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues valeurs = new ContentValues();

            valeurs.put(J03_Nom, n);
            valeurs.put(J03_Adresse, a);
            valeurs.put(J03_CP, cp);
            valeurs.put(J03_Email, e);
            valeurs.put(J03_Etage, etage);

            long result = db.insert(j03_carte, null, valeurs);
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
    public boolean insertBloc (String t, String n, int id){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valeurs = new ContentValues();

        valeurs.put(J04_Type, t);
        valeurs.put(J04_Nom, n);
        valeurs.put(J04_IdCarte, id);

        long result = db.insert(j04_bloc,null, valeurs);
        if(result == -1){
            return false;
        }
        else return true;
    }

    public void insertLigne (int id, int dx, int dy, int dz, int fx, int fy, int fz, int l, int a){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valeurs = new ContentValues();

        valeurs.put(J05_IdCarte, id);
        valeurs.put(J05_Depart_X, dx);
        valeurs.put(J05_Depart_Y, dy);
        valeurs.put(J05_Depart_Z, dz);
        valeurs.put(J05_Fin_X, fx);
        valeurs.put(J05_Fin_Y, fy);
        valeurs.put(J05_Fin_Z, fz);
        valeurs.put(J05_Longueur, l);
        valeurs.put(J05_Angle, a);

        db.insert(j05_ligne,null, valeurs);
    }

    public Cursor getAllBloc (int id){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * from "+ j04_bloc+ " WHERE "+J04_IdCarte+" =" +id, null);
        return res;
    }
    public Cursor getAllLigne (int id){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * from "+ j05_ligne+ " WHERE "+J05_IdCarte+" =" +id, null);
        return res;
    }
    public Cursor getAllCarte (int id){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * from "+ j03_carte+ " WHERE "+J03_IdCarte+" =" +id, null);
        return res;
    }

    public Cursor getAllCarteByName (String name){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * from "+ j03_carte+ " WHERE "+J03_Nom+" =" +name, null);
        return res;
    }

    public ArrayList<Carte> getListeCarte(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = this.getAllCarte(id);
        if(res.getCount() ==0){
            return null;
        }
        else {
            String requete = "SELECT * from " + j03_carte + " WHERE " + J03_IdCarte + " = " + id;
            Cursor c = db.rawQuery(requete, null);
            if (c.moveToFirst()){
                do {
                    Carte carte = new Carte(c.getString(1), c.getString(2), c.getInt(3), c.getString(4), c.getInt(5));
                    listeCarte.add(carte);
                } while (c.moveToNext());
            }
            return listeCarte;
        }

    }

    public ArrayList<Bloc> getListeBloc(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = this.getAllBloc(id);
        if(res.getCount() ==0){
            return null;
        }
        else {
            String requete = "SELECT * from " + j04_bloc + " WHERE " + J04_IdCarte + " = " + id;
            Cursor c = db.rawQuery(requete, null);
            if (c.moveToFirst()){
                do {
                    Bloc bloc = new Bloc(c.getString(1), c.getString(2), c.getInt(3));
                    listeBloc.add(bloc);
                } while (c.moveToNext());
            }
            return listeBloc;
        }

    }

    public ArrayList<Ligne> getListeLigne(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = this.getAllCarte(id);
        if(res.getCount() ==0){
            return null;
        }
        else {
            String requete = "SELECT * from " + j05_ligne + " WHERE " + J05_IdCarte + " = " + id;
            Cursor c = db.rawQuery(requete, null);
            if (c.moveToFirst()){
                do {
                    Ligne ligne = new Ligne(c.getInt(1), c.getInt(2), c.getInt(3), c.getInt(4), c.getInt(5), c.getInt(6), c.getInt(7), c.getInt(8), c.getInt(9));
                    listeLigne.add(ligne);
                } while (c.moveToNext());
            }
            return listeLigne;
        }
    }
}

