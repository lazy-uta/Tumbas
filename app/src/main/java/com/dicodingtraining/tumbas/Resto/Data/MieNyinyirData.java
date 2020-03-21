package com.dicodingtraining.tumbas.Resto.Data;

import com.dicodingtraining.tumbas.R;
import com.dicodingtraining.tumbas.Resto.Model.Gacoans;
import com.dicodingtraining.tumbas.Resto.Model.MieNyinyirs;

import java.util.ArrayList;

public class MieNyinyirData {
    private static String[] mealsName = {
            "nyinyir Tetangga",
            "Nyinyir sampek rumah",
            "Nyinyir Temen"
    };

    private static String[] mealsDesc = {
            "mie nyiyir lvl 1-5",
            "mie Nyiyir Box",
            "mie Nyiyir lvl 5 -10"
    };
    private static String[] mealsHarga = {
            "12000",
            "14000",
            "15000"


    };

    private static int[] mealsImages = {
            R.drawable.ag_menu1,
            R.drawable.ag_menu2,
            R.drawable.ag_menu3


    };

    public static ArrayList<MieNyinyirs> getListData(){
        ArrayList<MieNyinyirs> mieNyinyirslist = new ArrayList<>();
        for (int position = 0; position< mealsName.length; position++){
            MieNyinyirs mieNyinyirs = new MieNyinyirs();

            mieNyinyirs.setNama(mealsName[position]);
            mieNyinyirs.setDesc(mealsDesc[position]);
            mieNyinyirs.setImages(mealsImages[position]);
            mieNyinyirs.setHarga(mealsHarga[position]);
            mieNyinyirslist.add(mieNyinyirs);
        }
        return mieNyinyirslist;
    }
}
