package com.example.funniflier2;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


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
            EditText ln = (EditText) findViewById(R.id.user_surname1);

            String name = nm.getText().toString() + " " + ln.getText().toString();


            DB db=DB.getInstance(this);
            User user=new User(email, password, name);

            try {
                db.userDao().insert(user);
                Intent intent = new Intent(this, HomeActivity.class);
                Bundle bundle = new Bundle();
                bundle.putLong("user_id", user.getId());
                startActivity(intent);
            } catch (Exception e){
                Toast.makeText(this, "Email already used", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}