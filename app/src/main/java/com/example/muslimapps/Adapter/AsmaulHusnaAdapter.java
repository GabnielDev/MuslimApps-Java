package com.example.muslimapps.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.muslimapps.Model.AsmaulHusna;
import com.example.muslimapps.R;

import java.util.List;

public class AsmaulHusnaAdapter extends RecyclerView.Adapter<AsmaulHusnaAdapter.AsmaulHusnaViewHolder> {

    private final List<AsmaulHusna> asmaulHusnas;

    public AsmaulHusnaAdapter(List<AsmaulHusna> asmaulHusnas) {
        this.asmaulHusnas = asmaulHusnas;
    }

    @NonNull
    @Override
    public AsmaulHusnaAdapter.AsmaulHusnaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_asmaulhusna, parent, false);
        return new AsmaulHusnaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AsmaulHusnaAdapter.AsmaulHusnaViewHolder holder, int position) {
        holder.txtIndex.setText(asmaulHusnas.get(position).getIndex());
        holder.txtLatin.setText(asmaulHusnas.get(position).getLatin());
        holder.txtArabic.setText(asmaulHusnas.get(position).getArabic());
        holder.txtTranslation.setText(asmaulHusnas.get(position).getTranslation_id());
    }

    @Override
    public int getItemCount() {
        return asmaulHusnas.size();
    }

    public class AsmaulHusnaViewHolder extends RecyclerView.ViewHolder {

        TextView txtIndex, txtLatin, txtArabic, txtTranslation;

        public AsmaulHusnaViewHolder(@NonNull View itemView) {
            super(itemView);

            txtIndex = itemView.findViewById(R.id.txtIndex);
            txtLatin = itemView.findViewById(R.id.txtLatin);
            txtArabic = itemView.findViewById(R.id.txtArabic);
            txtTranslation = itemView.findViewById(R.id.txtTranslation);

        }
    }
}
