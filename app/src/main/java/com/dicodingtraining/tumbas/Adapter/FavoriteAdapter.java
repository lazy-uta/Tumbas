package com.dicodingtraining.tumbas.Adapter;

import android.content.Context;
import android.content.Intent;
import android.icu.util.ValueIterator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.dicodingtraining.tumbas.BasicActivity.RestoActivity;
import com.dicodingtraining.tumbas.Model.Favorite;
import com.dicodingtraining.tumbas.R;

import java.util.List;

public class FavoriteAdapter extends PagerAdapter {

    public Integer [] images = {R.drawable.hd_gacoan,R.drawable.hd_chickencrush,R.drawable.hd_mienyiyir};
    private LayoutInflater layoutInflater;
    private Context context;

    public FavoriteAdapter(Context context){
        this.context = context;
    }


    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.item_view_pager_header_shimmer, null);
        final ImageView imageView = view.findViewById(R.id.img_Favorite);
        imageView.setImageResource(images[position]);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(imageView.getContext(), RestoActivity.class);
                intent.putExtra("Header", images[position]);
                imageView.getContext().startActivity(intent);
            }
        });


        ViewPager vp = (ViewPager) container;
        vp.addView(view,0);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);

    }


}
