package com.example.funniflier2;


import static com.google.android.gms.location.LocationRequest.PRIORITY_HIGH_ACCURACY;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.funniflier2.db.Business;
import com.example.funniflier2.db.DB;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.OnTokenCanceledListener;

public class RegisterBusinessActivity extends AppCompatActivity implements View.OnClickListener {
    // defines the button as a member of the class
    Button ok_button;
    int LOCATION_REFRESH_TIME = 15000; // 15 seconds to update
    int LOCATION_REFRESH_DISTANCE = 500; // 500 meters to update
    float long_, lat;

    LocationManager mLocationManager;
    FusedLocationProviderClient fusedLocationClient;
    final LocationListener mLocationListener = new LocationListener() {
        @Override
        public void onLocationChanged(final Location location) {
            //your code here
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_business);
        ok_button = findViewById(R.id.ok_button);
        ok_button.setOnClickListener(this);
        //Button ok_button = (Button) findViewById(R.id.ok_button);

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        CancellationToken token = new CancellationToken() {
            @NonNull
            @Override
            public CancellationToken onCanceledRequested(@NonNull OnTokenCanceledListener onTokenCanceledListener) {
                        return null;
            }

            @Override
            public boolean isCancellationRequested() {
                return false;
            }
        };
        fusedLocationClient.getCurrentLocation(PRIORITY_HIGH_ACCURACY, token)
                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        // Got last known location. In some rare situations this can be null.
                        if (location != null) {
                            long_ = (float) location.getLatitude();
                            lat = (float) location.getLatitude();
                        }
                    }
                });




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

                Business business = new Business(name, email, password, address, is_hairdresser, long_, lat, schedule, 4f);
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
