package com.example.funniflier2;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import androidx.appcompat.app.AppCompatActivity;

import com.example.funniflier2.db.DB;
import com.example.funniflier2.db.User;

public class RegisterCustomerActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_customer);
        Button ok_button = (Button) findViewById(R.id.ok_button);
        ok_button.setOnClickListener(this);

    }

    public void onClick(View v) {
        if (v.getId() == R.id.ok_button) {
            EditText em = (EditText) findViewById(R.id.user_email);
            String email = em.getText().toString();
            EditText pw = (EditText) findViewById(R.id.user_password);
            String password = pw.getText().toString();
            EditText nm = (EditText) findViewById(R.id.user_name);
            String name = nm.getText().toString();
            DB db=DB.getInstance(this);
            User user=new User(1, email, password, name);

            db.userDao().insert(user);
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}