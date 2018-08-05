package com.example.apple.fragmentsample;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MenuThanksFragment extends Fragment {

    private Activity parentActivity;

    public MenuThanksFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.parentActivity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_thanks, container, false);

        Intent intent = this.parentActivity.getIntent();
        Bundle bundle = intent.getExtras();

        String name = "";
        String price = "";
        if (bundle != null) {
            name = bundle.getString("name");
            price = bundle.getString("price");
        }

        ((TextView) view.findViewById(R.id.tvMenuName)).setText(name);
        ((TextView) view.findViewById(R.id.tvMenuPrice)).setText(price);

        view.findViewById(R.id.btBackButton).setOnClickListener(new ButtonClickListener());

        return view;
    }

    private class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            parentActivity.finish();
        }
    }
}
