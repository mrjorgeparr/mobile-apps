package com.example.funniflier2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TableRow;
import android.widget.Toast;

import com.example.funniflier2.databinding.ActivityReservationBinding;

public class ReservationActivity extends AppCompatActivity {

    int reservation_id;
    int business_id;
    Button goToBusinessButton;
    Button cancelReservationButton;
    ReservationActivity context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        Bundle bundle = getIntent().getExtras();
        this.reservation_id = bundle.getInt("reservation_id");

        Log.d("message", "reservation "+Integer.toString(this.reservation_id));

        // When clicked carries you to the Business Activity
        goToBusinessButton = (Button) findViewById(R.id.reservation_business_button);
        goToBusinessButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent2 = new Intent(context, BusinessActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("business_id", business_id);
                intent2.putExtras(bundle);
                context.startActivity(intent2);
            }
        });

        // When clicked cancels a reservation
        cancelReservationButton = (Button) findViewById(R.id.reservation_cancel_button);
        cancelReservationButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AlertDialog.Builder ad = new AlertDialog.Builder(context);
                ad.setTitle(R.string.cancel_dialog);
                ad.setMessage(R.string.cancel_message_dialog);
                ad.setPositiveButton(R.string.button_yes,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int arg1) {
                                // Show a succesful canceled text
                                String message = getResources().getString(R.string.cancelled_text);
                                Toast.makeText(context, message,
                                        Toast.LENGTH_LONG).show();
                                dialog.cancel();

                                // Redirects to home activity
                                Intent intent2 = new Intent(context, HomeActivity.class);
                                Bundle bundle = new Bundle();
                                bundle.putInt("business_id", business_id);
                                intent2.putExtras(bundle);
                                context.startActivity(intent2);
                            }
                        });
                ad.setNegativeButton(R.string.button_no,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int arg1) {
                                dialog.cancel();
                            }
                        });
                ad.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.reservation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_search) {
            Log.d(this.getLocalClassName(), "TODO: Implement search");
            return true;
        } else if (item.getItemId() == R.id.action_settings) {
            Log.d(this.getLocalClassName(), "TODO: Implement settings");
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }
}