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
public class bill_payment extends Fragment {

    public WebView billpay;
    public bill_payment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v= inflater.inflate(R.layout.fragment_bill_payment, container, false);
        billpay = (WebView) v.findViewById(R.id.billpay);
        billpay.loadUrl("http://"+StartupScreen.ipval+"/eba/android/billnew.php?consumerno="+BackgroundTask.number);
        WebSettings webSettings = billpay.getSettings();
        webSettings.setJavaScriptEnabled(true);
        billpay.setWebViewClient(new WebViewClient());
        return v;
    }
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Pay Bill");
    }
}
