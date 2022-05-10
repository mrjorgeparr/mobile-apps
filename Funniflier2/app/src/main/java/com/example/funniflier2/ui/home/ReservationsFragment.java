package com.example.funniflier2.ui.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.funniflier2.HomeActivity;
import com.example.funniflier2.R;
import com.example.funniflier2.databinding.*;

import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.funniflier2.db.DB;
import com.example.funniflier2.db.Reservation;
import com.example.funniflier2.utils.HomeUtils;
import java.util.Date;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class ReservationsFragment extends Fragment {

    //private static final String ARG_SECTION_NUMBER = "section_number";
    private PageViewModel pageViewModel;
    private FragmentHomeBinding binding;
    private DB db = DB.getInstance(getActivity());


    public static ReservationsFragment newInstance() {
        ReservationsFragment fragment = new ReservationsFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("ResourceAsColor")
    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        TableLayout table = root.findViewById(R.id.table);

        HomeUtils hu = new HomeUtils(getActivity());
        long user_id = ((HomeActivity) getActivity()).user_id;
        hu.setUserId(user_id);

        List<Reservation> reservations = db.reservationDao().getUserReservations(user_id);

        for(int i=0; i < reservations.size(); i++){
            hu.putReservationOnTable(getActivity(), table, reservations.get(i));
        }

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}