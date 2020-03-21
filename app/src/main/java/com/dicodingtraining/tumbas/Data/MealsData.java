package com.dicodingtraining.tumbas.Data;

import com.dicodingtraining.tumbas.Model.Meals;
import com.dicodingtraining.tumbas.R;

import java.util.ArrayList;

public class MealsData {

    private static String[] mealsName = {
            "Ayam Gepuk Pak Gembus",
            "Ayam Gobyos",
            "Chicken Crush",
            "Jank Jank Wings",
            "Olive"
    };

    private static String[] mealsHarga = {
            "jl, Kadipiro Nomor 28 Yk",
            "jl, Sinduadi Nomor 22 Yk",
            "jl. Kecapi No 7 Sleman",
            "jl. perumnas 31 Sleman",
            "jl. Candi Gebang 32 Sleman"
  };

    private static int[] mealsImages = {
            R.drawable.hd_ayamgepuk,
            R.drawable.hd_ayamgobyos,
            R.drawable.hd_chickencrush,
            R.drawable.hd_jankjank,
            R.drawable.hd_olive
    };

    public static ArrayList<Meals> getListData(){
        ArrayList<Meals> list = new ArrayList<>();
        for (int position = 0; position< mealsName.length; position++){
            Meals meals = new Meals();

            meals.setNama(mealsName[position]);
            meals.setHarga(mealsHarga[position]);
            meals.setPhoto(mealsImages[position]);
            list.add(meals);
        }
        return list;
    }


}
