package com.example.sasha.project5;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<String> allGestures;

    public ArrayList<String> getAllGestures() {
        return allGestures;
    }

    public void setAllGestures(ArrayList<String> allGestures) {
        this.allGestures = allGestures;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        allGestures = new ArrayList<>();




        // creating the fragment manager
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // adding the listView fragment
        TableViewFragment tvFragment = new TableViewFragment();
        Bundle b = new Bundle();
        b.putStringArrayList("gestures", allGestures);
        tvFragment.setArguments(b);

        fragmentTransaction.add(R.id.top_linearLayout, tvFragment);



        // adding the gesture fragment
        GestureFragment gestureFragment = new GestureFragment();
        fragmentTransaction.add(R.id.bottom_linearLayout, gestureFragment);
        fragmentTransaction.commit();
    }
}
