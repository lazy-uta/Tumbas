package com.dicodingtraining.tumbas.BasicActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.dicodingtraining.tumbas.Adapter.RestoAdapter;
import com.dicodingtraining.tumbas.Data.AllMealsData;
import com.dicodingtraining.tumbas.Data.MealsData;
import com.dicodingtraining.tumbas.Model.AllMeals;
import com.dicodingtraining.tumbas.Model.Meals;
import com.dicodingtraining.tumbas.R;

import java.util.ArrayList;

public class RestoActivity extends AppCompatActivity {
    private RecyclerView rvResto;
    private ArrayList<AllMeals> list = new ArrayList<>();
    private ImageButton btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resto);

        rvResto = findViewById(R.id.rvResto_menu);
        btn_back = findViewById(R.id.ra_btn_back);
        rvResto.setHasFixedSize(true);




        list.addAll(AllMealsData.getListData());
        showRecyclerList();

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RestoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });



    }

    private void showRecyclerList() {
        rvResto.setLayoutManager(new LinearLayoutManager(this));
        RestoAdapter restoAdapter = new RestoAdapter(list);
        rvResto.setAdapter(restoAdapter);
    }
}
