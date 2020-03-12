package com.example.spacetablayout.sliders;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.spacetablayout.R;

import java.util.List;

public class SlideAdapter extends PagerAdapter {
    private Context context;
    private List<Integer> listImage;
    private List<String> listDescription;


    // Liste d'images
    /*private int[] list_image = {
            R.drawable.presentation,
            R.drawable.presentation,
            R.drawable.presentation
    };

    private int[] list_description = {
            R.string.slide1,
            R.string.slide2,
            R.string.slide3
    };*/

    SlideAdapter(Context context1,
                 List<Integer> listImage,
                         List<String> listDescription){
        this.context = context1;
        this.listImage = listImage;
        this.listDescription = listDescription;
    }
    @Override
    public int getCount() {
        return listImage.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view == object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        View view = inflater.inflate(R.layout.image_sliding,container,false);
        LinearLayout layoutSlide = view.findViewById(R.id.slideLinear);

        ImageView image_slide = view.findViewById(R.id.slide_img);
        TextView text_description = view.findViewById(R.id.description);

        image_slide.setImageResource(listImage.get(position));
        text_description.setText(listDescription.get(position));
        container.addView(view, 0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((LinearLayout)object);
    }
}
