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
import com.dicodingtraining.tumbas.Resto.Model.Kimchis;
import com.dicodingtraining.tumbas.Resto.Model.MenuAngkringan;

import java.util.ArrayList;

public class KimchiAdapter extends RecyclerView.Adapter<KimchiAdapter.KimchiViewHolder> {

    private ArrayList<Kimchis> kimchisList;

    public KimchiAdapter(ArrayList<Kimchis> list){
        this.kimchisList = list;
    }

    @NonNull
    @Override
    public KimchiViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recycler_menu, viewGroup, false);


        return new KimchiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KimchiViewHolder holder, int position) {
        Kimchis kimchis = kimchisList.get(position);

        Glide.with(holder.itemView.getContext())
                .load(kimchis.getImages())
                .apply(new RequestOptions().override(350,350))
                .into(holder.img_Photo);
        holder.tv_NamaResto.setText(kimchis.getNama());
        holder.tv_Price.setText(kimchis.getHarga());
        holder.tv_Desc.setText(kimchis.getDesc());
    }

    @Override
    public int getItemCount() {
        return kimchisList.size();
    }

    public class KimchiViewHolder extends RecyclerView.ViewHolder {
        TextView tv_NamaResto, tv_Desc, tv_Price;
        ImageView img_Photo;
        public KimchiViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_NamaResto = itemView.findViewById(R.id.tv_menu_name);
            tv_Price = itemView.findViewById(R.id.tv_menu_price);
            img_Photo = itemView.findViewById(R.id.iv_menu_img);
            tv_Desc = itemView.findViewById(R.id.tv_menu_desc);
        }
    }
}
