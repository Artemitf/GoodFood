package com.example.GoodFood;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.afinal.R;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class BlankFragment3 extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank3, container, false);
        ListView resultsListView = view.findViewById(R.id.listtest);

        String[] nazvanie_array = getResources().getStringArray(R.array.nazvanie_array);
        String[] tren_array = getResources().getStringArray(R.array.tren_array);


        HashMap<String, String> nameTren = new HashMap<>();
        nameTren.put(nazvanie_array[0], tren_array[0]);
        nameTren.put(nazvanie_array[1], tren_array[1]);
        nameTren.put(nazvanie_array[2], tren_array[2]);
        nameTren.put(nazvanie_array[3], tren_array[3]);
        nameTren.put(nazvanie_array[4], tren_array[4]);
        nameTren.put(nazvanie_array[5], tren_array[5]);
        nameTren.put(nazvanie_array[6], tren_array[6]);
        nameTren.put(nazvanie_array[7], tren_array[7]);
        nameTren.put(nazvanie_array[8], tren_array[8]);
        nameTren.put(nazvanie_array[9], tren_array[9]);



        List<HashMap<String, String>> listItems = new ArrayList<>();
        SimpleAdapter adapter = new SimpleAdapter(getActivity(), listItems, R.layout.list_item,
                new String[]{"First Line", "Second Line"},
                new int[]{R.id.text1, R.id.text2});


        for (Map.Entry<String, String> stringStringEntry : nameTren.entrySet()) {
            HashMap<String, String> resultsMap = new HashMap<>();
            Map.Entry pair = (Map.Entry) stringStringEntry;
            resultsMap.put("First Line", pair.getKey().toString());
            resultsMap.put("Second Line", pair.getValue().toString());
            listItems.add(resultsMap);
        }
        resultsListView.setAdapter(adapter);

        return view;

    }
}