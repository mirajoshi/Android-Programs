package com.example.countryflagapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class CountryListFragment extends Fragment {

    private List<Country> countryList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_country_list, container, false);

        // Prepare country data
        countryList = new ArrayList<>();
        countryList.add(new Country("India",         R.drawable.flag_india));
        countryList.add(new Country("United States", R.drawable.flag_usa));
        countryList.add(new Country("Japan",         R.drawable.flag_japan));
        countryList.add(new Country("Germany",       R.drawable.flag_germany));
        countryList.add(new Country("Brazil",        R.drawable.flag_brazil));
        countryList.add(new Country("France",        R.drawable.flag_france));
        countryList.add(new Country("Australia",     R.drawable.flag_australia));
        countryList.add(new Country("Canada",        R.drawable.flag_canada));

        // Extract names for ListView
        List<String> names = new ArrayList<>();
        for (Country c : countryList) {
            names.add(c.getName());
        }

        ListView listView = view.findViewById(R.id.listViewCountries);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                requireContext(),
                R.layout.item_country,
                R.id.tvCountryName,
                names
        );
        listView.setAdapter(adapter);

        // On country click → open FlagFragment
        listView.setOnItemClickListener((parent, v, position, id) -> {
            Country selected = countryList.get(position);

            CountryFlagFragment flagFragment = CountryFlagFragment.newInstance(
                    selected.getName(),
                    selected.getFlagResId()
            );

            requireActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, flagFragment)
                    .addToBackStack(null) // enables back button
                    .commit();
        });

        return view;
    }
}
