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


/**
 * A simple {@link Fragment} subclass.
 */
public class consumer_help extends Fragment {
    public WebView help;

    public consumer_help() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_consumer_help, container, false);
        help = (WebView) v.findViewById(R.id.help);
        help.loadUrl("http://"+StartupScreen.ipval+"/eba/android/help.php");
        WebSettings webSettings = help.getSettings();
        webSettings.setJavaScriptEnabled(true);
        help.getSettings().setDomStorageEnabled(true);
        help.setWebViewClient(new WebViewClient());
        return v;
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Help");
    }
}
