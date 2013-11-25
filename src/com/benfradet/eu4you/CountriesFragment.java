package com.benfradet.eu4you;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CountriesFragment extends ContractListFragment<CountriesFragment.Contract> {
	private static final String STATE_CHECKED = "com.benfradet.eu4you.STATE_CHECKED";
	
	@Override
	public void onActivityCreated(Bundle state) {
		super.onActivityCreated(state);
		
		setListAdapter(new CountryAdapter());
		getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		
		if(state != null) {
			int position = state.getInt(STATE_CHECKED, -1);
			if(position > -1) {
				getListView().setItemChecked(position, true);
				getContract().onCountrySelected(Country.EU.get(position));
			}
		}
	}
	
	@Override
	public void onListItemClick(ListView listView, View view, int position, long id) {
		listView.setItemChecked(position, true);
		getContract().onCountrySelected(Country.EU.get(position));
	}
	
	@Override
	public void onSaveInstanceState(Bundle state) {
		super.onSaveInstanceState(state);
		state.putInt(STATE_CHECKED, getListView().getCheckedItemPosition());
	}
	
	class CountryAdapter extends ArrayAdapter<Country> {
		CountryAdapter() {
			super(getActivity(), R.layout.row, R.id.name, Country.EU);
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			CountryViewHolder wrapper = null;
			if(convertView == null) {
				convertView = LayoutInflater.from(getActivity()).inflate(R.layout.row, null);
				wrapper = new CountryViewHolder(convertView);
				convertView.setTag(wrapper);
			}
			else {
				wrapper = (CountryViewHolder)convertView.getTag();
			}
			wrapper.populateFrom(getItem(position));
			
			return convertView;
		}
	}
	
	interface Contract {
		void onCountrySelected(Country country);
	}
}
