package com.example.maheh.multipaneuiexample;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by maheh on 17/12/14.
 */
public class MyListFragment extends Fragment implements View.OnClickListener {
    Button android_btn, ios_btn, windows_btn;
    private Communicator communicator;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);

        // Initialize Views
        android_btn = (Button) view.findViewById(R.id.android_btn_id);
        ios_btn = (Button) view.findViewById(R.id.ios_btn_id);
        windows_btn = (Button) view.findViewById(R.id.windows_btn_id);

        // set on click Listeners for buttons
        android_btn.setOnClickListener(this);
        ios_btn.setOnClickListener(this);
        windows_btn.setOnClickListener(this);

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof Communicator) {
            communicator = (Communicator) activity;
        } else {
            throw new ClassCastException(activity.toString()
                    + " must implemenet MyListFragment.Communicator");
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.android_btn_id:
                updateFragment("Android");
                break;

            case R.id.ios_btn_id:
                updateFragment("IOS");
                break;

            case R.id.windows_btn_id:
                updateFragment("Windows");
                break;
        }
    }

    //Create Interface
    public interface Communicator {
        public void Message(String OS_Name);
    }

    private void updateFragment(String OS_Name) {
        communicator.Message(OS_Name);
    }
}
