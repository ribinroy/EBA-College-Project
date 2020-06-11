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


public class new_connection extends Fragment {
    public WebView webnew;

    public new_connection() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v= inflater.inflate(R.layout.fragment_new_connection, container, false);
       webnew = (WebView) v.findViewById(R.id.webnew);
        webnew.loadUrl("http://"+StartupScreen.ipval+"/eba/application/applicationform.php?consumerno="+BackgroundTask.number);

        WebSettings webSettings = webnew.getSettings();
        webSettings.setJavaScriptEnabled(true);


        webnew.setWebViewClient(new WebViewClient());

        return v;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("New connection");
    }
}
