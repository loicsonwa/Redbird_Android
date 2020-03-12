package com.example.spacetablayout.catalogue_manager;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.spacetablayout.R;
import com.example.spacetablayout.TestList;
import com.example.spacetablayout.main_fragments.Fragment_C;

import java.util.List;

public class CatalogueAdapter extends RecyclerView.Adapter<CatalogueAdapter.MyViewHolder> {
    private List<CatalogueModel> catalogue;
    private Context context;
    public interface onItemClickListener {
        void onItemClick( int position);
    }
    private onItemClickListener mListener;

    public void setOnItemClickListener(onItemClickListener listener){
        mListener = listener;

    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private ImageView image;


        public MyViewHolder(@NonNull View itemView, final onItemClickListener listener) {
            super(itemView);

            // Initialisation des vues

            name = itemView.findViewById(R.id.nameDrink);
            image = itemView.findViewById(R.id.imageDrink);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                if(listener != null){
                    int position = getAdapterPosition();
                    if(position !=RecyclerView.NO_POSITION){
                        listener.onItemClick(position);
                    }
                }
                }
            });

        }

    }

    /**
     * Variables & Constructeur
     **/
    public CatalogueAdapter(Context context, List<CatalogueModel> catalogue ){
        this.context = context;
        this.catalogue = catalogue;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.catague_cards,parent,false);
        return new MyViewHolder(itemView, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final CatalogueModel model = catalogue.get(position);
        holder.name.setText(model.getName());

        Glide.with(context).load(model.getImage()).into(holder.image);
        // Autre methode de click
       /*holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, model.getName(), Toast.LENGTH_SHORT).show();
            }
        });*/

      // Cette methode ne retourne qu'une seule et même activité sur chaque click
      /*holder.setItemClickListener(new ItemClickListener() {
          @Override
          public void onItemClickListener(View v, int position) {
              Intent intent = new Intent(context, TestList.class);
              context.startActivity(intent);
          }
      });*/

      //Cette methode retourne differentes activités sur differents click
        /*holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {

                // Action sur l'item
                if(catalogue.get(position).getName().equals("Eau Minerale")){
                    // Activité
                }
                // Action sur l'item
                if(catalogue.get(position).getName().equals("Beers")){
                    // Activité
                }
                // Action sur l'item
                if(catalogue.get(position).getName().equals("Beers")){
                    // Activité
                }
                // Action sur l'item
                if(catalogue.get(position).getName().equals("Beers")){
                    // Activité
                }
                // Action sur l'item
                if(catalogue.get(position).getName().equals("Beers")){
                    // Activité
                }
                // Action sur l'item
                if(catalogue.get(position).getName().equals("Beers")){
                    // Activité
                }
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return catalogue.size();
    }
}
