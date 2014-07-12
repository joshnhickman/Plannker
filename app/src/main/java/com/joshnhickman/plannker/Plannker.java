package com.joshnhickman.plannker;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;


public class Plannker extends Activity {
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plannker);

        recycler = (RecyclerView) findViewById(R.id.recycler_view);

        // Improve performance
        recycler.setHasFixedSize(true);

        // Use a linear layout manager
        manager = new GridLayoutManager(this);
        recycler.setLayoutManager(manager);

        final String[] dataset = new String[]{
                "0","1","2","3","5","8","13","20"
        };

        // Specify adapter
        adapter = new MyAdapter(dataset);
        recycler.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.plannker, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
