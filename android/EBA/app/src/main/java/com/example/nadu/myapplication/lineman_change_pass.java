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
public class lineman_change_pass extends Fragment {

    public WebView line_change_pass;
    public lineman_change_pass() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v= inflater.inflate(R.layout.fragment_lineman_change_pass, container, false);

        line_change_pass = (WebView) v.findViewById(R.id.line_change_pass);
        line_change_pass.loadUrl("http://"+StartupScreen.ipval+"/eba/android/linemanpasswordchange.php?empno="+BackgroundTask.employeenumber);
        WebSettings webSettings = line_change_pass.getSettings();
        webSettings.setJavaScriptEnabled(true);
        line_change_pass.setWebViewClient(new WebViewClient());

        return v;
    }
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Change Password");
    }
}
