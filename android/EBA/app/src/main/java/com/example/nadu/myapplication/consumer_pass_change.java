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
public class consumer_pass_change extends Fragment {

    public WebView consumer_change_pass;
    public consumer_pass_change() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v= inflater.inflate(R.layout.fragment_consumer_pass_change, container, false);

        consumer_change_pass= (WebView) v.findViewById(R.id.consumer_change_pass);
        consumer_change_pass.loadUrl("http://"+StartupScreen.ipval+"/eba/android/consumerpasswordchange.php?consumerno="+BackgroundTask.number);
        WebSettings webSettings = consumer_change_pass.getSettings();
        webSettings.setJavaScriptEnabled(true);
        consumer_change_pass.setWebViewClient(new WebViewClient());

        return v;
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Change Password");
    }
}
