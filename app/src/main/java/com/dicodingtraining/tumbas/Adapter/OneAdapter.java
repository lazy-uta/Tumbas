package com.dicodingtraining.tumbas.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dicodingtraining.tumbas.BasicActivity.CategoryActivity;
import com.dicodingtraining.tumbas.BasicActivity.RestoActivity;
import com.dicodingtraining.tumbas.Model.Meals;
import com.dicodingtraining.tumbas.R;
import com.dicodingtraining.tumbas.Resto.Activity.AyamGepuk;
import com.dicodingtraining.tumbas.Resto.Activity.ChickenCrush;
import com.google.android.gms.common.data.DataHolder;

import java.util.ArrayList;

public class OneAdapter extends RecyclerView.Adapter<OneAdapter.OneViewHolder> {
    private ArrayList<Meals> listMeals;

    public OneAdapter(ArrayList<Meals> list){
        this.listMeals = list;
    }


    @Override
    public OneViewHolder onCreateViewHolder(@NonNull  ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_recyclerview_menu, viewGroup, false);
        return new OneViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final OneViewHolder holder,final int position) {

        final Meals meals = listMeals.get(position);

        Glide.with(holder.itemView.getContext())
                .load(meals.getPhoto())
                .apply(new RequestOptions().override(350,350))
                .into(holder.imgPhoto);
        holder.tvNama.setText(meals.getNama());
        holder.tvHarga.setText(meals.getHarga());

        holder.imgPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (position){
                    case 0:
                        Intent intent = new Intent(holder.imgPhoto.getContext(),AyamGepuk.class);
                        holder.imgPhoto.getContext().startActivity(intent);
                        break;
                    case 2:
                        Intent intent1 = new Intent(holder.imgPhoto.getContext(), ChickenCrush.class);
                        holder.imgPhoto.getContext().startActivity(intent1);
                        break;

                        default:Intent intent2 = new Intent(holder.imgPhoto.getContext(), AyamGepuk.class);
                        holder.imgPhoto.getContext().startActivity(intent2);
                        break;
                }




            }
        });


    }

    @Override
    public int getItemCount() {
        return listMeals.size();
    }

    public class OneViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvHarga;
        ImageView imgPhoto;


        public OneViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPhoto = itemView.findViewById(R.id.imageHomeFood);
            tvNama = itemView.findViewById(R.id.TittleHomeFood);
            tvHarga = itemView.findViewById(R.id.DesHomeMenu);
        }
    }
}
