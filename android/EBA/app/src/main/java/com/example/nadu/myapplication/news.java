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
public class news extends Fragment {
    public WebView webnotification;

    public news() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_news, container, false);
        webnotification = (WebView) v.findViewById(R.id.webnotification);
       // webnews.loadUrl("http://192.168.43.13/eba/application/applicationform.php");
        webnotification.loadUrl("http://"+StartupScreen.ipval+"/eba/android/notifications.php?consumerno="+BackgroundTask.number);
        WebSettings webSettings = webnotification.getSettings();

        //webSettings.setJavaScriptEnabled(true);
        webnotification.getSettings().setDomStorageEnabled(true);

        webnotification.setWebViewClient(new WebViewClient());

        return v;
    }
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Notification");
    }
}
