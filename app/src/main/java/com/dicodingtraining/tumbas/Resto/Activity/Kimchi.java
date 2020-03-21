package com.dicodingtraining.tumbas.Resto.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.dicodingtraining.tumbas.BasicActivity.MainActivity;
import com.dicodingtraining.tumbas.R;
import com.dicodingtraining.tumbas.Resto.Adapter.AngkringanAdapter;
import com.dicodingtraining.tumbas.Resto.Adapter.KimchiAdapter;
import com.dicodingtraining.tumbas.Resto.Data.KimchiData;
import com.dicodingtraining.tumbas.Resto.Data.MenuAngkringanData;
import com.dicodingtraining.tumbas.Resto.Model.Kimchis;
import com.dicodingtraining.tumbas.Resto.Model.MenuAngkringan;

import java.util.ArrayList;

public class Kimchi extends AppCompatActivity {
    private RecyclerView rvMenu;
    private ArrayList<Kimchis> list = new ArrayList<>();
    private ImageButton btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kimchi);

        rvMenu = findViewById(R.id.rv_menu_kimchi);
        btn_back = findViewById(R.id.ra_btn_back);
        rvMenu.setHasFixedSize(true);

        list.addAll(KimchiData.getListData());
        showRecyclerList();

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Kimchi.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void showRecyclerList() {
        rvMenu.setLayoutManager(new LinearLayoutManager(this));
        KimchiAdapter kimchiAdapter = new KimchiAdapter(list);
        rvMenu.setAdapter(kimchiAdapter);
    }
}
