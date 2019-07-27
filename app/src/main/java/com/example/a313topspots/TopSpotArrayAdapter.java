package com.example.a313topspots;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class TopSpotArrayAdapter extends ArrayAdapter<TopSpot> {



    /** Resource ID for the background color for this list of words */
    private int mColorResourceId;

    /**
     * Create a new {@link TopSpotArrayAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param locations is the list of {@link TopSpot}s to be displayed.
     * @param colorResourceId is the resource ID for the background color for this list of locations
     */
    public TopSpotArrayAdapter(Context context, ArrayList<TopSpot> locations, int colorResourceId) {
        super(context, 0, locations);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link TopSpot} object located at this position in the list
        TopSpot currentLocation = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID location_name.
        TextView locationNameView = (TextView) listItemView.findViewById(R.id.location_name);
        // Get the location from the currentTopSpot object and set this text on
        // the location_name TextView.
        locationNameView.setText(currentLocation.getLocationName());

        // Find the TextView in the list_item.xml layout with the location phone number.
        TextView locationNumberTextView = (TextView) listItemView.findViewById(R.id.location_number);
        // Get the default translation from the currentWord object and set this text on
        // the default TextView.
        locationNumberTextView.setText(currentLocation.getLocationNumber());

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        // Check if an image is provided for this word or not
        if (currentLocation.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentLocation.getImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }
}



