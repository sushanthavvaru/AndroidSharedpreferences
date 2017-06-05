package com.example.sushanth.personactivity;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static android.R.attr.country;


/**
 * A simple {@link Fragment} subclass.
 */
public class Countryfragment extends Fragment {
    ListView countryList;
    private String country;
    ArrayList<String> countries = new ArrayList<String>();
    ArrayAdapter<String> adapter;




    public Countryfragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_countryfragment, container, false);

        countryList = (ListView) v.findViewById(R.id.countrylist);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        try {
            InputStream countriesFile =getActivity().getAssets().open("countries");
            BufferedReader in = new BufferedReader( new InputStreamReader(countriesFile));
            while((country = in.readLine()) != null){

                countries.add(country);

            }

            adapter =
                    new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, countries);
            countryList.setAdapter(adapter);
            countryList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    returncountry statelistener = (returncountry) getActivity();
                    statelistener.printcountry(parent.getItemAtPosition(position).toString());


                    android.support.v4.app.FragmentManager fragments = getFragmentManager();
                    android.support.v4.app.FragmentTransaction fragmentTransaction = fragments.beginTransaction();
                    Statefragment fragment = new Statefragment();
                    Bundle bdl = new Bundle();
                    bdl.putString("country",parent.getItemAtPosition(position).toString() );
                    fragment.setArguments(bdl);
                    fragmentTransaction.replace(R.id.fragmentcontainer, fragment);
                    fragmentTransaction.addToBackStack("something");

                    fragmentTransaction.commit();
                }
            });
        } catch (IOException e) {
            Log.e("rew", "read Error", e);
        }
    }

    public interface returncountry{
        public void printcountry(String country);
    }

}
