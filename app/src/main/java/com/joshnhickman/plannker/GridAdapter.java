package com.joshnhickman.plannker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class GridAdapter extends BaseAdapter {
    private Context context;
    private final String[] numbers;

    public GridAdapter(Context context, String[] mobileValues) {
        this.context = context;
        this.numbers = mobileValues;
    }

    @Override
    public int getCount() {
        return numbers.length;
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View gridView;
        if (view == null) {
            gridView = inflater.inflate(R.layout.number, null);
            TextView textView = (TextView) gridView.findViewById(R.id.grid_number_textview);
            textView.setText(numbers[i]);

        } else {
            gridView = view;
        }
        return gridView;
    }
}
