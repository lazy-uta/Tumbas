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
import com.dicodingtraining.tumbas.Adapter.RestoAdapter;
import com.dicodingtraining.tumbas.Model.AllMeals;
import com.dicodingtraining.tumbas.Model.Angkringans;
import com.dicodingtraining.tumbas.R;
import com.dicodingtraining.tumbas.Resto.Model.MenuAngkringan;

import java.util.ArrayList;

public class AngkringanAdapter extends RecyclerView.Adapter<AngkringanAdapter.AngkringanViewHolder> {

    private ArrayList<MenuAngkringan> angkringanslist;

    public AngkringanAdapter(ArrayList<MenuAngkringan> list){
        this.angkringanslist = list;
    }

    @NonNull
    @Override
    public AngkringanAdapter.AngkringanViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recycler_menu, viewGroup, false);

        return new AngkringanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AngkringanAdapter.AngkringanViewHolder holder, int position) {
        MenuAngkringan angkringans = angkringanslist.get(position);

        Glide.with(holder.itemView.getContext())
                .load(angkringans.getImages())
                .apply(new RequestOptions().override(350,350))
                .into(holder.img_Photo);
        holder.tv_NamaResto.setText(angkringans.getNama());
        holder.tv_Price.setText(angkringans.getHarga());
        holder.tv_Desc.setText(angkringans.getDesc());

    }

    @Override
    public int getItemCount() {
        return angkringanslist.size();
    }

    public class AngkringanViewHolder extends RecyclerView.ViewHolder {
        TextView tv_NamaResto, tv_Desc, tv_Price;
        ImageView img_Photo;

        public AngkringanViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_NamaResto = itemView.findViewById(R.id.tv_menu_name);
            tv_Price = itemView.findViewById(R.id.tv_menu_price);
            img_Photo = itemView.findViewById(R.id.iv_menu_img);
            tv_Desc = itemView.findViewById(R.id.tv_menu_desc);
        }
    }
}
