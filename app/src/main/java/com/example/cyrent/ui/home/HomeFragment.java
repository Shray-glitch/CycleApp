package com.example.cyrent.ui.home;

import android.Manifest;
import android.location.Location;
import android.os.Bundle;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.example.cyrent.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

public class HomeFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;

    private HomeViewModel homeViewModel;


    //Location
    private FusedLocationProviderClient fusedLocationProviderClient;
    private LocationRequest locationRequest;
    private LocationCallback locationCallback;
    SupportMapFragment mapFragment;


    @Override
    public void onDestroy() {

        fusedLocationProviderClient.removeLocationUpdates(locationCallback);

        super.onDestroy();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        init();

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        return root;
    }

    private void init() {
         locationRequest = new LocationRequest();
         locationRequest.setSmallestDisplacement(10f);
         locationRequest.setInterval(5000);
         locationRequest.setFastestInterval(3000);
         locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);


         locationCallback = new LocationCallback()
         {
             @Override
             public void onLocationResult(LocationResult locationResult) {
                 super.onLocationResult(locationResult);

                 LatLng newPosition = new LatLng(locationResult.getLastLocation().getLatitude(),locationResult.getLastLocation().getLongitude());
                 mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(newPosition, 18f));
             }
         };

         fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(getContext());
         fusedLocationProviderClient.requestLocationUpdates(locationRequest,locationCallback, Looper.myLooper());


    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //mMap.getUiSettings().setZoomControlsEnabled(true);

       // Check Permission

        Dexter.withContext(getContext()).withPermission(Manifest.permission.ACCESS_FINE_LOCATION)
                .withListener(new PermissionListener() {
            @Override
            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
               mMap.setMyLocationEnabled(true);
               mMap.getUiSettings().setMyLocationButtonEnabled(true);
               mMap.setOnMyLocationButtonClickListener(new GoogleMap.OnMyLocationButtonClickListener() {
                   @Override
                   public boolean onMyLocationButtonClick() {
                       fusedLocationProviderClient.getLastLocation()
                               .addOnFailureListener(new OnFailureListener() {
                           @Override
                           public void onFailure(@NonNull Exception e) {
                               Toast.makeText(getContext(), ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                           }
                       }).addOnSuccessListener(new OnSuccessListener<Location>() {
                           @Override
                           public void onSuccess(Location location) {
                              LatLng userLatLng = new LatLng(location.getLatitude(),location.getLongitude());
                              mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(userLatLng, 18f));
                           }
                       });
                       return true;
                   }
               });

                // Set Layout
                View locationButton = ((View)mapFragment.getView().findViewById(Integer.parseInt("1"))
                        .getParent()).findViewById(Integer.parseInt("2"));

                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) locationButton.getLayoutParams();

                //Right Bottom
                params.addRule(RelativeLayout.ALIGN_PARENT_TOP,0);
                params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM,RelativeLayout.TRUE);
                params.setMargins(0,0,0,50);

            }

            @Override
            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {

                Toast.makeText(getContext(), "Permission "+permissionDeniedResponse.getPermissionName()+""
                        +"was denied!" , Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {

            }
        }).check();

    }
}