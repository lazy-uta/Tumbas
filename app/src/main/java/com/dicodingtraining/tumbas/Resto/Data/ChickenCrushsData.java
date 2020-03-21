package com.dicodingtraining.tumbas.Resto.Data;

import com.dicodingtraining.tumbas.R;
import com.dicodingtraining.tumbas.Resto.Model.AyamGepuk;
import com.dicodingtraining.tumbas.Resto.Model.ChickenCrushs;

import java.util.ArrayList;

public class ChickenCrushsData {
    private static String[] mealsName = {
            "Paket 1 ",
            "Paket 2 ",
            "Rice Box chicken crush",
            "Rice Box Mozarela"
    };

    private static String[] mealsDesc = {
            "paha atas + geprek  ",
            "Dada Lembut + geprek",
            "Rice Box + french Chicken",
            "Rice Box + french Chicken + mozarela cream"
    };
    private static String[] mealsHarga = {
            "12000",
            "14000",
            "14000",
            "19000"
    };

    private static int[] mealsImages = {
            R.drawable.cc_menu1,
            R.drawable.cc_menu2,
            R.drawable.cc_menu3,
            R.drawable.cc_menu4


    };
    public static ArrayList<ChickenCrushs> getListData(){
        ArrayList<ChickenCrushs> chickenCrushlist = new ArrayList<>();
        for (int position = 0; position< mealsName.length; position++){
            ChickenCrushs chickenCrushs = new ChickenCrushs();

            chickenCrushs.setNama(mealsName[position]);
            chickenCrushs.setDesc(mealsDesc[position]);
            chickenCrushs.setImages(mealsImages[position]);
            chickenCrushs.setHarga(mealsHarga[position]);
            chickenCrushlist.add(chickenCrushs);
        }
        return chickenCrushlist;
    }

}
