package com.example.funniflier2;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;


import androidx.appcompat.app.AppCompatActivity;

public class RegisterBusinessActivity extends AppCompatActivity implements View.OnClickListener {
    // defines the button as a member of the class
    Button ok_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_business);
        ok_button = findViewById(R.id.ok_button);

        //Button ok_button = (Button) findViewById(R.id.ok_button);
        //ok_button.setOnClickListener(this);

    }

    @Override
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
/*
    @Override
    ok_button.setOnClickListener(new View.OnClickListener()){
        // the following method should insert a business instance into the db, one row in businesses and one
        // either in hairdressers or in restaurant
        @Override
        public void onClick(View v){
            // right now id is set to 1, must set it to the number of record considered later on
            // THIS WILL PROBABLY NEED TO BE IMPORTED IN SOME MANNER FROM DBF, ask Chris
            // we need some way to identify if the business being input is a restaurant or a hairdresser, in which case the forms must change
            BusinessModel bmodel = new BusinessModel(1, n_CIF.getText().toString(), n_address.getText().toString(),n_latitude.getText().toString(), n_longitude.getText().toString(),n_schedule.getText().toString(), n_rating);

            if (et_businesstype.equals("restaurant")){
                // then we input extra info of the restaurant
            }
            else if (et_businesstype.equals("hairdresser")){
                // then we input extra info of the hairdresser
            } else{
                // we raise an error
            }
        }
    }

 */
}