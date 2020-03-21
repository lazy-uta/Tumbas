package com.dicodingtraining.tumbas.Resto.Data;

import com.dicodingtraining.tumbas.R;
import com.dicodingtraining.tumbas.Resto.Model.AyamGepuk;
import com.dicodingtraining.tumbas.Resto.Model.Gacoans;

import java.util.ArrayList;

public class GacoanData {
    private static String[] mealsName = {
            "Mie Iblis ",
            "Pangsit",
            "Mie Setan",
            "Camilan",
            "Pangsit basah"
    };

    private static String[] mealsDesc = {
            "Mie manis + sambal pilihan  ",
            "pangsit ayam",
            "Mie Gurih + sambal Pilihan",
            "harga sama pilih di tempat",
            "pangsit rebus "
    };
    private static String[] mealsHarga = {
            "18000",
            "8000",
            "18000",
            "8000",
            "8000"


    };

    private static int[] mealsImages = {
            R.drawable.gc_menu1,
            R.drawable.gc_menu2,
            R.drawable.gc_menu3,
            R.drawable.gc_menu4,
            R.drawable.gc_menu5


    };

    public static ArrayList<Gacoans> getListData(){
        ArrayList<Gacoans> gacoanslist = new ArrayList<>();
        for (int position = 0; position< mealsName.length; position++){
            Gacoans gacoans = new Gacoans();

            gacoans.setNama(mealsName[position]);
            gacoans.setDesc(mealsDesc[position]);
            gacoans.setImages(mealsImages[position]);
            gacoans.setHarga(mealsHarga[position]);
            gacoanslist.add(gacoans);
        }
        return gacoanslist;
    }
}
