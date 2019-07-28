package com.example.a313topspots;

import androidx.fragment.app.Fragment;

public class TopSpot extends Fragment {


        /** String resource for name of the location*/
        private int mLocationName;

        /** String resource for location phone number*/
        private int mLocationNumber;

        //**Image Resource ID for the Location*/
        private int mImageResourceId = NO_IMAGE_PROVIDED;

        /** Constant value that represents no image was provided for this word */
         private static final int NO_IMAGE_PROVIDED = -1;


    /** Creates a new TopSpot Object
     *
     * @param LocationName take in the name of the location
     * @param LocationNumber take in the phone number of the location
     */
    public TopSpot (int LocationName, int LocationNumber) {
            mLocationName = LocationName;
            mLocationNumber = LocationNumber;
        }

    /**
     * Creates a new TopSpot object. This differs from about because it takes into account the
     * possibility of having an image for one or more of the locations.
     *
     * @param LocationName take in the name of the location
     * @param LocationNumber take in the phone number of the location
     * @param imageResourceId is the drawable resource ID for teh image associated with the location
     */
        public TopSpot (int LocationName, int LocationNumber, int imageResourceId) {
            mLocationName = LocationName;
            mLocationNumber = LocationNumber;
            mImageResourceId = imageResourceId;

        }

        //Is the public method to get the location.

        public int getLocationName() {return mLocationName;}

        //Is the public method to get the location's phone number.
        public int getLocationNumber() {return mLocationNumber;}

        //The public method to get the image of the location
        public int getImageResourceId() {
            return mImageResourceId;
        }

        //Is the public method to determine if an image was returned.
        public boolean hasImage() {
            return mImageResourceId != NO_IMAGE_PROVIDED;
        }


}
