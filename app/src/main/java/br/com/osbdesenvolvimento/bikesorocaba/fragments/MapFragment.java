package br.com.osbdesenvolvimento.bikesorocaba.fragments;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import br.com.osbdesenvolvimento.bikesorocaba.R;
import br.com.osbdesenvolvimento.bikesorocaba.classes.Interfaces;
import br.com.osbdesenvolvimento.bikesorocaba.dtos.Estacao;
import br.com.osbdesenvolvimento.bikesorocaba.tasks.DownloadJsonAsyncTask;

public class MapFragment extends Fragment implements Interfaces.AsyncReturnListEstacoes, GoogleMap.InfoWindowAdapter {
    //, GoogleMap.OnCameraChangeListener
    MapView mMapView;
    RelativeLayout rlLoading;
    private GoogleMap googleMap;
    String lat, lon;
    MapFragment contextFragmente;
    LayoutInflater thisInflater;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map, container, false);
        contextFragmente = this;
        thisInflater = inflater;

        mMapView = (MapView) view.findViewById(R.id.mapView);
        rlLoading = (RelativeLayout) view.findViewById(R.id.rlLoading);

        mMapView.onCreate(savedInstanceState);
        //mMapView.onCreate(savedInstanceState);
        mMapView.onResume(); // needed to get the map to display immediately

        MapsInitializer.initialize(getActivity().getApplicationContext());

        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                googleMap = mMap;

                // Setting a custom info window adapter for the google map
                googleMap.setInfoWindowAdapter(contextFragmente);

                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)
                        == PackageManager.PERMISSION_GRANTED) {

                    googleMap.setMyLocationEnabled(true);
                } else {
                    Log.e("MAPTESTE", "ELSESAPORRA 3");
                }

                //googleMap.setOnMyLocationChangeListener(myLocationChangeListener);

                // For dropping a marker at a point on the Map
                LatLng sorocaba = new LatLng(-23.4826108, -47.4618482);
                new DownloadJsonAsyncTask(contextFragmente, contextFragmente).execute("https://integrabike.compartibike.com.br/stations.json");

                // For zooming automatically to the location of the marker
                CameraPosition cameraPosition = new CameraPosition.Builder().target(sorocaba).zoom(12).build();
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

            }
        });
        return view;
    }

//    @Override
//    public void onCameraChange(CameraPosition cameraPosition) {
//        // camera's center
//        LatLng a = cameraPosition.target;
//        double lat = a.latitude;
//        double lng = a.longitude;
//        // you can also access the field-of-view
//        LatLngBounds boundingBox = googleMap.getProjection().getVisibleRegion().latLngBounds;
//        Log.e("MAPA", String.valueOf(boundingBox));
//    }

    @Override
    public void processFinish(final List<Estacao> lista) {
        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                googleMap = mMap;

                for (final Estacao estacao : lista) {
                    googleMap.addMarker(new MarkerOptions()
                            .position(new LatLng(estacao.getGoogleMapX(), estacao.getGoogleMapY()))
                            .title(estacao.getName())
                            .snippet(estacao.toJsonString())
                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_marker_bike)));
                }
                rlLoading.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public View getInfoContents(Marker marker) {
        JSONObject markerJson = null;
        // Getting view from the layout file info_window_layout
        final ViewGroup nullParent = null;
        View v = thisInflater.inflate(R.layout.info_mark_estacao, nullParent);

        try {
            markerJson = new JSONObject(marker.getSnippet());

            TextView tvNome = (TextView) v.findViewById(R.id.tvNome);
            TextView tvBikesDisponiveis = (TextView) v.findViewById(R.id.tvBikesDisponiveis);
            TextView tvBaiasDisponiveis = (TextView) v.findViewById(R.id.tvBaiasDisponiveis);

            tvNome.setText(markerJson.getString("stationNumber") + " - " + marker.getTitle());
            tvBikesDisponiveis.setText(contextFragmente.getString(R.string.bikes_disponiveis, markerJson.getString("unavailableSlotsSize")));
            tvBaiasDisponiveis.setText(contextFragmente.getString(R.string.baias_disponiveis, markerJson.getString("availableSlotsSize")));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        // Returning the view containing InfoWindow contents
        return v;
    }

    @Override
    public View getInfoWindow(Marker marker) {
        return null;
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
