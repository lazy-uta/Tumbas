package com.dicodingtraining.tumbas.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dicodingtraining.tumbas.BasicActivity.RestoActivity;
import com.dicodingtraining.tumbas.Model.Angkringans;
import com.dicodingtraining.tumbas.Model.Noodels;
import com.dicodingtraining.tumbas.R;
import com.dicodingtraining.tumbas.Resto.Activity.AngkringanPakMan;
import com.dicodingtraining.tumbas.Resto.Activity.Gacoan;
import com.dicodingtraining.tumbas.Resto.Activity.MieNyinyir;

import java.util.ArrayList;

public class ThreeAdapter extends RecyclerView.Adapter<ThreeAdapter.ThreeViewHolder> {

    private ArrayList<Angkringans> angkringanslist;

    public ThreeAdapter(ArrayList<Angkringans> angkringanslist){
        this.angkringanslist = angkringanslist;
    }

    @NonNull
    @Override
    public ThreeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_recyclerview_menu, viewGroup, false);
        return new ThreeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final  ThreeViewHolder holder, final int position) {
        final Angkringans angkringans = angkringanslist.get(position);

        Glide.with(holder.itemView.getContext())
                .load(angkringans.getPhoto())
                .apply(new RequestOptions().override(350,350))
                .into(holder.imgPhoto);
        holder.tvNama.setText(angkringans.getNama());
        holder.tvHarga.setText(angkringans.getDesc());

        holder.imgPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               Intent intent = new Intent(holder.imgPhoto.getContext(), AngkringanPakMan.class);
               holder.imgPhoto.getContext().startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return angkringanslist.size();
    }

    public class ThreeViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvHarga;
        ImageView imgPhoto;
        public ThreeViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.imageHomeFood);
            tvNama = itemView.findViewById(R.id.TittleHomeFood);
            tvHarga = itemView.findViewById(R.id.DesHomeMenu);

        }
    }
}
