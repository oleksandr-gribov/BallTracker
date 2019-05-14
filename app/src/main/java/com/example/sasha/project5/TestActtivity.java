package com.example.sasha.project5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TestActtivity extends AppCompatActivity {
    TextView test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_acttivity);
        test = findViewById(R.id.test);

        RelativeLayout myLayout = (RelativeLayout) findViewById(R.id.relative_layout);

        myLayout.setOnTouchListener(new RelativeLayout.OnTouchListener(){

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
                test.setText(actionCalled);
            }

        });
    }
}

