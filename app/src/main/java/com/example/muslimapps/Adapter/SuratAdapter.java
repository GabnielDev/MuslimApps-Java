package com.example.muslimapps.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.muslimapps.AyatActivity;
import com.example.muslimapps.Model.Surat;
import com.example.muslimapps.R;

import java.util.List;

public class SuratAdapter extends RecyclerView.Adapter<SuratAdapter.SuratViewHolder> {

    private final Context context;
    private final List<Surat> surats;

    public SuratAdapter(Context context, List<Surat> surats) {
        this.context = context;
        this.surats = surats;
    }

    @NonNull
    @Override
    public SuratAdapter.SuratViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_surat, parent, false);
        return new SuratViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SuratAdapter.SuratViewHolder holder, final int position) {
        holder.txtNomor.setText(surats.get(position).getNomor());
        holder.txtAyat.setText(surats.get(position).getAyat());
        holder.txtInfo.setText(surats.get(position).getArti());
        holder.txtName.setText(surats.get(position).getNama());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AyatActivity.class);
                intent.putExtra(AyatActivity.EXTRA_NO, surats.get(position).getNomor());
//                intent.putExtra("path", surats.get(position).getNomor());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return surats.size();
    }

    public class SuratViewHolder extends RecyclerView.ViewHolder {

        TextView txtNomor, txtAyat, txtInfo, txtName;


        public SuratViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNomor = itemView.findViewById(R.id.txtNomor);
            txtAyat = itemView.findViewById(R.id.txtAyat);
            txtInfo = itemView.findViewById(R.id.txtInfo);
            txtName = itemView.findViewById(R.id.txtName);

        }
    }
}
