package com.example.muslimapps.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codesgood.views.JustifiedTextView;
import com.example.muslimapps.Model.Tahlil;
import com.example.muslimapps.R;

import java.util.List;

public class TahlilAdapter extends RecyclerView.Adapter<TahlilAdapter.TahlilViewHolder> {

    private final List<Tahlil> tahlils;

    public TahlilAdapter(List<Tahlil> tahlils) {
        this.tahlils = tahlils;
    }


    @NonNull
    @Override
    public TahlilAdapter.TahlilViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tahlil, parent, false);
        return new TahlilViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TahlilAdapter.TahlilViewHolder holder, int position) {
        holder.txtNomor.setText(tahlils.get(position).getId());
        holder.txtTitle.setText(tahlils.get(position).getTitle());
        holder.txtArabic.setText(tahlils.get(position).getArabic());
        holder.txtTranslation.setText(tahlils.get(position).getTranslation());
    }

    @Override
    public int getItemCount() {
        return tahlils.size();
    }

    public class TahlilViewHolder extends RecyclerView.ViewHolder {

        TextView txtNomor, txtTitle, txtArabic;
        JustifiedTextView txtTranslation;

        public TahlilViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNomor = itemView.findViewById(R.id.txtNomor);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtArabic = itemView.findViewById(R.id.txtArabic);
            txtTranslation = itemView.findViewById(R.id.txtTranslation);
        }
    }
}
