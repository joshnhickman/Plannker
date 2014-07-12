package com.joshnhickman.plannker;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Josh on 7/12/2014.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private String[] dataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ViewHolder(View v) {
            super(v);
            textView = (TextView) v;
        }
    }

    public MyAdapter(String[] dataset) {
        this.dataset = dataset;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_text_view, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    /**
     * Replace the contents of a view (invoked by the layout manager)
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // Get element from dataset at this position
        // Set contents of the view with that element
        holder.textView.setText(dataset[position]);
    }

    /**
     * Return the size of the dataset (invoked by the layout manager)
     * @return the size of the dataset
     */
    @Override
    public int getItemCount() {
        return dataset.length;
    }
}
