package com.example.funniflier2.ui.search;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.example.funniflier2.R;
import com.example.funniflier2.databinding.FragmentHomeBinding;
import com.example.funniflier2.ui.home.PageViewModel;
import com.example.funniflier2.utils.HomeUtils;

/**
 * A placeholder fragment containing a simple view.
 */
public class NearestBusinessFragment extends Fragment {

    //private static final String ARG_SECTION_NUMBER = "section_number";
    private PageViewModel pageViewModel;
    private FragmentHomeBinding binding;


    public static NearestBusinessFragment newInstance() {
        NearestBusinessFragment fragment = new NearestBusinessFragment();
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
        hu.putBusinessOnTable(getActivity(), table, "This is the recent fragment\n12:00-12:30");
        hu.putBusinessOnTable(getActivity(), table, "I can not wait to see you\n11:12-12:12");

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}