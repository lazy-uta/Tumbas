package com.dicodingtraining.tumbas.Resto.Data;

import com.dicodingtraining.tumbas.R;
import com.dicodingtraining.tumbas.Resto.Model.AyamGepuk;

import java.util.ArrayList;

public class AyamGepukData {

    private static String[] mealsName = {
            "Ayam Gepuk",
            "Ayam Gepuk tipis - tipis",
            "Ayam Gepuk matah",
            "Ayam Gepuk Normal",
            "Ayam gepuk Madu"
    };

    private static String[] mealsDesc = {
            "ayam gepuk dengan cabe lvl 1-5 ",
            "Ayam Gepuk tipis - tipis",
            "ayam gepuk + sambel matah",
            "normal gitu",
            "ayam gepuk + madu "
    };
    private static String[] mealsHarga = {
            "14000",
            "16000",
            "15000",
           "13000",
            "17000"


    };

    private static int[] mealsImages = {
            R.drawable.ag_menu1,
            R.drawable.ag_menu2,
            R.drawable.ag_menu3,
            R.drawable.ag_menu4,
            R.drawable.ag_menu5,
            R.drawable.ag_menu6,


    };
    public static ArrayList<AyamGepuk> getListData(){
        ArrayList<AyamGepuk> ayamGepuks = new ArrayList<>();
        for (int position = 0; position< mealsName.length; position++){
            AyamGepuk ayamGepuk = new AyamGepuk();

           ayamGepuk.setNama(mealsName[position]);
           ayamGepuk.setDesc(mealsDesc[position]);
           ayamGepuk.setImages(mealsImages[position]);
           ayamGepuk.setHarga(mealsHarga[position]);
            ayamGepuks.add(ayamGepuk);
        }
        return ayamGepuks;
    }


}
