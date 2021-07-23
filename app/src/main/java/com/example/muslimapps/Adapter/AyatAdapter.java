package com.example.muslimapps.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codesgood.views.JustifiedTextView;
import com.example.muslimapps.AyatActivity;
import com.example.muslimapps.Model.Ayat;
import com.example.muslimapps.Model.Surat;
import com.example.muslimapps.R;

import java.util.List;
import java.util.Objects;

public class AyatAdapter extends RecyclerView.Adapter<AyatAdapter.AyatViewHolder> {

    private final Context context;
    private final List<Ayat> ayats;

    public AyatAdapter(Context context, List<Ayat> ayats) {
        this.context = context;
        this.ayats = ayats;

    }


    @NonNull
    @Override
    public AyatAdapter.AyatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ayat, parent, false);
        return new AyatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AyatAdapter.AyatViewHolder holder, final int position) {
        holder.txtNomor.setText(ayats.get(position).getNomor());
        holder.txtArabic.setText(ayats.get(position).getAr());
        holder.txtTranslation.setText(ayats.get(position).getId());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, ayats.get(position).getNomor());
                intent.putExtra(Intent.EXTRA_TEXT, ayats.get(position).getAr());
                intent.putExtra(Intent.EXTRA_TEXT, ayats.get(position).getId());
                intent.setPackage("com.whatsapp");
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return ayats.size();
    }

    public class AyatViewHolder extends RecyclerView.ViewHolder {

        TextView txtNomor, txtArabic;
        JustifiedTextView txtTranslation;

        public AyatViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNomor = itemView.findViewById(R.id.txtNomor);
            txtArabic = itemView.findViewById(R.id.txtArabic);
            txtTranslation = itemView.findViewById(R.id.txtTranslation);

        }
    }
}
