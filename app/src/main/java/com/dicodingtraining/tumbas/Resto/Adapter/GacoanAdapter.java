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
import com.dicodingtraining.tumbas.Resto.Activity.Gacoan;
import com.dicodingtraining.tumbas.Resto.Model.Gacoans;
import com.dicodingtraining.tumbas.Resto.Model.MenuAngkringan;

import java.util.ArrayList;

public class GacoanAdapter extends RecyclerView.Adapter<GacoanAdapter.GacoanViewHolder> {

    private ArrayList<Gacoans> gacoanslist;

    public GacoanAdapter(ArrayList<Gacoans> list){
        this.gacoanslist = list;
    }

    @NonNull
    @Override
    public GacoanViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recycler_menu, viewGroup, false);


        return new GacoanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GacoanViewHolder holder, int position) {
        Gacoans gacoans = gacoanslist.get(position);

        Glide.with(holder.itemView.getContext())
                .load(gacoans.getImages())
                .apply(new RequestOptions().override(350,350))
                .into(holder.img_Photo);
        holder.tv_NamaResto.setText(gacoans.getNama());
        holder.tv_Price.setText(gacoans.getHarga());
        holder.tv_Desc.setText(gacoans.getDesc());

    }

    @Override
    public int getItemCount() {
        return gacoanslist.size();
    }

    public class GacoanViewHolder extends RecyclerView.ViewHolder {
        TextView tv_NamaResto, tv_Desc, tv_Price;
        ImageView img_Photo;
        public GacoanViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_NamaResto = itemView.findViewById(R.id.tv_menu_name);
            tv_Price = itemView.findViewById(R.id.tv_menu_price);
            img_Photo = itemView.findViewById(R.id.iv_menu_img);
            tv_Desc = itemView.findViewById(R.id.tv_menu_desc);
        }
    }
}
