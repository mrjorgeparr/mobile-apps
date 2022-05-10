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
import com.example.funniflier2.SearchActivity;
import com.example.funniflier2.databinding.FragmentHomeBinding;
import com.example.funniflier2.db.Business;
import com.example.funniflier2.ui.home.PageViewModel;
import com.example.funniflier2.utils.HomeUtils;

import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class BestBusinessFragment extends Fragment {

    //private static final String ARG_SECTION_NUMBER = "section_number";
    private PageViewModel pageViewModel;
    private FragmentHomeBinding binding;


    public static BestBusinessFragment newInstance() {
        BestBusinessFragment fragment = new BestBusinessFragment();
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
        TableLayout table = root.findViewById(R.id.table_business);

        HomeUtils hu = new HomeUtils(getActivity());
        hu.setUserId(((SearchActivity)getActivity()).user_id);

        List<Business> businesses = ((SearchActivity) getActivity()).businesses;
        for (int i=0; i<businesses.size(); i++){
            hu.putBusinessOnTable(getActivity(), table, businesses.get(i));
        }
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}