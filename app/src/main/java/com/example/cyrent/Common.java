package com.example.cyrent;

import com.example.cyrent.Model.DriverInfomodel;

public class Common {
    public static final String DRIVER_INFO_REFERENCE="DriverInfo";
   public static final String DRIVER_LOCATION_REFERENCES ="LenderLocation" ;
    public static DriverInfomodel currentUser;


      public static CharSequence buildWelcomeMessage() {   // string not working so CharSequence
        if(Common.currentUser != null)
        {
            return new StringBuilder("Welcome ")
                    .append(Common.currentUser.getFirst_Name())
                    .append(" ")
                    .append(Common.currentUser.getLast_Name());
        }
        else return "";
    }
}
