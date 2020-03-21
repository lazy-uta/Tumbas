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
import com.dicodingtraining.tumbas.Resto.Adapter.MieNyinyirAdapter;
import com.dicodingtraining.tumbas.Resto.Data.MenuAngkringanData;
import com.dicodingtraining.tumbas.Resto.Data.MieNyinyirData;
import com.dicodingtraining.tumbas.Resto.Model.MenuAngkringan;
import com.dicodingtraining.tumbas.Resto.Model.MieNyinyirs;

import java.util.ArrayList;

public class MieNyinyir extends AppCompatActivity {
    private RecyclerView rvMenu;
    private ArrayList<MieNyinyirs> list = new ArrayList<>();
    private ImageButton btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mie_nyinyir);

        rvMenu = findViewById(R.id.rv_menu_nyinyir);
        btn_back = findViewById(R.id.ra_btn_back);
        rvMenu.setHasFixedSize(true);

        list.addAll(MieNyinyirData.getListData());
        showRecyclerList();

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MieNyinyir.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void showRecyclerList() {
        rvMenu.setLayoutManager(new LinearLayoutManager(this));
        MieNyinyirAdapter mieNyinyirAdapter = new MieNyinyirAdapter(list);
        rvMenu.setAdapter(mieNyinyirAdapter);
    }
}
