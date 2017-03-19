package test.getyourway.BASE_DE_DONNEES;

import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Context;
/**
 * Created by Sénthène on 19/03/2017.
 */

public class BDD extends SQLiteOpenHelper{

    private static String DATABASE_NAME = "BD_GET_YOUR_WAY.db";
    private int DATABASE_VERSION = 1;

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
        SQLiteDatabase db = this.getWritableDatabase();

    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        // TABLE CARTE
        db.execSQL("CREATE TABLE "+ j03_carte +" (" +J03_IdCarte+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
                                                        + J03_Nom + " TEXT , "+ J03_Adresse + " TEXT, "+ J03_CP +
                                                            " INTEGER, "+ J03_Email +" TEXT, "+ J03_Etage +" INTEGER)");
        // TABLE BLOC
        db.execSQL("CREATE TABLE "+ j04_bloc +" (" +J04_IdBloc+ " INTEGER PRIMARY KEY AUTOINCREMENT, "
                                                         + J04_Type+ " TEXT , "+ J04_Nom  + " TEXT,  "+ J04_IdCarte  +" INTEGER)");

        // TABLE LIGNE
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
}
