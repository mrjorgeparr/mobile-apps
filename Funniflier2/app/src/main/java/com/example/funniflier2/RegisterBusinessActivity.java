package com.example.funniflier2;



import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.example.funniflier2.db.Business;
import com.example.funniflier2.db.DB;

public class RegisterBusinessActivity extends AppCompatActivity implements View.OnClickListener {
    // defines the button as a member of the class
    Button ok_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_business);
        ok_button = findViewById(R.id.ok_button);
        ok_button.setOnClickListener(this);
        //Button ok_button = (Button) findViewById(R.id.ok_button);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.ok_button) {
            EditText bem = (EditText) findViewById(R.id.business_email);
            String email = bem.getText().toString();
            EditText bpw = (EditText) findViewById(R.id.business_password);
            String password = bpw.getText().toString();
            EditText bnm = (EditText) findViewById(R.id.business_name);
            String name = bnm.getText().toString();
            EditText adr = (EditText) findViewById(R.id.business_address);
            String address = adr.getText().toString();
            EditText bsc = (EditText) findViewById(R.id.business_activity_schedule);
            String schedule = bsc.getText().toString();

            Switch is_hair = (Switch) findViewById(R.id.is_hairdresser);

            int is_hairdresser = 0;
            if (is_hair.isChecked()){
                is_hairdresser = 1;
            }
            DB db=DB.getInstance(this);

            try {
                Business business = new Business(name, email, password, address, is_hairdresser, 0, 0, schedule, 0);
                db.businessDao().insert(business);

                Intent intent2 = new Intent(this, HomeBusinessActivity.class);
                Bundle bundle = new Bundle();
                bundle.putLong("business_id", business.getId());
                intent2.putExtras(bundle);
                startActivity(intent2);
            } catch (Exception e){
                Toast.makeText(this, "Error registering business", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);}


    /*@SuppressLint("NonConstantResourceId")
    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.radio1:
                if (checked)
                    // Restaurant
                    break;
            case R.id.radio2:
                if (checked)
                    // Hairdresser
                    break;
        }

    }


*/
}
