package com.example.maheh.multipaneuiexample;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends Activity implements MyListFragment.Communicator{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void Message(String OS_Name) {
        DetailFragment detailfragment = (DetailFragment) getFragmentManager()
                .findFragmentById(R.id.detail_Fragment);
        if (detailfragment != null && detailfragment.isInLayout()) {
            detailfragment.setText(OS_Name);
        } else {
//            Intent intent = new Intent(getApplicationContext(),
//                    DetailActivity.class);
//            Bundle extras = new Bundle();
//            extras.putString(DetailActivity.os_name, OS_Name);
//            intent.putExtras(extras);
//            startActivity(intent);
            DetailFragment detailFragment = new DetailFragment();
            Bundle extras = new Bundle();
            extras.putString(DetailFragment.os_name,OS_Name);
            detailFragment.setArguments(extras);
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.portFrame, detailFragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
           // detailFragment.setText(OS_Name);


        }
    }
}
