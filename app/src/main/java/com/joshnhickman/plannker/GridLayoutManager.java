package com.joshnhickman.plannker;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Created by Josh on 7/12/2014.
 */
public class GridLayoutManager extends RecyclerView.LayoutManager {

    public GridLayoutManager(Context context) {}

    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        super.onLayoutChildren(recycler, state);
    }
}
