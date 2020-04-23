package com.example.fragmentlist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ItemFragment extends Fragment {

    private TextView text;

    private String message = "You clicked on: ";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_layout, container, false);
        text = view.findViewById(R.id.itemText);
        Bundle bundle = this.getArguments();
        String data = bundle.getString("key");
        text.setText(message + data);
        return view;
    }
}
