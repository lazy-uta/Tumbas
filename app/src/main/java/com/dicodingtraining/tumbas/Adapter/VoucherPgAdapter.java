package com.dicodingtraining.tumbas.Adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import com.dicodingtraining.tumbas.ChildFragment.ChildoneFragment;
import com.dicodingtraining.tumbas.ChildFragment.ChildtwoFragment;

import java.util.ArrayList;
import java.util.List;

public class VoucherPgAdapter extends FragmentStatePagerAdapter {

  private List<Fragment> fragmentList = new ArrayList<>();
  private List<String> tittleList = new ArrayList<>();

    public VoucherPgAdapter(FragmentManager fm){
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tittleList.get(position);
    }

    public void addFragment(Fragment fragment, String title){
        fragmentList.add(fragment);
        tittleList.add(title);

    }
}
