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
public class status_complaint extends Fragment {
    public WebView webnewstatus;

    public status_complaint() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_status_complaint, container, false);
        webnewstatus = (WebView) v.findViewById(R.id.webnewstatus);
       // webnewstatus.loadUrl("http://192.168.43.13/eba/application/applicationform.php");
        webnewstatus.loadUrl("http://"+StartupScreen.ipval+"/eba/android/complaintsingleandro.php?consumerno="+BackgroundTask.number);
        WebSettings webSettings = webnewstatus.getSettings();
        webSettings.setJavaScriptEnabled(true);


        webnewstatus.setWebViewClient(new WebViewClient());

        return v;
    }
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Complaint Status");
    }
}
