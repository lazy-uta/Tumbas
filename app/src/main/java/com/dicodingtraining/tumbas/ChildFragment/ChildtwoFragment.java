package com.dicodingtraining.tumbas.ChildFragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dicodingtraining.tumbas.Adapter.VoucherAdapter;
import com.dicodingtraining.tumbas.Data.VoucherData;
import com.dicodingtraining.tumbas.Model.Vouchers;
import com.dicodingtraining.tumbas.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChildtwoFragment extends Fragment {

    private ArrayList<Vouchers> list = new ArrayList<>();
    RecyclerView rvDiscount;


    public ChildtwoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_childtwo, container, false);

        rvDiscount = view.findViewById(R.id.rv_VoucherPartner);

        list.addAll(VoucherData.getListData());
        showDiscountRecycler();

        return (view);
    }

    private void showDiscountRecycler() {
        VoucherAdapter voucherAdapter = new VoucherAdapter(list);

        rvDiscount.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL, false));
        rvDiscount.setAdapter(voucherAdapter);
    }

}
