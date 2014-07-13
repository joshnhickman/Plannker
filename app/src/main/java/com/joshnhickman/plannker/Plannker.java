package com.joshnhickman.plannker;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.GridView;


public class Plannker extends Activity {
    public static final String EXTRA_MESSAGE = "com.joshnhickman.plannker.NUMBER";
    private static final String[] numbers = new String[] {
            "0","1","2","3","5","8","13","20","40","100"
    };

    private Context context;
    private Plannker plannker;
    private View lastNumberView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        plannker = this;

        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);

        setContentView(R.layout.activity_plannker);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new GridAdapter(this, numbers));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Intent intent = new Intent(context, NumberDisplayActivity.class);
                intent.putExtra(EXTRA_MESSAGE, numbers[position]);
                v.setViewName("number");
                lastNumberView = v;
                System.out.println(v.getId());
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(plannker, v, "number");
                startActivityForResult(intent, 1, options.toBundle());
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            lastNumberView.setViewName("null");
        }
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
