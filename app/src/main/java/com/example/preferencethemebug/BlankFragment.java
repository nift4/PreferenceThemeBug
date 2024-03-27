package com.example.preferencethemebug;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BlankFragment extends Fragment {

	public BlankFragment() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_blank, container, false);
	}

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		Button button = view.findViewById(R.id.button);
		button.setOnClickListener(v -> {
			getParentFragmentManager()
					.beginTransaction()
					.addToBackStack("test")
					.replace(R.id.container, new SettingsFragment())
					.commit();

		});
		TextView helloWorld = view.findViewById(R.id.helloWorld);
		helloWorld.setText(helloWorld.isVerticalScrollBarEnabled() ? "VERTICAL SCROLLBAR ENABLED :("
				: "VERTICAL SCROLLBAR DISABLED :)");
		if (helloWorld.isVerticalScrollBarEnabled()) {
			// Bug reproduced, we don't need the button anymore.
			button.setVisibility(View.GONE);
		}
	}
}