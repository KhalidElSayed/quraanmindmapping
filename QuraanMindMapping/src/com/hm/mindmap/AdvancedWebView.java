package com.hm.mindmap;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.webkit.WebView;

public class AdvancedWebView extends Activity {

	public static Context CONTEXT;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.detail_web);

		CONTEXT = this;

		initWebView();
	}

	private void initWebView() {
		WebView webView = (WebView) findViewById(R.id.webview);
		webView.getSettings().setSupportZoom(true);
		webView.getSettings().setJavaScriptEnabled(true);

		webView.addJavascriptInterface(new JSInterface(), "jsinterface");
		webView.loadUrl("file:///android_asset/html/sample.html");
	}
}
