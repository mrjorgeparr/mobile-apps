package com.example.funniflier2;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import androidx.appcompat.app.AppCompatActivity;

import com.example.funniflier2.db.DB;
import com.example.funniflier2.db.UserDao;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    // needs to be defined as a member value
    Button ok_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);
        Button ok_button = (Button) findViewById(R.id.ok_button);
        ok_button.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v.getId() == R.id.ok_button) {
            EditText em = (EditText) findViewById(R.id.user_email);
            String email = em.getText().toString();
            EditText pw = (EditText) findViewById(R.id.user_password);
            String password = pw.getText().toString();
            DB db=DB.getInstance(this);
            if (db.userDao().findByEmail(email)){
                Intent intent = new Intent(this, HomeActivity.class);
                startActivity(intent);
            }
            if (db.businessDao().findByEmail(email)){
                Intent intent2 = new Intent(this, HomeBusinessActivity.class);
                startActivity(intent2);
            }
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}