package com.example.bookapp.seller;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;

import com.example.bookapp.AlertManager;
import com.example.bookapp.JavaScriptReceiver;
import com.example.bookapp.R;
import com.example.bookapp.SessionManager;
import com.example.bookapp.URLs;
import com.example.bookapp.buyer.chat_buyer;
import com.google.android.material.navigation.NavigationView;


public class chat_seller_list extends BaseActivity {

    private SessionManager session;
    private AlertManager alert;
    private String with_admin = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout contentFrameLayout = (FrameLayout) findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.web_interface, contentFrameLayout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.getMenu().getItem(0).setChecked(true);

        alert = new AlertManager(this);
        session = new SessionManager(getApplicationContext());

        WebView webView = (WebView) findViewById(R.id.webbiew);


        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);


        JavaScriptReceiver javaScriptReceiver;
        javaScriptReceiver = new JavaScriptReceiver(chat_seller_list.this);
        webView.addJavascriptInterface(javaScriptReceiver, "JSReceiver");

        String seller_id = session.getUserID();

        String url = URLs.CHATLIST +"?userType=te&seller_id="+seller_id;
        webView.loadUrl(url);

    }
    @Override
    public void onBackPressed(){
        Intent i = new Intent(getApplicationContext(), booksList.class);
        startActivity(i);
    }


    @Override
    public void onStart() {
        super.onStart();
    }
}
