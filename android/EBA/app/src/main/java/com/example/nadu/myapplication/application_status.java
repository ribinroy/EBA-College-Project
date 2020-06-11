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
public class application_status extends Fragment {

    public WebView application_sts;
    public application_status() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.fragment_application_status, container, false);
        application_sts = (WebView) v.findViewById(R.id.application_sts);
        application_sts.loadUrl("http://"+StartupScreen.ipval+"/eba/android/applicationsinglestatus.php?consumerno="+BackgroundTask.number);
        WebSettings webSettings = application_sts.getSettings();
        webSettings.setJavaScriptEnabled(true);
        application_sts.setWebViewClient(new WebViewClient());
        return v;
    }
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Application status");
    }
}
