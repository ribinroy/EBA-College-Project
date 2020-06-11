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
public class bill_history extends Fragment {

    public WebView bill_his;
    public bill_history() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v= inflater.inflate(R.layout.fragment_bill_history, container, false);
        bill_his = (WebView) v.findViewById(R.id.bill_his);
        bill_his.loadUrl("http://"+StartupScreen.ipval+"/eba/android/billhistory.php?consumerno="+BackgroundTask.number);
        WebSettings webSettings = bill_his.getSettings();
        webSettings.setJavaScriptEnabled(true);
        bill_his.setWebViewClient(new WebViewClient());
        return v;
    }
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("History of bills");
    }
}
