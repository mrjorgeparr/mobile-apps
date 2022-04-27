package com.example.funniflier2;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



import androidx.appcompat.app.AppCompatActivity;

public class RegisterBusinessActivity extends AppCompatActivity implements View.OnClickListener {
    // defines the button as a member of the class
    Button ok_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_business);
        ok_button = findViewById(R.id.ok_button);
        et_
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
            BusinessModel bmodel = new BusinessModel(1, et_CIF.getText().toString(), et_address.getText().toString(),et_latitude.getText().toString(), et_longitude.getText().toString(),et_schedule.getText().toString(), et_rating);

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