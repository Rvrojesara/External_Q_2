package com.example.external_q_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class MainActivity extends AppCompatActivity {

    Button btnsave;

     Switch switch1,switch2,switch3,switch4,switch5,switch6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPreferences = getSharedPreferences("user_pref", Context.MODE_PRIVATE);
        boolean isLoggedIn = sharedPreferences.getBoolean("isSavedIn", false);

        setContentView(R.layout.activity_main);

        btnsave=findViewById(R.id.btnsave);
        switch1=findViewById(R.id.switch1);
        switch2=findViewById(R.id.switch2);
        switch3=findViewById(R.id.switch3);
        switch4=findViewById(R.id.switch4);
        switch5=findViewById(R.id.switch5);
        switch6=findViewById(R.id.switch6);


        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this);
                View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(
                        R.layout.bottom_sheet,null);
                bottomSheetDialog.setContentView(bottomSheetView);

                Button btn_yes = bottomSheetView.findViewById(R.id.btn_yes);
                btn_yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        bottomSheetDialog.dismiss();
                    }
                });
                bottomSheetDialog.show();
            }
        });
    }

}