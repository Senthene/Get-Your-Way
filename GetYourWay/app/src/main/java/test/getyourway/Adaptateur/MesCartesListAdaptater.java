package test.getyourway.Adaptateur;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import test.getyourway.BASE_DE_DONNEES.BDD;
import test.getyourway.MODELE.Carte;
import test.getyourway.R;


/**
 * Created by Sénthène on 21/03/2017.
 */

public class MesCartesListAdaptater extends BaseAdapter {

    private Context context;
    private ArrayList<Carte> mesCartes;
    BDD temp;

    public MesCartesListAdaptater(Context context, ArrayList<Carte> mesCartes) {

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
        View v = View.inflate(context, R.layout.ligne_mes_cartes, null);
        TextView nomCarte = (TextView) v.findViewById(R.id.Nom_MesCarte);
        TextView adresseCarte = (TextView) v.findViewById(R.id.Adresse_MesCarte);
        TextView etageCarte = (TextView) v.findViewById(R.id.Etage_MesCarte);
        Button supprimer = (Button) v.findViewById(R.id.supprimer);
        temp = new BDD(context);


        nomCarte.setText(mesCartes.get(position).getNom());
        adresseCarte.setText(mesCartes.get(position).getAdresse());
        etageCarte.setText(String.valueOf(temp.getCarteNbEtage(mesCartes.get(position).getIdCarte())) + " étages");
        supprimer.setOnClickListener(

                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


// PLACER L'ALERTE DANS UNE METHODE APART ET L'APPLER DANS l'ACTIVITE UTILISER


                        // AlertDialog.Builder popupSuppression = new AlertDialog.Builder(context);
                        //popupSuppression.setMessage("Etes-vous sûr de vouloir supprimer la carte du batîment "+ mesCartes.get(position).getNom());
                        //popupSuppression.setPositiveButton("Oui", new DialogInterface.OnClickListener() {

                        //   public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context, "Carte " + mesCartes.get(position).getIdCarte() + " supprimé", Toast.LENGTH_SHORT).show();
                        // }
                        //});
                        //popupSuppression.setNegativeButton("Non",null);

                        //AlertDialog alert = popupSuppression.create();
                        //alert.show();

                    }
                }
        );
        Button misajour = (Button) v.findViewById(R.id.misaJour);
        misajour.setOnClickListener(

                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Toast.makeText(context, "Mise à jour de la carte " + mesCartes.get(position).getIdCarte(), Toast.LENGTH_SHORT).show();

                    }
                }
        );
        v.setTag(mesCartes.get(position).getIdCarte());
        return v;
    }
}
