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
            EditText ed = (EditText) findViewById(R.id.user_email);
            String email = ed.getText().toString();
            User user=new User(1, email, "user_password", "user_name");
            DB db=DB.getInstance(this);
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