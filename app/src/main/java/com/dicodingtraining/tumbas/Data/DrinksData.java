package com.dicodingtraining.tumbas.Data;

import com.dicodingtraining.tumbas.Model.Drinks;
import com.dicodingtraining.tumbas.R;

import java.util.ArrayList;

public class DrinksData {
    private static String[] mealsName = {
            "susu Grande",
            "Ice Milk shake",
            "coffee latte milk",
            "Vanilla Milk ",
            "Oreo Milk, Leci Milk , Greentea Milk ",
            "Black Coffee",
            "Chapucino",
            "Moccachino ",
            "Vietnam Coffee"
    };

    private static String[] mealsDesc = {
            "milk shake + chcholate",
            "Ice Vanilla + Milk Shake",
            "Milk Shake + ice coffee",
            "Milk + vanilla",
            "Milk with Oreo/leci/greentea",
            "coffee form sulawesi",
            "coffee gitu lah",
            "ini juga gitu ",
            "kalau ini agak gitu"
    };

    private static int[] mealsImages = {
            R.drawable.drink1,
            R.drawable.drink2,
            R.drawable.drink3,
            R.drawable.drink4,
            R.drawable.drink5,
            R.drawable.drink6,
            R.drawable.coffe1,
            R.drawable.coffee2,
            R.drawable.coffee3,
            R.drawable.coffee4,
    };
    public static ArrayList<Drinks> getListData(){
        ArrayList<Drinks> drinkslist = new ArrayList<>();
        for (int position = 0; position< mealsName.length; position++){
            Drinks drinks = new Drinks();
            drinks.setNama(mealsName[position]);
            drinks.setDesc(mealsDesc[position]);
            drinks.setPhoto(mealsImages[position]);
            drinkslist.add(drinks);
        }
        return drinkslist;
    }
}
