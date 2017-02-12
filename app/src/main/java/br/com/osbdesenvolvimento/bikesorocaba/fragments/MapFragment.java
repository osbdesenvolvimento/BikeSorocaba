package br.com.osbdesenvolvimento.bikesorocaba.fragments;


import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import br.com.osbdesenvolvimento.bikesorocaba.R;


public class MapFragment extends Fragment  {

    MapView mMapView;
    private GoogleMap googleMap;
    String lat, lon;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map, container, false);

        mMapView = (MapView) view.findViewById(R.id.mapView);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume(); // needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                googleMap = mMap;

                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
                        == PackageManager.PERMISSION_GRANTED) {

                    googleMap.setMyLocationEnabled(true);
                }else{
                    Log.e("MAPTESTE","ELSESAPORRA 3");
                }
                //googleMap.setOnMyLocationChangeListener(myLocationChangeListener);


                // For dropping a marker at a point on the Map
                LatLng sorocaba = new LatLng(-23.4673332,-47.5176655);
                googleMap.addMarker(new MarkerOptions().position(sorocaba).title("Marker Title").snippet("Marker Description"));



                LatLng mark1 = new LatLng(-23.50257,-47.46114);
                googleMap.addMarker(new MarkerOptions().position(mark1).title("Pra\u00e7a Frei Bara\u00fana").snippet("Marker Description").icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_marker_bike)));

                LatLng mark2 = new LatLng(-23.50038,-47.4577);
                googleMap.addMarker(new MarkerOptions().position(mark2).title("Pra\u00e7a Fernando Prestes").snippet("Marker Description").icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_marker_bike)));

                LatLng mark3 = new LatLng(-23.51575,-47.465);
                googleMap.addMarker(new MarkerOptions().position(mark3).title("Pq Kasatu Maru").snippet("Marker Description").icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_marker_bike)));

                LatLng mark4 = new LatLng(-23.50309,-47.46828);
                googleMap.addMarker(new MarkerOptions().position(mark4).title("P\u00e7a Nove de Julho").snippet("Marker Description").icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_marker_bike)));

                LatLng mark5 = new LatLng(-23.51493,-47.48941);
                googleMap.addMarker(new MarkerOptions().position(mark5).title("Armando Pannunzio").snippet("Marker Description").icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_marker_bike)));

                LatLng mark6 = new LatLng(-23.50078,-47.50812);
                googleMap.addMarker(new MarkerOptions().position(mark6).title("Ipiranga").snippet("Marker Description").icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_marker_bike)));

                LatLng mark7 = new LatLng(-23.5019,-47.45276);
                googleMap.addMarker(new MarkerOptions().position(mark7).title("Ponte da rua XV").snippet("Marker Description").icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_marker_bike)));

                LatLng mark8 = new LatLng(-23.49181,-47.50672);
                googleMap.addMarker(new MarkerOptions().position(mark8).title("Wanel Ville").snippet("Marker Description").icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_marker_bike)));

                LatLng mark9 = new LatLng(-23.48814,-47.47838);
                googleMap.addMarker(new MarkerOptions().position(mark9).title("Unitem").snippet("Marker Description").icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_marker_bike)));

                LatLng mark10 = new LatLng(-23.49845,-47.45968);
                googleMap.addMarker(new MarkerOptions().position(mark10).title("P\u00e7a do Rel\u00f3gio").snippet("Marker Description").icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_marker_bike)));

                LatLng mark11 = new LatLng(-23.4956,-47.46259);
                googleMap.addMarker(new MarkerOptions().position(mark11).title("P\u00e7a da Bandeira").snippet("Marker Description").icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_marker_bike)));

                LatLng mark12 = new LatLng(-23.48504,-47.46877);
                googleMap.addMarker(new MarkerOptions().position(mark12).title("P\u00e7a Adolpho Hanickel").snippet("Marker Description").icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_marker_bike)));

                // For zooming automatically to the location of the marker
                CameraPosition cameraPosition = new CameraPosition.Builder().target(sorocaba).zoom(12).build();
               googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
            }
        });
        return view;
    }



    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }

}
