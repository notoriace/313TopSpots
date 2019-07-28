package com.example.a313topspots;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class CondoFragments extends Fragment {


    public CondoFragments() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);



        // Create a list of words
        final ArrayList<TopSpot> condo = new ArrayList<TopSpot>();
        condo.add(new TopSpot(R.string.River_Place, R.string.River_Place_Number, R.drawable.riverplace));
        condo.add(new TopSpot(R.string.Book_Cadillac, R.string.Book_Cadillac_Number, R.drawable.bookcadillac));
        condo.add(new TopSpot(R.string.Willys_Lofts, R.string.Willys_Number, R.drawable.willyslofts));



        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        TopSpotArrayAdapter adapter = new TopSpotArrayAdapter(getActivity(), condo, R.color.category_colors);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);



        return rootView;
    }


}
