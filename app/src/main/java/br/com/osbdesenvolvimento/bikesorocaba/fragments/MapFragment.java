package br.com.osbdesenvolvimento.bikesorocaba.fragments;


import android.Manifest;
import android.content.Context;
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
import android.widget.TextView;

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
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import br.com.osbdesenvolvimento.bikesorocaba.R;
import br.com.osbdesenvolvimento.bikesorocaba.dtos.Estacao;
import br.com.osbdesenvolvimento.bikesorocaba.tasks.DownloadJsonAsyncTask;


public class MapFragment extends Fragment  {

    MapView mMapView;
    private GoogleMap googleMap;
    String lat, lon;
    MapFragment contextFragmente;
    LayoutInflater thisInflater;
    List<Estacao> listaEstacoes;


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map, container, false);
        contextFragmente = this;

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

                // Setting a custom info window adapter for the google map
                googleMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {

                    // Use default InfoWindow frame
                    @Override
                    public View getInfoWindow(Marker arg0) {
                        return null;
                    }

                    // Defines the contents of the InfoWindow
                    @Override
                    public View getInfoContents(Marker marker) {
                        JSONObject markerJson = null;

                        // Getting view from the layout file info_window_layout
                        View v = inflater.inflate(R.layout.info_mark_estacao, null);


                        Log.e("teste", marker.getSnippet());

                        try {
                            markerJson =  new JSONObject(marker.getSnippet());

                            Log.e("teste",markerJson.getString("address"));

                            TextView tvNome = (TextView) v.findViewById(R.id.tvNome);
                            TextView tvBikesDisponiveis = (TextView) v.findViewById(R.id.tvBikesDisponiveis);
                            TextView tvBaiasDisponiveis = (TextView) v.findViewById(R.id.tvBaiasDisponiveis);

                            tvNome.setText(markerJson.getString("stationNumber")+" - "+marker.getTitle());
                            tvBikesDisponiveis.setText(contextFragmente.getString(R.string.bikes_disponiveis, markerJson.getString("qtdBikes")));
                            tvBaiasDisponiveis.setText(contextFragmente.getString(R.string.baias_disponiveis, markerJson.getString("qtdBaias")));

                        } catch (JSONException e) {
                            Log.e("teste", String.valueOf(e));
                            e.printStackTrace();
                        }





                        // Returning the view containing InfoWindow contents
                        return v;

                    }
                });



                //googleMap.setOnMyLocationChangeListener(myLocationChangeListener);


                // For dropping a marker at a point on the Map
                LatLng sorocaba = new LatLng(-23.4673332,-47.5176655);
                new DownloadJsonAsyncTask(contextFragmente).execute("https://integrabike.compartibike.com.br/stations.json");

                // For zooming automatically to the location of the marker
                CameraPosition cameraPosition = new CameraPosition.Builder().target(sorocaba).zoom(12).build();
                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
            }
        });
        return view;
    }

    public void atualizaFragment(final List<Estacao> lista){
        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                googleMap = mMap;

                for (final Estacao estacao: lista) {
                    googleMap.addMarker(new MarkerOptions()
                            .position(new LatLng(estacao.getGoogleMapX(), estacao.getGoogleMapY()))
                            .title(estacao.getName())
                            .snippet(estacao.toJsonString())
                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.icon_marker_bike)));
                }
            }
        });
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
