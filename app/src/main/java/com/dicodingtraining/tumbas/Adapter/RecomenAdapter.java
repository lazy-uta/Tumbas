package com.dicodingtraining.tumbas.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.dicodingtraining.tumbas.BasicActivity.RestoActivity;
import com.dicodingtraining.tumbas.R;

public class RecomenAdapter extends PagerAdapter {

    public Integer [] images = {R.drawable.sample_pict,R.drawable.sample_image2,R.drawable.sample_image3};
    private LayoutInflater layoutInflater;
    private Context context;

    public RecomenAdapter(Context context){
        this.context = context;
    }

    public static void setCurrentItem(int pagerIndex) {
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
        View view = layoutInflater.inflate(R.layout.item_view_pager_recomend, null);
        final ImageView imageView = view.findViewById(R.id.img_Recommend);
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
