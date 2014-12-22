package com.example.maheh.multipaneuiexample;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by maheh on 17/12/14.
 */
public class DetailFragment extends Fragment{
    public static String os_name = "DATA";
    String item = null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detail_fragment,container,false);
        Bundle args = getArguments();
        if(args != null)
        item = args.getString(os_name);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if(item != null)
        setText(item);
    }

    public void setText(String item) {
        TextView view = (TextView) getView().findViewById(R.id.display_tv);
        view.setText(item);
    }
}
