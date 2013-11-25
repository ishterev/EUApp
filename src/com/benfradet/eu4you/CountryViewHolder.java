package com.benfradet.eu4you;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CountryViewHolder {
	private TextView name = null;
	private ImageView flag = null;

	public CountryViewHolder(View row) {
		name = (TextView)row.findViewById(R.id.name);
		flag = (ImageView)row.findViewById(R.id.flag);
	}
	
	TextView getName() {
		return name;
	}
	
	ImageView getFlag() {
		return flag;
	}
	
	void populateFrom(Country country) {
		getName().setText(country.name);
		getFlag().setImageResource(country.flag);
	}
}
