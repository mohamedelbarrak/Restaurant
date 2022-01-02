package com.example.restaurant;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import java.security.PrivateKey;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity2 extends AppCompatActivity implements LocationListener {

    private TextView name, description, age;
    private ImageView imageView2;
    private Bundle extras;
    String name1, description1, age1;
    protected LocationManager locationManager;
    protected LocationListener locationListener;
    protected Context context;
    TextView txtLat;
    String lat;
    String provider;
    protected String latitude1, latitude2, longitude;

    protected boolean gps_enabled, network_enabled;

    //get Acces, to location pension
    final private int REQUEST_CODE_ASK_PERMISSIONS = 123;

    void openWhatsappContact(View view, String number) {
        Uri uri = Uri.parse("smsto:" + number);
        Intent i = new Intent(Intent.ACTION_SENDTO, uri);
        i.setPackage("com.whatsapp");
        startActivity(Intent.createChooser(i, ""));
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    public void onClickWhatsApp1(View view) {
        Log.d("Latitude", "latitude1*1" + latitude1);
        getLocation();
        Log.d("Latitude", "latitude1*2" + latitude1);

    }

    private boolean appIstalledOrNot(String url) {
        PackageManager packageManager = getPackageManager();
        boolean app_instaled;
        try {
            packageManager.getPackageInfo(url, PackageManager.GET_ACTIVITIES);
            app_instaled = true;
        } catch (PackageManager.NameNotFoundException e) {

            app_instaled = false;
        }
        return app_instaled;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        name = findViewById(R.id.name);
        description = findViewById(R.id.description);
        age = findViewById(R.id.age);
        imageView2 = findViewById(R.id.imageView2);

        extras = getIntent().getExtras();
        if (extras != null) {
            name1 = extras.getString("name") + "";
            name.setText(name1);
            description1 = extras.getString("description");
            description.setText(description1);
            age1 = extras.getString("age");
            age.setText(age1);
            imageView2.setImageResource(extras.getInt("image"));
        }

    }




    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
// Permission Granted
                } else {
// Permission Denied
                    Toast.makeText(MainActivity2.this, "Find location Denied", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        }
    }



    @RequiresApi(api = Build.VERSION_CODES.M)
    private void getLocation() {
        Log.d("Latitude1***", "Latitude1***" + latitude1);
        try {
            locationManager = (LocationManager) getApplicationContext().getSystemService(LOCATION_SERVICE);
            if((int)Build.VERSION.SDK_INT >= 15) {
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions


                    if (!shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_FINE_LOCATION)) {
                        requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                                Manifest.permission.ACCESS_COARSE_LOCATION}, REQUEST_CODE_ASK_PERMISSIONS
                        );
                    }

                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.

                }
            }
            //location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
           locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5, MainActivity2.this);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onLocationChanged(Location location) {

        //name = findViewById(R.id.name);
        //name.setText("Latitude:" + location.getLatitude() + ", Longitude:" + location.getLongitude());
        //latitude = location.getLatitude() +" "+location.getLongitude();
        save(location.getLatitude(), location.getLongitude());
    }

    private void save(double latitude, double longitude) {
        latitude1 = "www.google.com/maps?q="+latitude+","+longitude+"&&hl=en"+"Mo"+"\n"+name1+".";
        latitude2 = "Order: \n"+name1+"\n"+description1+"\n"+age1+"\n";
        Log.d("Latitude","latitude1*3"+latitude1+latitude2);

        boolean installed = appIstalledOrNot("com.whatsapp");
        if(installed){
            Intent waIntent = new Intent(Intent.ACTION_VIEW);
            String message = latitude2+latitude1;
            waIntent.setData(Uri.parse("http://api.whatsapp.com/send?phone="+"+212"+"654451449"+"&text="+message));

            //Toast.makeText(getApplicationContext(),"votre commande est en cours de préparation, veuillez patienter.",Toast.LENGTH_LONG).show();
            showMyToast(Toast.makeText(getApplicationContext(),"votre commande est en cours de préparation, veuillez patienter.",Toast.LENGTH_LONG), 10000);
            startActivity(waIntent);
            finish();
        }
        else{
            Toast.makeText(this, "WhatsApp not Installed", Toast.LENGTH_SHORT).show();
        }

    }

    public void showMyToast(final Toast toast, final int delay) {
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                toast.show();
            }
        }, 0, 1000);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                toast.cancel();
                timer.cancel();
            }
        }, delay);
    }

    @Override
    public void onProviderDisabled(String provider) {
        Log.d("Latitude","disable");

        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity2.this);
        dialog.setCancelable(false);
        dialog.setTitle("GPS non activé");
        dialog.setMessage("veuillez activer le GPS pour quand puis envoyer votre commande." );
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                //Action for "Delete".
            }
        });
/*
                .setNegativeButton("Cancel ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Action for "Cancel".
                    }
                });
*/
        final AlertDialog alert = dialog.create();
        alert.show();



    }



    @Override
    public void onProviderEnabled(String provider) {
        Log.d("Latitude","enable");
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        Log.d("Latitude","status");
    }
}