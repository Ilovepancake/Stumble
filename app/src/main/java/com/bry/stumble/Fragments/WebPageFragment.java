package com.bry.stumble.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bry.stumble.R;

public class WebPageFragment extends Fragment {
    private int mPageNo;
    private Context mContext;

    public void setPageNo(int no){
        this.mPageNo = no;
    }

    public void setContext(Context context){
        this.mContext = context;
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.webpage_fragment, container, false);
        TextView tvLabel =  view.findViewById(R.id.textPart);
        tvLabel.setText("page" + mPageNo);
        return view;
    }
}
