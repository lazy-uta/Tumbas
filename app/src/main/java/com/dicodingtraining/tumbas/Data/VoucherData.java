package com.dicodingtraining.tumbas.Data;

import com.dicodingtraining.tumbas.Model.Vouchers;
import com.dicodingtraining.tumbas.R;

import java.util.ArrayList;

public class VoucherData {

    public static int[] Images = {
            R.drawable.voucher_burgerking,
            R.drawable.voucher_gacoan,
            R.drawable.voucher_mcd,
            R.drawable.voucher_tumbasss,
            R.drawable.voucher_tumbasss_2

    };

    public static ArrayList<Vouchers> getListData(){
        ArrayList<Vouchers> list = new ArrayList<>();
        for (int position = 0; position< Images.length; position++){
            Vouchers vouchers = new Vouchers();
            vouchers.setPhotos(Images[position]);
            list.add(vouchers);
        }
        return list;
    }
}
