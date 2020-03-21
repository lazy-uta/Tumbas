package com.dicodingtraining.tumbas.Resto.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dicodingtraining.tumbas.R;
import com.dicodingtraining.tumbas.Resto.Model.ChickenCrushs;
import com.dicodingtraining.tumbas.Resto.Model.MenuAngkringan;

import java.util.ArrayList;

public class ChickenCrushAdapter extends RecyclerView.Adapter<ChickenCrushAdapter.ChickenCrushViewHolder> {

    private ArrayList<ChickenCrushs> chickenCrushslist;

    public ChickenCrushAdapter(ArrayList<ChickenCrushs> list){
        this.chickenCrushslist = list;
    }

    @NonNull
    @Override
    public ChickenCrushViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recycler_menu, viewGroup, false);


        return new ChickenCrushViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChickenCrushViewHolder holder, int position) {
        ChickenCrushs chickenCrushs = chickenCrushslist.get(position);

        Glide.with(holder.itemView.getContext())
                .load(chickenCrushs.getImages())
                .apply(new RequestOptions().override(350,350))
                .into(holder.img_Photo);
        holder.tv_NamaResto.setText(chickenCrushs.getNama());
        holder.tv_Price.setText(chickenCrushs.getHarga());
        holder.tv_Desc.setText(chickenCrushs.getDesc());

    }

    @Override
    public int getItemCount() {
        return chickenCrushslist.size();
    }

    public class ChickenCrushViewHolder extends RecyclerView.ViewHolder {
        TextView tv_NamaResto, tv_Desc, tv_Price;
        ImageView img_Photo;

        public ChickenCrushViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_NamaResto = itemView.findViewById(R.id.tv_menu_name);
            tv_Price = itemView.findViewById(R.id.tv_menu_price);
            img_Photo = itemView.findViewById(R.id.iv_menu_img);
            tv_Desc = itemView.findViewById(R.id.tv_menu_desc);
        }
    }
}
