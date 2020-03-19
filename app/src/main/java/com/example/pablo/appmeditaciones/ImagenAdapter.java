package com.example.pablo.appmeditaciones;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ImagenAdapter extends BaseAdapter {

    private Context mContext;
    private Integer[] mThumbIds = new Integer[Config.NUMERO_CARTAS];

    public ImagenAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(Config.ANCHO_CARTA, Config.ALTO_CARTA));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(Config.PADDING_CARTA, Config.PADDING_CARTA, Config.PADDING_CARTA, Config.PADDING_CARTA);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(R.drawable.reverso);
        return imageView;
    }
}