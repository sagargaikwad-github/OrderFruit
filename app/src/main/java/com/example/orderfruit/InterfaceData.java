package com.example.orderfruit;

import android.view.View;
import android.widget.AdapterView;

public interface InterfaceData {
    void onItemSelected(AdapterView<?> adapterView, View view, int i, long l);

    void onNothingSelected(AdapterView<?> adapterView);

    void Favourite_fruite(int id, int val);


}

