package com.example.nadu.myapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


/**
 * A simple {@link Fragment} subclass.
 */
public class chumma extends Fragment {

public WebView webb;
    public chumma() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v= inflater.inflate(R.layout.fragment_chumma, container, false);

        webb = (WebView) v.findViewById(R.id.webb);
        // webnews.loadUrl("http://192.168.43.13/eba/application/applicationform.php");
        webb.loadUrl("http://"+StartupScreen.ipval+"/eba/android/notifications.php?consumerno="+BackgroundTask.number);
        WebSettings webSettings = webb.getSettings();

        webSettings.setJavaScriptEnabled(true);
    //    webnotification.getSettings().setDomStorageEnabled(true);

      webb.setWebViewClient(new WebViewClient());


        return v;
    }

}
