package com.mypwa.webview

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    private lateinit var webView: WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        webView = WebView(this)

        // Web settings
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true

        // Open links inside the app
        webView.webViewClient = WebViewClient()

        // इथे तुझी Netlify PWA URL
        webView.loadUrl("https://milind-singstar.netlify.app")

        setContentView(webView)
    }

    override fun onBackPressed() {
        // webview मध्ये मागे जाण्यासाठी
        if (this::webView.isInitialized && webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}
