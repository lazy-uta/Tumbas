package com.dicodingtraining.tumbas.Data;

import com.dicodingtraining.tumbas.Model.Angkringans;
import com.dicodingtraining.tumbas.R;

import java.util.ArrayList;

public class AngkringansData {

    private static String[] mealsName = {
            "Angkringan Wijilan",
            "Angkringan KR",
            "Angkringan Pak Man"

    };

    private static String[] mealsDesc = {
            "jl, Wijilan 25 Yk",
            "jl, Kadipaten Malioboro YK",
            "jl. Kadipaten 88 YK"
    };

    private static int[] mealsImages = {
            R.drawable.hd_angwijilan,
            R.drawable.hed_angkr,
            R.drawable.hd_pkman
    };

    public static ArrayList<Angkringans> getListData(){
        ArrayList<Angkringans> angkringanslist = new ArrayList<>();
        for (int position = 0; position< mealsName.length; position++){
            Angkringans angkringans = new Angkringans();
            angkringans.setNama(mealsName[position]);
            angkringans.setDesc(mealsDesc[position]);
            angkringans.setPhoto(mealsImages[position]);
            angkringanslist.add(angkringans);
        }
        return angkringanslist;
    }
}
