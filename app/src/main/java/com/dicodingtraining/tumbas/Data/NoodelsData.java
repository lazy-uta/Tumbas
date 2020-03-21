package com.dicodingtraining.tumbas.Data;

import com.dicodingtraining.tumbas.Model.Noodels;
import com.dicodingtraining.tumbas.R;

import java.util.ArrayList;

public class NoodelsData {
    private static String[] mealsName = {
            "Gacoans",
            "Mie Nyiyir",
            "Mie Pedes",
            "Miedak Pou"
    };

    private static String[] mealsDesc = {
            "jl, Senopati Nomor 28 Yk",
            "jl, Lingsirwengi Nomor 22 Yk",
            "jl. Panjang No 7 Sleman",
            "jl. pulang 31 Sleman"
    };

    private static int[] mealsImages = {
            R.drawable.hd_gacoan,
            R.drawable.hd_mienyiyir,
            R.drawable.gc_menu1,
            R.drawable.gc_menu3
    };

    public static ArrayList<Noodels> getListData(){
        ArrayList<Noodels> noodelslist = new ArrayList<>();
        for (int position = 0; position< mealsName.length; position++){
            Noodels noodels = new Noodels();
            noodels.setNama(mealsName[position]);
            noodels.setDesc(mealsDesc[position]);
            noodels.setPhoto(mealsImages[position]);
            noodelslist.add(noodels);
        }
        return noodelslist;
    }
}
