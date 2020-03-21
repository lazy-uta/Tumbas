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
import com.dicodingtraining.tumbas.Model.Koreans;
import com.dicodingtraining.tumbas.Model.Noodels;
import com.dicodingtraining.tumbas.R;
import com.dicodingtraining.tumbas.Resto.Activity.AyamGepuk;
import com.dicodingtraining.tumbas.Resto.Activity.ChickenCrush;
import com.dicodingtraining.tumbas.Resto.Activity.Kimchi;

import java.util.ArrayList;

public class FourAdapter extends RecyclerView.Adapter<FourAdapter.FourViewHolder> {

    private ArrayList<Koreans> koreanslist;

    public FourAdapter(ArrayList<Koreans> koreanslist){
        this.koreanslist = koreanslist;
    }

    @NonNull
    @Override
    public FourViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_recyclerview_menu, viewGroup, false);
        return new FourViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final FourViewHolder holder, final int position) {

        final Koreans koreans = koreanslist.get(position);

        Glide.with(holder.itemView.getContext())
                .load(koreans.getPhoto())
                .apply(new RequestOptions().override(350,350))
                .into(holder.imgPhoto);
        holder.tvNama.setText(koreans.getNama());
        holder.tvHarga.setText(koreans.getDesc());

        holder.imgPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.imgPhoto.getContext(), Kimchi.class);
                holder.imgPhoto.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return koreanslist.size();
    }



    public class FourViewHolder extends RecyclerView.ViewHolder {

        TextView tvNama, tvHarga;
        ImageView imgPhoto;

        public FourViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.imageHomeFood);
            tvNama = itemView.findViewById(R.id.TittleHomeFood);
            tvHarga = itemView.findViewById(R.id.DesHomeMenu);
        }
    }
}
