package com.example.serviz;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

public class maplocates extends FragmentActivity implements OnMapReadyCallback {

    ImageView call_in;
    ImageView call_in1;
    ImageView call_in2;

    Location currentLocation;
    FusedLocationProviderClient fusedLocationProviderClient;
    private static final int REQUEST_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maplocates);

        call_in = findViewById(R.id.call_in);
        call_in1 = findViewById(R.id.call_in1);
        call_in2 = findViewById(R.id.call_in2);

        call_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phNum = "tel:" + "6369027547";
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse(phNum));
                startActivity(intent);
            }
        });
        call_in1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phNum = "tel:" + "6369027547";
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse(phNum));
                startActivity(intent);
            }
        });
        call_in2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phNum = "tel:" + "6369027547";
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse(phNum));
                startActivity(intent);
            }
        });
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){

            Window window = this.getWindow();
            window.setStatusBarColor(this.getResources().getColor(R.color.colorPrimaryDark));
        }

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        fetchLashLocation();


    }


    private void fetchLashLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,new String[]
                    {Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_CODE);
            return;
        }
        Task<Location> task = fusedLocationProviderClient.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null){
                    currentLocation = location;
                    Toast.makeText(getApplicationContext(),currentLocation.getLatitude()+
                            ""+currentLocation.getLongitude(),Toast.LENGTH_SHORT).show();
                    SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager()
                            .findFragmentById(R.id.map);
                    supportMapFragment.getMapAsync(maplocates.this);
                }
            }
        });
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

        ImageView map1 = findViewById(R.id.mapclick);
        ImageView map2 = findViewById(R.id.mapclick1);
        ImageView map3 = findViewById(R.id.mapclick3);
        map1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LatLng SivaElectronics = new LatLng(10.01533510946809,77.47877086760337);
                googleMap.addMarker(new MarkerOptions()
                        .position(SivaElectronics)
                        .title("Siva Electronics"));
                googleMap.moveCamera(CameraUpdateFactory.newLatLng(SivaElectronics));
            }
        });

        map2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LatLng Vignesh = new LatLng(10.010539468988888, 77.4762672153411);
                googleMap.addMarker(new MarkerOptions()
                        .position(Vignesh)
                        .title("Vigneshwara Electricals"));
                googleMap.moveCamera(CameraUpdateFactory.newLatLng(Vignesh));
            }
        });
        map3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LatLng Vijaya = new LatLng(10.01033579983298, 77.4764482306822);
                googleMap.addMarker(new MarkerOptions()
                        .position(Vijaya)
                        .title("Vijaya Electricals"));
                googleMap.moveCamera(CameraUpdateFactory.newLatLng(Vijaya));
            }
        });


        LatLng latLng = new LatLng(currentLocation.getLatitude(),currentLocation.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions().position(latLng)
                .title("I am here").icon(bitmapDescriptorFromVector(getApplicationContext(),R.drawable.gps));
        googleMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng,13));
        googleMap.addMarker(markerOptions);

    }
    private BitmapDescriptor bitmapDescriptorFromVector(Context context, int vectorResId){
        Drawable vectorDrawable = ContextCompat.getDrawable(context,vectorResId);
        vectorDrawable.setBounds(0,0,vectorDrawable.getIntrinsicWidth(),
                vectorDrawable.getIntrinsicHeight());
        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(),
                vectorDrawable.getIntrinsicHeight(),Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    fetchLashLocation();
                }
                break;
        }
    }
}