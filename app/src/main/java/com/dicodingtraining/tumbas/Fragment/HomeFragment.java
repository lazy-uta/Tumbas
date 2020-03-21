package com.dicodingtraining.tumbas.Fragment;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dicodingtraining.tumbas.Adapter.FavoriteAdapter;
import com.dicodingtraining.tumbas.Adapter.FourAdapter;
import com.dicodingtraining.tumbas.Adapter.OneAdapter;
import com.dicodingtraining.tumbas.Adapter.RecomenAdapter;
import com.dicodingtraining.tumbas.Adapter.ThreeAdapter;
import com.dicodingtraining.tumbas.Adapter.TwoAdapter;
import com.dicodingtraining.tumbas.BasicActivity.CategoryActivity;
import com.dicodingtraining.tumbas.BasicActivity.RestoActivity;
import com.dicodingtraining.tumbas.Data.AngkringansData;
import com.dicodingtraining.tumbas.Data.KoreansData;
import com.dicodingtraining.tumbas.Data.MealsData;
import com.dicodingtraining.tumbas.Data.NoodelsData;
import com.dicodingtraining.tumbas.Model.Angkringans;
import com.dicodingtraining.tumbas.Model.Koreans;
import com.dicodingtraining.tumbas.Model.Meals;
import com.dicodingtraining.tumbas.Model.Noodels;
import com.dicodingtraining.tumbas.R;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    public static ViewPager viewPagerFav;
    private Activity activity;
    private ArrayList<Meals> list = new ArrayList<>();
    private ArrayList<Noodels> noodelslist = new ArrayList<>();
    private ArrayList<Angkringans> angkringanslist = new ArrayList<>();
    private ArrayList<Koreans> koreanslist = new ArrayList<>();
    private RecyclerView rvHomeone,rvHometwo,rvHomethree,rvHomefour;
    private CardView btn1,btn2,btn3,btn4,btn5,btn6;


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        rvHomeone = view.findViewById(R.id.rvHome_one);
        rvHometwo = view.findViewById(R.id.rvHome_two);
        rvHomethree = view.findViewById(R.id.rvHome_three);
        rvHomefour = view.findViewById(R.id.rvHome_four);


       list.addAll(MealsData.getListData());
       noodelslist.addAll(NoodelsData.getListData());
       angkringanslist.addAll(AngkringansData.getListData());
       koreanslist.addAll(KoreansData.getListData());
       showOneRecycle();


        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewPagerFav = view.findViewById(R.id.viewPagerHeader);
        btn1 = view.findViewById(R.id.ctgr_one);
        btn2 = view.findViewById(R.id.ctgr_two);
        btn3 = view.findViewById(R.id.ctgr_three);
        btn4 = view.findViewById(R.id.ctgr_four);
        btn5 = view.findViewById(R.id.ctgr_Five);
        btn6 = view.findViewById(R.id.ctgr_six);



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), RestoActivity.class);
                getContext().startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), RestoActivity.class);
                getContext().startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), RestoActivity.class);
                getContext().startActivity(intent);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), CategoryActivity.class);
                getContext().startActivity(intent);
            }
        });


        FavoriteAdapter favoriteAdapter = new FavoriteAdapter(getContext());
        viewPagerFav.setAdapter(favoriteAdapter);;

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new FavTimerTask(),6000, 4000);





    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
    }

    public class FavTimerTask extends TimerTask{
        @Override
        public void run() {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (viewPagerFav.getCurrentItem()==0){
                        viewPagerFav.setCurrentItem(1);
                    }else if(viewPagerFav.getCurrentItem()==1){
                        viewPagerFav.setCurrentItem(2);
                    }else{
                        viewPagerFav.setCurrentItem(0);
                    }
                }
            });
        }
    }


    private void showOneRecycle(){
        OneAdapter oneAdapter = new OneAdapter(list);
        TwoAdapter twoAdapter = new TwoAdapter(noodelslist);
        ThreeAdapter threeAdapter = new ThreeAdapter(angkringanslist);
        FourAdapter fourAdapter = new FourAdapter(koreanslist);

        rvHomeone.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL, false));
        rvHomeone.setAdapter(oneAdapter);

        rvHometwo.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL, false));
        rvHometwo.setAdapter(twoAdapter);

        rvHomethree.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL, false));
        rvHomethree.setAdapter(threeAdapter);

        rvHomefour.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL, false));
        rvHomefour.setAdapter(fourAdapter);



    }




}
