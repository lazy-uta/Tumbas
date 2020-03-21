package com.dicodingtraining.tumbas.Resto.Data;

import com.dicodingtraining.tumbas.R;
import com.dicodingtraining.tumbas.Resto.Model.Gacoans;
import com.dicodingtraining.tumbas.Resto.Model.Kimchis;

import java.util.ArrayList;

public class KimchiData {

    private static String[] mealsName = {
            "Kimchi",
            "Cheese Eraboki",
            "jajangMeyon",
            "Beef Bulgogi"
    };

    private static String[] mealsDesc = {
            "deskripsinya gak tau ",
            "ini juga apaan dah + cheese",
            "ndak tau juga :v",
            "dagig sapi dah gitu"
    };
    private static String[] mealsHarga = {
            "28000",
            "41000",
            "39000",
            "23000"


    };

    private static int[] mealsImages = {
            R.drawable.krf_kimchi,
            R.drawable.krf_cheeseraboki,
            R.drawable.krf_jajangmyeon,
            R.drawable.kr_beefbulgogi


    };

    public static ArrayList<Kimchis> getListData(){
        ArrayList<Kimchis> kimchislist = new ArrayList<>();
        for (int position = 0; position< mealsName.length; position++){
            Kimchis kimchis = new Kimchis();

            kimchis.setNama(mealsName[position]);
            kimchis.setDesc(mealsDesc[position]);
            kimchis.setImages(mealsImages[position]);
            kimchis.setHarga(mealsHarga[position]);
            kimchislist.add(kimchis);
        }
        return kimchislist;
    }

}
