package com.dicodingtraining.tumbas.Resto.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.dicodingtraining.tumbas.BasicActivity.MainActivity;
import com.dicodingtraining.tumbas.Fragment.InvoiceFragment;
import com.dicodingtraining.tumbas.R;
import com.dicodingtraining.tumbas.Resto.Adapter.AngkringanAdapter;
import com.dicodingtraining.tumbas.Resto.Adapter.GacoanAdapter;
import com.dicodingtraining.tumbas.Resto.Data.GacoanData;
import com.dicodingtraining.tumbas.Resto.Data.MenuAngkringanData;
import com.dicodingtraining.tumbas.Resto.Model.Gacoans;
import com.dicodingtraining.tumbas.Resto.Model.MenuAngkringan;

import java.util.ArrayList;

public class Gacoan extends AppCompatActivity {
    private RecyclerView rvMenu;
    private ArrayList<Gacoans> list = new ArrayList<>();
    private ImageButton btn_back;
    private Button btn_order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gacoan);

        rvMenu = findViewById(R.id.rv_menu_gacoan);
        btn_back = findViewById(R.id.ra_btn_back);
        btn_order = findViewById(R.id.btn_order_gacoan);
        rvMenu.setHasFixedSize(true);

        list.addAll(GacoanData.getListData());
        showRecyclerList();

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Gacoan.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btn_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent( Gacoan.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void showRecyclerList() {
        rvMenu.setLayoutManager(new LinearLayoutManager(this));
        GacoanAdapter gacoanAdapter = new GacoanAdapter(list);
        rvMenu.setAdapter(gacoanAdapter);
    }
}
