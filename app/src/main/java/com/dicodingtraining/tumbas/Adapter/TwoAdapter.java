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
import com.dicodingtraining.tumbas.Model.Meals;
import com.dicodingtraining.tumbas.Model.Noodels;
import com.dicodingtraining.tumbas.R;
import com.dicodingtraining.tumbas.Resto.Activity.AyamGepuk;
import com.dicodingtraining.tumbas.Resto.Activity.ChickenCrush;
import com.dicodingtraining.tumbas.Resto.Activity.Gacoan;
import com.dicodingtraining.tumbas.Resto.Activity.MieNyinyir;

import java.util.ArrayList;

public class TwoAdapter extends RecyclerView.Adapter<TwoAdapter.TwoViewHolder> {
    private ArrayList<Noodels> noodelslist;

    public TwoAdapter(ArrayList<Noodels> noodelslist){
        this.noodelslist = noodelslist;
    }


    @NonNull
    @Override
    public TwoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_recyclerview_menu, viewGroup, false);
        return new TwoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final TwoViewHolder holder, final int position) {

        final Noodels noodels = noodelslist.get(position);

        Glide.with(holder.itemView.getContext())
                .load(noodels.getPhoto())
                .apply(new RequestOptions().override(350,350))
                .into(holder.imgPhoto);
        holder.tvNama.setText(noodels.getNama());
        holder.tvHarga.setText(noodels.getDesc());

        holder.imgPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (position){
                    case 0:
                        Intent intent = new Intent(holder.imgPhoto.getContext(), Gacoan.class);
                        holder.imgPhoto.getContext().startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(holder.imgPhoto.getContext(), MieNyinyir.class);
                        holder.imgPhoto.getContext().startActivity(intent1);
                        break;

                    default:Intent intent2 = new Intent(holder.imgPhoto.getContext(), Gacoan.class);
                        holder.imgPhoto.getContext().startActivity(intent2);
                        break;
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return noodelslist.size();
    }

    public class TwoViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvHarga;
        ImageView imgPhoto;

        public TwoViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.imageHomeFood);
            tvNama = itemView.findViewById(R.id.TittleHomeFood);
            tvHarga = itemView.findViewById(R.id.DesHomeMenu);

        }
    }
}
