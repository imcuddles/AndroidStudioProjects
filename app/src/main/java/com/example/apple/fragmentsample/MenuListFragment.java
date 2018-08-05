package com.example.apple.fragmentsample;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuListFragment extends Fragment {

    private Activity parentActivity;

    public MenuListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.parentActivity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_list, container, false);

        ListView LvMenu = view.findViewById(R.id.lvMenu);

        List<Map<String, String>> menuList = new ArrayList<>();

        HashMap<String, String> item = new HashMap<>();
        item.put("name", "唐揚げ定食");
        item.put("price", "850円");
        menuList.add(item);

        item = new HashMap<>();
        item.put("name", "焼肉げ定食");
        item.put("price", "950円");
        menuList.add(item);

        String[] from = {"name", "price"};
        int[] to = {android.R.id.text1, android.R.id.text2};

        SimpleAdapter adapter = new SimpleAdapter(this.parentActivity, menuList, android.R.layout.simple_list_item_2, from, to);
        LvMenu.setAdapter(adapter);
        LvMenu.setOnItemClickListener(new ListItemClickListener());

        return view;
    }

    private class ListItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Map<String, String> item = (Map<String, String>) adapterView.getItemAtPosition(i);

            String name = item.get("name");
            String price = item.get("price");

            Intent intent = new Intent(parentActivity, MenuThanksActivity.class);
            intent.putExtra("name", name);
            intent.putExtra("price", price);

            startActivity(intent);
        }
    }

}
