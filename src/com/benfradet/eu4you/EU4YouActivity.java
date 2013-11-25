package com.benfradet.eu4you;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SlidingPaneLayout;

import com.actionbarsherlock.app.SherlockFragmentActivity;

public class EU4YouActivity extends SherlockFragmentActivity implements CountriesFragment.Contract {
	private SlidingPaneLayout panes = null;
	private DetailsFragment details = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		details = (DetailsFragment)getSupportFragmentManager().findFragmentById(R.id.details);
		panes = (SlidingPaneLayout)findViewById(R.id.panes);
		panes.openPane();
	}
	
	@Override
	public void onBackPressed() {
		if(panes.isOpen()) {
			super.onBackPressed();
		}
		else {
			panes.openPane();
		}
	}
	
	@Override
	public void onCountrySelected(Country country) {
		details.loadUrl(getString(country.url));
		panes.closePane();
	}
}
