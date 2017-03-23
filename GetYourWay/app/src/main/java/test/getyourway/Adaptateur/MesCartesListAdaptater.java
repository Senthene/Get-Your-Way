package test.getyourway.Adaptateur;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import test.getyourway.MODELE.Carte;
import test.getyourway.R;


/**
 * Created by Sénthène on 21/03/2017.
 */

public class MesCartesListAdaptater extends BaseAdapter {

    private Context context;
    private ArrayList<Carte> mesCartes;

    public MesCartesListAdaptater (Context context, ArrayList<Carte> mesCartes){

        this.context = context;
        this.mesCartes = mesCartes;
    }


    @Override
    public int getCount() {
        return mesCartes.size();
    }

    @Override
    public Object getItem(int position) {
        return mesCartes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {
        View v = View.inflate(context, R.layout.ligne_mes_cartes,null);
        TextView nomCarte = (TextView) v.findViewById(R.id.Nom_MesCarte);
        TextView adresseCarte = (TextView) v.findViewById(R.id.Adresse_MesCarte);
        TextView etageCarte = (TextView) v.findViewById(R.id.Etage_MesCarte);
        Button supprimer = (Button) v.findViewById(R.id.supprimer);


        nomCarte.setText(mesCartes.get(position).getNom());
        adresseCarte.setText(mesCartes.get(position).getAdresse());
        etageCarte.setText(String.valueOf(mesCartes.get(position).getEtage())+ " étages");
        supprimer.setOnClickListener(

                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        AlertDialog.Builder popupSuppression = new AlertDialog.Builder(context);
                        popupSuppression.setMessage("Etes-vous sûr de vouloir supprimer la carte du batîment "+ mesCartes.get(position).getNom());
                        popupSuppression.setPositiveButton("Oui", new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int which) {
                                        Toast.makeText(context, "Carte " + mesCartes.get(position).getId()+" supprimé", Toast.LENGTH_SHORT).show();
                                    }
                        });
                        popupSuppression.setNegativeButton("Non",null);

                        AlertDialog alert = popupSuppression.create();
                        alert.show();

                    }
                }
        );
        Button misajour = (Button) v.findViewById(R.id.misaJour);
        misajour.setOnClickListener(

                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Toast.makeText(context, "Mise à jour de la carte "+ mesCartes.get(position).getId(), Toast.LENGTH_SHORT).show();

                    }
                }
        );
        v.setTag(mesCartes.get(position).getId());
        return v;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return mesCartes.size();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }
}
