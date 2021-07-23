package com.example.muslimapps;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class GoogleMapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private LatLng sydney = new LatLng(-8.579892, 116.095239);
    private static final int PROXIMITY_RADIUS_METERS = 15000;
    private MapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_map);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
//        mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
//        mapFragment.getMapAsync(GoogleMapActivity.this);
//        setupAutoCompleteFragment();
    }

//    private void setupAutoCompleteFragment() {
//        PlaceAutocompleteFragment autocompleteFragment = (PlaceAutocompleteFragment)
//                getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);
//        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
//            @Override
//            public void onPlaceSelected(Place place) {
//                sydney = place.getLatLng();
//                String url = getUrl(sydney.latitude, sydney.longitude, "");
//                Object[] DataTransfer = new Object[2];
//                DataTransfer[0] = mMap;
//                DataTransfer[1] = url;
//                Log.d("onClick", url);
//                GetNearbyPlacesData getNearbyPlacesData = new GetNearbyPlacesData();
//                getNearbyPlacesData.execute(DataTransfer);
//            }
//
//            @Override
//            public void onError(Status status) {
//                Log.e("Error", status.getStatusMessage());
//            }
//        });
////        PlaceAutocompleteFragment autocompleteFragment = (PlaceAutocompleteFragment)
////                getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);
////        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
////            @Override
////            public void onPlaceSelected(Place place) {
////                sydney = place.getLatLng();
////                String url = getUrl(sydney.latitude, sydney.longitude, "");
////                Object[] DataTransfer = new Object[2];
////                DataTransfer[0] = mMap;
////                DataTransfer[1] = url;
////                Log.d("onClick", url);
////                GetNearbyPlacesData getNearbyPlacesData = new GetNearbyPlacesData();
////                getNearbyPlacesData.execute(DataTransfer);
////            }
////
////            @Override
////            public void onError(Status status) {
////                Log.e("Error", status.getStatusMessage());
////            }
////        });
//    }

    private String getUrl(double latitude, double longitude, String s) {
        StringBuilder googlePlacesUrl = new StringBuilder(getString(R.string.urlapi));
        googlePlacesUrl.append("location=" + latitude + "," + longitude);
        googlePlacesUrl.append("&radius=" + PROXIMITY_RADIUS_METERS);
        googlePlacesUrl.append("&type=" + s);
        googlePlacesUrl.append("&sensor=true");
        googlePlacesUrl.append("&key=" + getString(R.string.api_key_android));
        Log.d("getUrl", googlePlacesUrl.toString());
        return (googlePlacesUrl.toString());
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 8.5f));
        mMap.addMarker(new MarkerOptions()
                .position(sydney)
                .title("www.kodetr.com")
                .snippet("lokasi saya")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mMap != null) {
            mMap.clear();
        }
    }
}