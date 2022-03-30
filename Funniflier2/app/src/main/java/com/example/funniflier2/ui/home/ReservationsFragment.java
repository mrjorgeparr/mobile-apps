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

import com.example.funniflier2.R;
import com.example.funniflier2.databinding.*;

import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.funniflier2.utils.HomeUtils;
import java.util.Date;

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

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        TableLayout table = root.findViewById(R.id.table);

        HomeUtils hu = new HomeUtils(getActivity());
        hu.putReservationOnTable(getActivity(), table, "I really like your body\n12:00-12:30");
        hu.putReservationOnTable(getActivity(), table, "I can not wait to see you\n11:12-12:12");
        hu.putReservationOnTable(getActivity(), table, "I can not wait to see you\n11:12-12:12");

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}