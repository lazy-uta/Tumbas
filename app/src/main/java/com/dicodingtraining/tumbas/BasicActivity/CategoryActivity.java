package com.dicodingtraining.tumbas.BasicActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.dicodingtraining.tumbas.Adapter.CatagoryAdapter;
import com.dicodingtraining.tumbas.Adapter.OneAdapter;
import com.dicodingtraining.tumbas.Data.DrinksData;
import com.dicodingtraining.tumbas.Data.MealsData;
import com.dicodingtraining.tumbas.Model.Drinks;
import com.dicodingtraining.tumbas.Model.Meals;
import com.dicodingtraining.tumbas.R;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity {

    RecyclerView rvCategory;
    private LayoutInflater layoutInflater;
    private ArrayList<Drinks> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        rvCategory = findViewById(R.id.rvCategory);

        list.addAll(DrinksData.getListData());
        showRecycle();



    }

    private void showRecycle() {
        CatagoryAdapter catagoryAdapter = new CatagoryAdapter(list);

        rvCategory.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false));
        rvCategory.setAdapter(catagoryAdapter);
    }
}
