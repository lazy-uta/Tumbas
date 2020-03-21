package com.dicodingtraining.tumbas.Fragment;


import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Toolbar;

import com.dicodingtraining.tumbas.Adapter.OneAdapter;
import com.dicodingtraining.tumbas.Adapter.VoucherAdapter;
import com.dicodingtraining.tumbas.Adapter.VoucherPgAdapter;
import com.dicodingtraining.tumbas.ChildFragment.ChildoneFragment;
import com.dicodingtraining.tumbas.ChildFragment.ChildtwoFragment;
import com.dicodingtraining.tumbas.Data.MealsData;
import com.dicodingtraining.tumbas.Data.VoucherData;
import com.dicodingtraining.tumbas.Model.Meals;
import com.dicodingtraining.tumbas.Model.Vouchers;
import com.dicodingtraining.tumbas.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiscountFragment extends Fragment {

    ViewPager viewPager;
    TabLayout tabs;
    private Activity activity;
    private ArrayList<Vouchers> list = new ArrayList<>();
    RecyclerView rvDiscount;

    public DiscountFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_discount, container, false);

        viewPager =  view.findViewById(R.id.voucher_child);
        tabs = view.findViewById(R.id.tablayout_discount);
        tabs.setupWithViewPager(viewPager);

        
        return view;
    }




    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setupViewPager(viewPager);

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        
    }

    private void setupViewPager(ViewPager viewPager) {
        VoucherPgAdapter adapter = new VoucherPgAdapter(getChildFragmentManager());

        adapter.addFragment(new ChildoneFragment(), "Tumbas voucher_icon");
        adapter.addFragment(new ChildtwoFragment(),"Partner voucher_icon");

        viewPager.setAdapter(adapter);
    }


}
