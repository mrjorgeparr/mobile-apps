package com.example.funniflier2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;


public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_main);
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);


        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.button1:
                setContentView(R.layout.register_business);
                break;

            case R.id.button2:
                setContentView(R.layout.register_customer);
                break;

            case R.id.ok_button:
                Toast.makeText(this, "lol", Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
    }
    
    private void registerBusiness()
    {
        TextView email = findViewById(R.id.user_email);
    }

}