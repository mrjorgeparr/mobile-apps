package com.example.funniflier2.ui.home;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.example.funniflier2.HomeActivity;
import com.example.funniflier2.R;
import com.example.funniflier2.databinding.*;

import android.widget.TableLayout;

import com.example.funniflier2.db.DB;
import com.example.funniflier2.db.Reservation;
import com.example.funniflier2.utils.HomeUtils;

import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class ReservationsFragment extends Fragment {

    //private static final String ARG_SECTION_NUMBER = "section_number";
    private PageViewModel pageViewModel;
    private FragmentHomeBinding binding;



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

        DB db = DB.getInstance(getActivity());
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        TableLayout table = root.findViewById(R.id.table_business);

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