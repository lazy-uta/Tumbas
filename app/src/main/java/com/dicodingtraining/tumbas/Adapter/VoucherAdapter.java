package com.dicodingtraining.tumbas.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dicodingtraining.tumbas.Model.Meals;
import com.dicodingtraining.tumbas.Model.Vouchers;
import com.dicodingtraining.tumbas.R;

import java.util.ArrayList;

public class VoucherAdapter  extends RecyclerView.Adapter<VoucherAdapter.VoucherViewHolder>{
    private ArrayList<Vouchers> listVouchers;

    public VoucherAdapter(ArrayList<Vouchers> list){
        this.listVouchers = list;
    }

    @NonNull
    @Override
    public VoucherViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_voucher, viewGroup, false);
        return new VoucherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VoucherViewHolder holder, int position) {
        final Vouchers vouchers = listVouchers.get(position);

        Glide.with(holder.itemView.getContext())
                .load(vouchers.getPhotos())
                .apply(new RequestOptions().override(350,350))
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return listVouchers.size();
    }

    public class VoucherViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public VoucherViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img_Voucher);
        }
    }
}
