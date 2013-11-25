package com.benfradet.eu4you;

import android.app.Activity;

import com.actionbarsherlock.app.SherlockListFragment;

public class ContractListFragment<T> extends SherlockListFragment {
	private T contract;

	@SuppressWarnings("unchecked")
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		
		try {
			contract = (T)activity;
		}
		catch (ClassCastException ex) {
			throw new IllegalStateException(activity.getClass().getSimpleName() 
					+ " does not implement contract interface for "
					+ getClass().getSimpleName(), ex);
		}
	}
	
	@Override
	public void onDetach() {
		super.onDetach();
		contract = null;
	}
	
	public final T getContract() {
		return contract;
	}
}
