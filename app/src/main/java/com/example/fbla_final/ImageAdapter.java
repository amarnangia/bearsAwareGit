package com.example.fbla_final;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
public class ImageAdapter extends BaseAdapter {
    private Context imageContext;
    public int[] imageArray = {
            R.drawable.img111,R.drawable.img_2,R.drawable.img_3,R.drawable.img_4,R.drawable.img_5, R.drawable.img_6,

            R.drawable.img_7,R.drawable.img_8,R.drawable.img_9,R.drawable.img_10,
            R.drawable.img_11,R.drawable.img_22,R.drawable.img_13,R.drawable.img_14,R.drawable.img_15,
            R.drawable.img_16,R.drawable.img_17,R.drawable.img_18,R.drawable.img_19,R.drawable.img_23,
            R.drawable.img_21
    };
    public ImageAdapter (Context imageContext) {
        this.imageContext = imageContext;
    }
    @Override
    public int getCount() {
        return imageArray.length;
    }
    @Override
    public Object getItem(int position) {
        return imageArray[position];
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(imageContext);
        imageView.setImageResource(imageArray[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(340, 350));
        return imageView;
    }
}