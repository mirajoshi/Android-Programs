package com.example.countryflagapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CountryFlagFragment extends Fragment {

    private static final String ARG_NAME    = "country_name";
    private static final String ARG_FLAG_ID = "flag_res_id";

    // Factory method — passes data safely via Bundle
    public static CountryFlagFragment newInstance(String name, int flagResId) {
        CountryFlagFragment fragment = new CountryFlagFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NAME, name);
        args.putInt(ARG_FLAG_ID, flagResId);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_country_flag, container, false);

        TextView tvName = view.findViewById(R.id.tvCountryNameFlag);
        ImageView imgFlag = view.findViewById(R.id.imgFlag);
        Button btnBack = view.findViewById(R.id.btnBack);

        if (getArguments() != null) {
            String name    = getArguments().getString(ARG_NAME);
            int    flagId  = getArguments().getInt(ARG_FLAG_ID);

            tvName.setText(name);
            imgFlag.setImageResource(flagId);
        }

        // Back button → pop fragment from back stack
        btnBack.setOnClickListener(v ->
                requireActivity().getSupportFragmentManager().popBackStack()
        );

        return view;
    }
}