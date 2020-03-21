package com.dicodingtraining.tumbas.Data;

import com.dicodingtraining.tumbas.Model.AllMeals;
import com.dicodingtraining.tumbas.R;

import java.util.ArrayList;

public class AllMealsData {

    private static String[] mealsName = {
            "Angkringan Wijilan",
            "Angkringan KR",
            "Angkringan Pak Man",
            "Ayam Gepuk Pak Gembus",
            "Ayam Gobyos",
            "Chicken Crush",
            "Jank Jank Wings",
            "Olive",
            "Kimchis",
            "Jajangmyeon",
            "Cheese Eraboki",
            "Beef Bulgogi"

    };

    private static String[] mealsDesc = {
            "jl, Wijilan 25 Yk",
            "jl, Kadipaten Malioboro YK",
            "jl. Kadipaten 88 YK",
            "jl, Kadipiro Nomor 28 Yk",
            "jl, Sinduadi Nomor 22 Yk",
            "jl. Kecapi No 7 Sleman",
            "jl. perumnas 31 Sleman",
            "jl. Candi Gebang 32 Sleman",
            "jl, Wolter Monginsidi 12 Yk",
            "jl, Senopati 24s Bantul",
            "Jl. Amsangaji yogyakrta",
            "jl perum permata Yk"
    };

    private static int[] mealsImages = {
            R.drawable.hd_angwijilan,
            R.drawable.hed_angkr,
            R.drawable.hd_pkman,
            R.drawable.hd_ayamgepuk,
            R.drawable.hd_ayamgobyos,
            R.drawable.hd_chickencrush,
            R.drawable.hd_jankjank,
            R.drawable.hd_olive,
            R.drawable.hd_kimchi,
            R.drawable.krf_jajangmyeon,
            R.drawable.krf_cheeseraboki,
            R.drawable.kr_beefbulgogi
    };

    private static String[] melasLoc = {
            "12",
            "5.2",
            "30",
            "3.1",
            "4.5",
            "7.8",
            "9",
            "20.5",
            "15",
            "4,3",
            "2.2",
            "7,3"

    };

    public static ArrayList<AllMeals> getListData(){
        ArrayList<AllMeals> allMealslist = new ArrayList<>();
        for (int position = 0; position< mealsName.length; position++){
            AllMeals allMeals = new AllMeals();

            allMeals.setNama(mealsName[position]);
            allMeals.setDesc(mealsDesc[position]);
            allMeals.setPhoto(mealsImages[position]);
            allMeals.setLoc(melasLoc[position]);
            allMealslist.add(allMeals);
        }
        return allMealslist;
    }
}
