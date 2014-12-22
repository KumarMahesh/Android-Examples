package com.example.maheh.multipaneuiexample;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;

/**
 * Created by maheh on 17/12/14.
 */
public class DetailActivity extends Activity {
    public static String os_name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }
        setContentView(R.layout.detail_activity);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String name = extras.getString(os_name);
            DetailFragment detailFragment = (DetailFragment) getFragmentManager()
                    .findFragmentById(R.id.detailFragment);
            detailFragment.setText(name);
        }

    }
}
