package com.example.restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.security.PrivateKey;

public class MainActivity2 extends AppCompatActivity {

    private TextView name, description, age;
    private ImageView imageView2;
    private Bundle extras;



    void openWhatsappContact(View view, String number) {
        Uri uri = Uri.parse("smsto:" + number);
        Intent i = new Intent(Intent.ACTION_SENDTO, uri);
        i.setPackage("com.whatsapp");
        startActivity(Intent.createChooser(i, ""));
    }


    public void onClickWhatsApp1(View view) {

        boolean installed = appIstalledOrNot("com.whatsapp");
       if(installed){
            Intent waIntent = new Intent(Intent.ACTION_VIEW);
            waIntent.setData(Uri.parse("http://api.whatsapp.com/send?phone="+"+212"+"654451449"+"&text="+"message"));
            startActivity(waIntent);
    }
       else{
           Toast.makeText(this, "WhatsApp not Installed", Toast.LENGTH_SHORT).show();
       }
        }

    private boolean appIstalledOrNot(String url) {
        PackageManager packageManager = getPackageManager();
        boolean app_instaled;
    try {
        packageManager.getPackageInfo(url, PackageManager.GET_ACTIVITIES);
        app_instaled = true;
    }catch (PackageManager.NameNotFoundException e) {

        app_instaled = false;
        }
return app_instaled;
    }








    public void onClickWhatsApp(View view) {

        PackageManager pm=getPackageManager();
        try {

            Intent waIntent = new Intent(Intent.ACTION_SEND);
            //waIntent.setData(Uri.parse("http://api.whatsapp.com/send?phone="+"+212"+"654451449"));
            waIntent.setType("text/plain");
            String text = "YOUR TEXT HERE";

            PackageInfo info=pm.getPackageInfo("com.whatsapp", PackageManager.GET_META_DATA);
            //Check if package exists or not. If not then code
            //in catch block will be called
            waIntent.setPackage("com.whatsapp");

            waIntent.putExtra(Intent.EXTRA_TEXT, text);
            startActivity(Intent.createChooser(waIntent, "Share with"));

        } catch (PackageManager.NameNotFoundException e) {
            Toast.makeText(this, "WhatsApp not Installed", Toast.LENGTH_SHORT)
                    .show();
        }

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
        if(extras != null){
            name.setText(extras.getString("name"));
            description.setText(extras.getString("description"));
            age.setText(extras.getString("age"));
            imageView2.setImageResource(extras.getInt("image"));
        }
    }
}