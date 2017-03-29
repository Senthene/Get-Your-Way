package test.getyourway.Adaptateur;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import test.getyourway.BASE_DE_DONNEES.BaseDeDonnees;
import test.getyourway.MODELE.Carte;
import test.getyourway.R;

/**
 * Created by Sénthène on 20/03/2017.
 */

public class CarteListAdaptater extends BaseAdapter {

    private Context context;
    private ArrayList<Carte> listeCarte;

    public CarteListAdaptater (Context context, ArrayList<Carte> listeCarte){

        this.context = context;
        this.listeCarte = listeCarte;
    }
    @Override
    public int getCount() {
        return listeCarte.size();
    }

    @Override
    public Object getItem(int position) {
        return listeCarte.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View v = View.inflate(context, R.layout.ligne_liste_carte,null);
        TextView nomCarte = (TextView) v.findViewById(R.id.Nom_Carte);
        TextView adresseCarte = (TextView) v.findViewById(R.id.Adresse_Carte);
        TextView etageCarte = (TextView) v.findViewById(R.id.Etage_Carte);
        Button telecharger = (Button) v.findViewById(R.id.telecharger);
        BaseDeDonnees temp = new BaseDeDonnees(context);


        nomCarte.setText(listeCarte.get(position).getNom());
        adresseCarte.setText(listeCarte.get(position).getAdresse());
       // etageCarte.setText(String.valueOf(temp.getCarteNbEtage(listeCarte.get(position).getIdCarte()))+ " étages");
        telecharger.setOnClickListener(

                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Toast.makeText(context, "Carte sélectionnée dont l'id est " + listeCarte.get(position).getIdCarte(), Toast.LENGTH_SHORT).show();

                    }
                }
        );
        v.setTag(listeCarte.get(position).getIdCarte());
        return v;
    }
}
