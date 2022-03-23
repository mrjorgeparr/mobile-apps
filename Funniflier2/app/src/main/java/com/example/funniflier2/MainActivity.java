package com.example.funniflier2;


import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;




public class MainActivity extends AppCompatActivity implements View.OnClickListener {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        switch (v.getId()) {
            case  R.id.button1:
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                break;
            case  R.id.button2:
                Intent intent2 = new Intent(this, LoginActivity.class);
                startActivity(intent2);
                break;
            default:
                break;
        }


    }


}

