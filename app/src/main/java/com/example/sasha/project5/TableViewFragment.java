package com.example.sasha.project5;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;



import java.util.ArrayList;

public class TableViewFragment extends Fragment {
    ArrayList<String> allGestures;
    ListView mylistView;
    public static ArrayAdapter<String> myAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.table_view_fragment,container, false);
        if (getArguments().getStringArrayList("gestures")!= null) {
            allGestures = getArguments().getStringArrayList("gestures");

        }
        mylistView = (ListView) view.findViewById(R.id.list_view);
        mylistView.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);

        populateListView();
        return view;
    }

    private void populateListView() {

        myAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, allGestures);
        mylistView.setAdapter(myAdapter);

    }

    @Override
    public void onResume() {
        super.onResume();
        myAdapter.notifyDataSetChanged();
    }

}
