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
public class complaint extends Fragment {
    public WebView webnewc;

    public complaint() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_complaint, container, false);
        webnewc = (WebView) v.findViewById(R.id.webnewc);
       // webnewc.loadUrl("http://192.168.43.13/eba/application/applicationform.php");
        webnewc.loadUrl("http://"+StartupScreen.ipval+"/eba/complaint/complaintform.php?consumerno="+BackgroundTask.number);
        WebSettings webSettings = webnewc.getSettings();
        webSettings.setJavaScriptEnabled(true);


        webnewc.setWebViewClient(new WebViewClient());

        return v;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Complaint Registration");
    }
}
