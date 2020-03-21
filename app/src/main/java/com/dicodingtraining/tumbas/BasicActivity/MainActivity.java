package com.dicodingtraining.tumbas.BasicActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;

import android.app.NotificationManager;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MenuItem;

import com.dicodingtraining.tumbas.Fragment.BarcodeFragment;
import com.dicodingtraining.tumbas.Fragment.DiscountFragment;
import com.dicodingtraining.tumbas.Fragment.HomeFragment;
import com.dicodingtraining.tumbas.Fragment.InvoiceFragment;
import com.dicodingtraining.tumbas.Fragment.ProfileFragment;
import com.dicodingtraining.tumbas.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(new HomeFragment());

        BottomNavigationView bottomNavigationView = findViewById(R.id.navigationview);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);


    }




    private boolean loadFragment(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .commit();
            return true;
    }
    return false;}

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;

        switch (menuItem.getItemId()){
            case R.id.home_menu:
                fragment = new HomeFragment();
                break;
            case R.id.invoice_menu:
                fragment = new InvoiceFragment();
                break;
            case R.id.discount_menu:
                fragment = new DiscountFragment();
                break;
            case R.id.account_menu:
                fragment = new ProfileFragment();
                break;
        }
        return loadFragment(fragment);
    }



}
