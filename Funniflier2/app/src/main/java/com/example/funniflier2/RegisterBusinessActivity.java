package com.example.funniflier2;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



import androidx.appcompat.app.AppCompatActivity;

public class RegisterBusinessActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_business);
        Button ok_button = (Button) findViewById(R.id.ok_button);
        ok_button.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v.getId() == R.id.ok_button) {
            Intent intent = new Intent(this, HomeBusinessActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}