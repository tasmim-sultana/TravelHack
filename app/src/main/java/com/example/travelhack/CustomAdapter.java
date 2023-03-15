package com.example.travelhack;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    int[] placeImg;
    String[] placeName;
    Context context;
    private LayoutInflater inflater;
    CustomAdapter(Context context,String[] placeName, int[] placeImg )
    {
        this.placeImg= placeImg;
        this.placeName= placeName;
        this.context= context;
    }
    @Override
    public int getCount() {
        return placeName.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.place, parent, false);
        }
        ImageView imageView=(ImageView) convertView.findViewById(R.id.imageViewId);
        TextView textView=(TextView) convertView.findViewById(R.id.textViewId);
        imageView.setImageResource(placeImg[position]);
        textView.setText(placeName[position]);
        return convertView;
    }
}
