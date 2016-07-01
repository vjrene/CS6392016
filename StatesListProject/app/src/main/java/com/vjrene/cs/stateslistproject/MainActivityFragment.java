package com.vjrene.cs.stateslistproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        final View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        final String[] states = {"Alabama", "Alaska", "Arizona", "Arkansas", "California",
                "Colorado", "Connecticut", "Delaware", "Florida", "Georgia",
                "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas",
                "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts",
                "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska",
                "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina",
                "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island",
                "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont",
                "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"};

        List<String> statesList = new ArrayList<>(Arrays.asList(states));

        ArrayAdapter<String> stateAdapter = new ArrayAdapter<>(getActivity(),
                R.layout.listviewitem, R.id.textviewitem, statesList);

        ListView lv = (ListView) rootView.findViewById(R.id.listviewlayout);
        lv.setAdapter(stateAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                    if (position == 44){
                        goToMap();
                    }
                }

        });


        return rootView;
    }

    protected void goToMap() {

        final Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:44.260259, -72.576102"));

        if (intent.resolveActivity(getActivity().getPackageManager()) !=null) {
            startActivity(intent);
        }

    }
}
