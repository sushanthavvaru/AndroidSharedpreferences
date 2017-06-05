package com.example.sushanth.personactivity;


import android.content.res.AssetManager;
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


/**
 * A simple {@link Fragment} subclass.
 */
public class Statefragment extends Fragment {
    ListView stateList;
    String state;
    String nameOftheCountry;
    ArrayList<String> states = new ArrayList<String>();
    ArrayAdapter<String> adapter;


    public Statefragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_statefragment, container, false);
        stateList = (ListView) v.findViewById(R.id.statelist);
        return v;



    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        nameOftheCountry = getArguments().getString("country").trim();

        try {
            AssetManager asset1 = getActivity().getAssets();
            InputStream statesFile = asset1.open(nameOftheCountry);

            BufferedReader in = new BufferedReader(new InputStreamReader(statesFile));
            while ((state = in.readLine()) != null) {
                //System.out.println(state);
                states.add(state);

            }

            adapter =
                    new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, states);
            stateList.setAdapter(adapter);
            stateList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    returnstate statelistener = (returnstate) getActivity();
                    statelistener.printstate(parent.getItemAtPosition(position).toString());
                }
            });
        } catch (IOException e) {
            Log.e("rew", "read Error", e);
        }
    }


    public interface returnstate{
        public void printstate(String state);
    }

}