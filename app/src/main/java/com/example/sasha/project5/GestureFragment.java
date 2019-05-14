package com.example.sasha.project5;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sasha.project5.R;

public class GestureFragment extends Fragment  {
    Button sensor;
    RelativeLayout myLayout;
    TextView test;
    Button testActivity;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         View view = inflater.inflate(R.layout.gesture_fragment,container,false);

         view.setOnTouchListener(new RelativeLayout.OnTouchListener(){

             @Override
             public boolean onTouch(View v, MotionEvent event) {

                 handleUserTouch(event);
                 return true;
             }

             private void handleUserTouch(MotionEvent event) {
                String actionCalled;
                int action = event.getActionMasked();

                switch(action) {
                    case MotionEvent.ACTION_DOWN:
                        actionCalled = "Down";
                        break;
                    case MotionEvent.ACTION_UP:
                        actionCalled = "UP";
                        break;
                    case MotionEvent.ACTION_POINTER_DOWN:
                        actionCalled = "Pointer Down";
                        break;
                    case MotionEvent.ACTION_POINTER_UP:
                        actionCalled = "Pointer Up";
                        break;
                    case MotionEvent.ACTION_MOVE:
                        actionCalled = "Move";
                        break;
                    default:
                        actionCalled = "None";
                        break;
             }
                 MainActivity.allGestures.add(actionCalled);
                TableViewFragment.myAdapter.notifyDataSetChanged();

             }

         });


         sensor = view.findViewById(R.id.sensorButton);
         sensor.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent i = new Intent(getContext(), SecondActivity.class);
                 startActivity(i);
             }
         });

         return view;
    }
}
