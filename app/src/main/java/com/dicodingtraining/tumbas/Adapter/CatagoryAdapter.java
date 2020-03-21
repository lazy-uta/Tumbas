package com.dicodingtraining.tumbas.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dicodingtraining.tumbas.Model.Drinks;
import com.dicodingtraining.tumbas.Model.Meals;
import com.dicodingtraining.tumbas.R;

import java.util.ArrayList;

public class CatagoryAdapter extends RecyclerView.Adapter<CatagoryAdapter.CatagoryViewHolder> {

    private ArrayList<Drinks> listDrinks;


    public CatagoryAdapter(ArrayList<Drinks> list){
        this.listDrinks = list;
    }

    @NonNull
    @Override
    public CatagoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recycler_menuresto, viewGroup, false);

        return new CatagoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatagoryViewHolder holder, int position) {
        Drinks drinks = listDrinks.get(position);

        Glide.with(holder.itemView.getContext())
                .load(drinks.getPhoto())
                .apply(new RequestOptions().override(350,350))
                .into(holder.imgPhoto);
        holder.tv_NamaResto.setText(drinks.getNama());
        holder.tv_Price.setText(drinks.getDesc());

    }

    @Override
    public int getItemCount() {
        return listDrinks.size();
    }

    public class CatagoryViewHolder extends RecyclerView.ViewHolder {
        TextView tv_NamaResto, tv_DescResto, tv_Price;
        ImageView imgPhoto;

        public CatagoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_NamaResto = itemView.findViewById(R.id.tv_namaMenu);
            tv_Price = itemView.findViewById(R.id.tv_descMenu);
            imgPhoto = itemView.findViewById(R.id.img_rvMenu);

        }
    }
}
