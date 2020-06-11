package com.example.nadu.myapplication;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import static com.example.nadu.myapplication.R.id.worknotification;


/**
 * A simple {@link Fragment} subclass.
 */
public class workhistory extends Fragment {
    public WebView workhis;

    public workhistory() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_workhistory, container, false);
        workhis = (WebView) v.findViewById(R.id.workhis);
        workhis.loadUrl("http://"+StartupScreen.ipval+"/eba/android/linemanhistory.php?empno="+BackgroundTask.employeenumber);
        WebSettings webSettings = workhis.getSettings();
        webSettings.setJavaScriptEnabled(true);
        workhis.setWebViewClient(new WebViewClient());
        return v;

    }
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Work history");
    }
}
