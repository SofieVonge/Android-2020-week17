package com.example.fragmentlist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

public class ListFragment extends Fragment {

    private ListView listView;
    private ArrayAdapter<String> arrayAdapter;
    private ArrayList<String> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_layout, container, false);
        list.add("Some data");
        list.add("Some more data");
        list.add("Even more data");
        listView = view.findViewById(R.id.listView);
        arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, list);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(((parent, view1, position, id) -> {
            Bundle bundle = new Bundle();
            bundle.putString("key", list.get(position));
            ItemFragment fragment = new ItemFragment();
            fragment.setArguments(bundle);
            getFragmentManager().beginTransaction().replace(R.id.frame, fragment).commit();
        }));

        return view;
    }
}
