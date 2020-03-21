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
import com.dicodingtraining.tumbas.Resto.Model.AyamGepuk;
import com.dicodingtraining.tumbas.Resto.Model.MenuAngkringan;

import java.util.ArrayList;

public class AyamGepukAndapter extends RecyclerView.Adapter<AyamGepukAndapter.AyamGepukViewHolder> {

    private ArrayList<AyamGepuk> ayamGepukslist;

    public AyamGepukAndapter(ArrayList<AyamGepuk> list){
        this.ayamGepukslist = list;
    }

    @NonNull
    @Override
    public AyamGepukViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recycler_menu, viewGroup, false);


        return new AyamGepukViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AyamGepukViewHolder holder, final int position) {

        final AyamGepuk ayamGepuk = ayamGepukslist.get(position);

        Glide.with(holder.itemView.getContext())
                .load(ayamGepuk.getImages())
                .apply(new RequestOptions().override(350,350))
                .into(holder.img_Photo);
        holder.tv_NamaResto.setText(ayamGepuk.getNama());
        holder.tv_Price.setText(ayamGepuk.getHarga());
        holder.tv_Desc.setText(ayamGepuk.getDesc());

    }

    @Override
    public int getItemCount() {
        return ayamGepukslist.size();
    }

    public class AyamGepukViewHolder extends RecyclerView.ViewHolder {
        TextView tv_NamaResto, tv_Desc, tv_Price;
        ImageView img_Photo;

        public AyamGepukViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_NamaResto = itemView.findViewById(R.id.tv_menu_name);
            tv_Price = itemView.findViewById(R.id.tv_menu_price);
            img_Photo = itemView.findViewById(R.id.iv_menu_img);
            tv_Desc = itemView.findViewById(R.id.tv_menu_desc);
        }
    }
}
