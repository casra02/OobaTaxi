package com.google.ar.core.examples.java.dbManagement;

import com.google.ar.core.examples.java.helloar.R;
import com.google.ar.core.examples.java.requestRide.Ride;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TaxiFleetDB {
    private static List<Ride> availableCarpools = new ArrayList<>();
    private static HashMap<String, Ride> idToRide = new HashMap<>();

    public static void initialize(){
        // Initial concrete DB with pre-existing rides
        availableCarpools.add(new Ride("Sophia Green", 12, 2.4,15.16,R.drawable.sophiagreen));
        availableCarpools.add(new Ride("Ava Thompson", 35,5.0,5.24,R.drawable.serenawilliams));
        availableCarpools.add(new Ride("Samuel Kim", 11,4.9,17.18,R.drawable.traeyoung));
        availableCarpools.add(new Ride("Olivia Martin",9, 4.3,21.19,R.drawable.selenagomez));
        availableCarpools.add(new Ride("Benjamin Patel", 27,3.9,9.03,R.drawable.anthonyedwards));
        availableCarpools.add(new Ride("Mia Rodriguez", 8,2.2,22.12,R.drawable.taylorswift));
        idToRide.put("900125678", new Ride("John Doe",5, 1.1, 38.12, R.drawable.lebronjames));
    }

    public static void add(Ride ride){
        availableCarpools.add(ride);
    }

    public static void add(String taxiID){
        add(idToRide.get(taxiID));
    }

    public static List<Ride> getAvailableCarpools(){
        return availableCarpools;
    }

}
