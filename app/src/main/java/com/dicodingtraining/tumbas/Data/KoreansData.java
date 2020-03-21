package com.dicodingtraining.tumbas.Data;

import com.dicodingtraining.tumbas.Model.Koreans;
import com.dicodingtraining.tumbas.R;

import java.util.ArrayList;

public class KoreansData {
    private static String[] mealsName = {
            "Kimchis",
            "Jajangmyeon",
            "Cheese Eraboki",
            "Beef Bulgogi"
    };

    private static String[] mealsDesc = {
            "jl, Wolter Monginsidi 12 Yk",
            "jl, Senopati 24s Bantul",
            "Jl. Amsangaji yogyakrta",
            "jl perum permata Yk"
    };

    private static int[] mealsImages = {
            R.drawable.hd_kimchi,
            R.drawable.krf_jajangmyeon,
            R.drawable.krf_cheeseraboki,
            R.drawable.kr_beefbulgogi

    };

    public static ArrayList<Koreans> getListData(){
        ArrayList<Koreans> koreanslist = new ArrayList<>();
        for (int position = 0; position< mealsName.length; position++){
            Koreans koreans = new Koreans();
            koreans.setNama(mealsName[position]);
            koreans.setDesc(mealsDesc[position]);
            koreans.setPhoto(mealsImages[position]);
            koreanslist.add(koreans);
        }
        return koreanslist;
    }
}
