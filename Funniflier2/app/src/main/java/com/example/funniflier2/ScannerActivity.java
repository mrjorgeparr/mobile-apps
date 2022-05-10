package com.example.funniflier2;

import com.example.funniflier2.db.Business;
import com.example.funniflier2.db.DB;
import com.google.zxing.client.android.Intents;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;
//import com.mikepenz.aboutlibraries.LibsBuilder;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
public class ScannerActivity extends AppCompatActivity {
    DB db = DB.getInstance(this);
    long user_id;
    private final ActivityResultLauncher<ScanOptions> barcodeLauncher = registerForActivityResult(new ScanContract(),
            result -> {
                if(result.getContents() == null) {
                    Intent originalIntent = result.getOriginalIntent();
                    if (originalIntent == null) {
                        Log.d("ScannerActivity", "Cancelled scan");
                        Toast.makeText(ScannerActivity.this, "Cancelled", Toast.LENGTH_LONG).show();
                    } else if(originalIntent.hasExtra(Intents.Scan.MISSING_CAMERA_PERMISSION)) {
                        Log.d("ScannerActivity", "Cancelled scan due to missing camera permission");
                        Toast.makeText(ScannerActivity.this, "Cancelled due to missing camera permission", Toast.LENGTH_LONG).show();
                    }
                } else {

                    long business_id = Long.getLong(result.getContents());
                    try{
                        Business b = db.businessDao().findById(business_id);

                        Intent intent2 = new Intent(this, BusinessActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putLong("business_id", b.getId());
                        bundle.putLong("user_id", user_id);
                        intent2.putExtras(bundle);
                        this.startActivity(intent2);

                    }catch(Exception e){
                        Toast.makeText(ScannerActivity.this, "Not found", Toast.LENGTH_LONG).show();
                        Intent intent2 = new Intent(this, HomeActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putLong("user_id", user_id);
                        intent2.putExtras(bundle);
                        this.startActivity(intent2);
                    }
                    Log.d("ScannerActivity", "Scanned");

                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        user_id = getIntent().getExtras().getLong("user_id");
        ScanOptions options = new ScanOptions();
        options.setCaptureActivity(AnyOrientationCaptureActivity.class);
        options.setDesiredBarcodeFormats(ScanOptions.ONE_D_CODE_TYPES);
        options.setPrompt("Scan something");
        options.setOrientationLocked(false);
        options.setBeepEnabled(false);
        barcodeLauncher.launch(options);
    }

}