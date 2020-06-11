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

import static com.example.nadu.myapplication.R.id.webnotification;


/**
 * A simple {@link Fragment} subclass.
 */
public class works extends Fragment {
    public WebView worknotification;

    public works() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v= inflater.inflate(R.layout.fragment_works, container, false);
       worknotification = (WebView) v.findViewById(R.id.worknotification);
        worknotification.loadUrl("http://"+StartupScreen.ipval+"/eba/android/linemanwork.php?empno="+BackgroundTask.employeenumber);
        WebSettings webSettings = worknotification.getSettings();
        webSettings.setJavaScriptEnabled(true);
        worknotification.setWebViewClient(new WebViewClient());
        return v;

    }
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Works");
    }
}
