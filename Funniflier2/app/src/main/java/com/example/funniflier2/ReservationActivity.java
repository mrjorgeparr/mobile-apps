package com.example.funniflier2;

import static android.text.TextUtils.replace;

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
import android.widget.CalendarView;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.funniflier2.databinding.ActivityReservationBinding;
import com.example.funniflier2.db.Business;
import com.example.funniflier2.db.DB;
import com.example.funniflier2.db.Reservation;
import com.example.funniflier2.utils.ReservationDetails;

import java.text.ParseException;
import java.util.Date;

public class ReservationActivity extends AppCompatActivity {

    long reservation_id;
    long business_id;
    long user_id;
    ReservationDetails rd;
    Button goToBusinessButton;
    Button cancelReservationButton;
    ReservationActivity context = this;
    DB db = DB.getInstance(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        Bundle bundle = getIntent().getExtras();

        ReservationDetails rd = new ReservationDetails();
        this.reservation_id = bundle.getLong("reservation_id");
        this.business_id = bundle.getLong("business_id");
        this.user_id = bundle.getLong("user_id");

        Reservation reservation = db.reservationDao().findById(reservation_id);
        Business business = db.businessDao().findById(business_id);

        TextView tv_date = (TextView) findViewById(R.id.reservation_date);
        tv_date.setText(reservation.getDate());

        Log.d("message", "reservation " + Long.toString(this.reservation_id));
        // When clicked carries you to the Business Activity
        goToBusinessButton = (Button) findViewById(R.id.reservation_business_button);
        goToBusinessButton.setText(business.getName());
        goToBusinessButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent2 = new Intent(context, BusinessActivity.class);
                Bundle bundle = new Bundle();
                bundle.putLong("business_id", business_id);
                bundle.putLong("user_id", user_id);
                intent2.putExtras(bundle);
                context.startActivity(intent2);
            }
        });

        CalendarView calendar = (CalendarView) findViewById(R.id.reservation_calendar);

        try {

            Date date = rd.formatter1.parse(reservation.getDate().replace("2022-", ""));
            date.setYear(122);
            Toast.makeText(this, Long.toString(date.getTime()), Toast.LENGTH_SHORT).show();

            calendar.setDate(date.getTime());
        } catch (ParseException e) {
            Toast.makeText(this, "not working", Toast.LENGTH_SHORT).show();
        }

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

                                db.reservationDao().delete(reservation);
                                // Show a succesful canceled text
                                String message = getResources().getString(R.string.cancelled_text);
                                Toast.makeText(context, message,
                                        Toast.LENGTH_LONG).show();
                                dialog.cancel();

                                // Redirects to home activity
                                Intent intent2 = new Intent(context, HomeActivity.class);
                                Bundle bundle = new Bundle();
                                bundle.putLong("user_id", user_id);
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