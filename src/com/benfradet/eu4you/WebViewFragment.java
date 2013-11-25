	package com.benfradet.eu4you;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.actionbarsherlock.app.SherlockFragment;

public class WebViewFragment extends SherlockFragment {
	private WebView webView;
	private boolean isWebViewAvailable;

	public WebViewFragment() {
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if(webView != null) {
			webView.destroy();
		}
		webView = new WebView(getActivity());
		isWebViewAvailable = true;
		return webView;
	}
	
	@TargetApi(11)
	@Override
	public void onPause() {
		super.onPause();
		if(Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) {
			webView.onPause();
		}
	}
	
	@TargetApi(11)
	@Override
	public void onResume() {
		if(Build.VERSION.SDK_INT > Build.VERSION_CODES.HONEYCOMB) {
			webView.onResume();
		}
		super.onResume();
	}
	
	@Override
	public void onDestroyView() {
		isWebViewAvailable = false;
		super.onDestroyView();
	}
	
	@Override
	public void onDestroy() {
		if(webView != null) {
			webView.destroy();
			webView = null;
		}
		super.onDestroy();
	}
	
	public WebView getWebView() {
		return isWebViewAvailable ? webView : null;
	}
}
