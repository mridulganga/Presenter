package com.example.mridul.presenter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnnext = (Button) findViewById(R.id.present_next);
        Button btnprev = (Button) findViewById(R.id.present_previous);
        Button btnup = (Button) findViewById(R.id.present_up);
        Button btndown = (Button) findViewById(R.id.present_down);

        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
                String present_name = ((EditText) findViewById(R.id.present_name)).getText().toString();
                mDatabase.child("presentations/" + present_name).setValue("next");
            }
        });
        btnprev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
                String present_name = ((EditText) findViewById(R.id.present_name)).getText().toString();
                mDatabase.child("presentations/" + present_name).setValue("previous");
            }
        });


        btnup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
                String present_name = ((EditText) findViewById(R.id.present_name)).getText().toString();
                mDatabase.child("presentations/" + present_name).setValue("up");
            }
        });

        btndown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
                String present_name = ((EditText) findViewById(R.id.present_name)).getText().toString();
                mDatabase.child("presentations/" + present_name).setValue("down");
            }
        });
     }
}
