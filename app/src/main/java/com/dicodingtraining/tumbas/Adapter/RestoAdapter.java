package com.dicodingtraining.tumbas.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dicodingtraining.tumbas.BasicActivity.RestoActivity;
import com.dicodingtraining.tumbas.Fragment.HomeFragment;
import com.dicodingtraining.tumbas.Model.AllMeals;
import com.dicodingtraining.tumbas.Model.Meals;
import com.dicodingtraining.tumbas.R;
import com.dicodingtraining.tumbas.Resto.Activity.AngkringanPakMan;
import com.dicodingtraining.tumbas.Resto.Activity.AyamGepuk;
import com.dicodingtraining.tumbas.Resto.Activity.ChickenCrush;
import com.dicodingtraining.tumbas.Resto.Activity.Kimchi;

import java.util.ArrayList;

public class RestoAdapter extends RecyclerView.Adapter<RestoAdapter.RestoViewHolder> {

    private ArrayList<AllMeals> listMeals;


    public RestoAdapter(ArrayList<AllMeals> list){
        this.listMeals = list;
    }


    @NonNull
    @Override
    public RestoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recycler_menuresto, viewGroup, false);


        return new RestoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RestoViewHolder holder, final int position) {
        AllMeals allMeals = listMeals.get(position);

        Glide.with(holder.itemView.getContext())
                .load(allMeals.getPhoto())
                .apply(new RequestOptions().override(350,350))
                .into(holder.imgPhoto);
        holder.tv_NamaResto.setText(allMeals.getNama());
        holder.tv_Price.setText(allMeals.getDesc());
        holder.tv_Location.setText(allMeals.getLoc());

        holder.imgPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (position){
                    case 0:
                        Intent intent = new Intent(holder.imgPhoto.getContext(), AngkringanPakMan.class);
                        holder.imgPhoto.getContext().startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(holder.imgPhoto.getContext(), AngkringanPakMan.class);
                        holder.imgPhoto.getContext().startActivity(intent1);
                        break;
                    case 2:
                        Intent intent3 = new Intent(holder.imgPhoto.getContext(), AngkringanPakMan.class);
                        holder.imgPhoto.getContext().startActivity(intent3);
                        break;
                    case 5:
                        Intent intent4 = new Intent(holder.imgPhoto.getContext(), ChickenCrush.class);
                        holder.imgPhoto.getContext().startActivity(intent4);
                        break;

                    case 8:
                        Intent intent5 = new Intent(holder.imgPhoto.getContext(), Kimchi.class);
                        holder.imgPhoto.getContext().startActivity(intent5);
                        default:Intent intentd = new Intent(holder.imgPhoto.getContext(), AyamGepuk.class);
                            holder.imgPhoto.getContext().startActivity(intentd);
                            break;


                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return listMeals.size();
    }

    public class RestoViewHolder extends RecyclerView.ViewHolder {
        TextView tv_NamaResto, tv_Location, tv_Price;
        ImageView imgPhoto;

        public RestoViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_NamaResto = itemView.findViewById(R.id.tv_namaMenu);
            tv_Price = itemView.findViewById(R.id.tv_descMenu);
            imgPhoto = itemView.findViewById(R.id.img_rvMenu);
            tv_Location = itemView.findViewById(R.id.tv_location);
        }
    }
}
