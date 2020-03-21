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
import com.dicodingtraining.tumbas.Resto.Model.MenuAngkringan;
import com.dicodingtraining.tumbas.Resto.Model.MieNyinyirs;

import java.util.ArrayList;

public class MieNyinyirAdapter extends RecyclerView.Adapter<MieNyinyirAdapter.MieNyiyirViewHolder> {

    private ArrayList<MieNyinyirs> mieNyinyirslist;

    public MieNyinyirAdapter(ArrayList<MieNyinyirs> list){
        this.mieNyinyirslist = list;
    }

    @NonNull
    @Override
    public MieNyiyirViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recycler_menu, viewGroup, false);

        return new MieNyiyirViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MieNyiyirViewHolder holder, int position) {
        MieNyinyirs mieNyinyirs = mieNyinyirslist.get(position);

        Glide.with(holder.itemView.getContext())
                .load(mieNyinyirs.getImages())
                .apply(new RequestOptions().override(350,350))
                .into(holder.img_Photo);
        holder.tv_NamaResto.setText(mieNyinyirs.getNama());
        holder.tv_Price.setText(mieNyinyirs.getHarga());
        holder.tv_Desc.setText(mieNyinyirs.getDesc());

    }

    @Override
    public int getItemCount() {
        return mieNyinyirslist.size();
    }

    public class MieNyiyirViewHolder extends RecyclerView.ViewHolder {
        TextView tv_NamaResto, tv_Desc, tv_Price;
        ImageView img_Photo;
        public MieNyiyirViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_NamaResto = itemView.findViewById(R.id.tv_menu_name);
            tv_Price = itemView.findViewById(R.id.tv_menu_price);
            img_Photo = itemView.findViewById(R.id.iv_menu_img);
            tv_Desc = itemView.findViewById(R.id.tv_menu_desc);
        }
    }
}
