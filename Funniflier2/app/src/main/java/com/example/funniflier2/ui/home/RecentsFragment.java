package com.example.funniflier2.ui.home;

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

import com.example.funniflier2.HomeActivity;
import com.example.funniflier2.R;
import com.example.funniflier2.databinding.FragmentHomeBinding;
import com.example.funniflier2.db.Business;
import com.example.funniflier2.db.DB;
import com.example.funniflier2.utils.HomeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */public class RecentsFragment extends Fragment {


    //private static final String ARG_SECTION_NUMBER = "section_number";
    private PageViewModel pageViewModel;
    private FragmentHomeBinding binding;

    List<Business> businesses = new ArrayList<Business>();

    public static RecentsFragment newInstance() {
        RecentsFragment fragment = new RecentsFragment();
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

        List<Long> ids = db.recentBusinessDao().getRecent();
        hu.setUserId(user_id);


        for (int i = 0; i < ids.size(); i++){
            businesses.add( db.businessDao().findById(ids.get(i)));
        }

        for (int i = 0; i < businesses.size(); i++) {
            hu.putBusinessOnTable(getActivity(), table, businesses.get(i));
        }
        //hu.putBusinessOnTable(getActivity(), table, "This is the recent fragment\n12:00-12:30");
        //hu.putBusinessOnTable(getActivity(), table, "I can not wait to see you\n11:12-12:12");

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}