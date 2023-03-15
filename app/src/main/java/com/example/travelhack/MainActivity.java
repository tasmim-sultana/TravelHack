package com.example.travelhack;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity{
    private ListView listView;


    private String[] placeName = {"Bandarban","Cox's Bazar","Rangamati","Saintmaritn","Sajek","Sundarban"};
    private int[] placeImg ={R.drawable.bandarban,R.drawable.coxsbazar, R.drawable.rangamati,R.drawable.saintmartin,R.drawable.sajek,R.drawable.sundroban};
    private CustomAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_activity_main);
        listView= findViewById(R.id.listViewId);
        adapter = new CustomAdapter(this,placeName,placeImg);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,
                        PlaceDescription.class);
                intent.putExtra("imgId",placeImg[i]);
                intent.putExtra("name",placeName[i]);
                startActivity(intent);
            }
        });



        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item){
                if(item.getItemId()==R.id.nav_home){
                    Intent intent = new Intent(MainActivity.this,MainActivity.class);
                    startActivity(intent);
                }
                else if(item.getItemId()==R.id.nav_map){
                    Intent intent = new Intent(MainActivity.this,MapsActivity.class);
                    startActivity(intent);
                }
                else if(item.getItemId()==R.id.nav_currency){
                    Intent intent = new Intent(MainActivity.this,CurrencyActivity.class);
                    startActivity(intent);
                }
                else if(item.getItemId()==R.id.nav_hotel){
                    Intent intent = new Intent(MainActivity.this,HotelActivity.class);
                    startActivity(intent);
                }
                else if(item.getItemId()==R.id.nav_weather){
                    Intent intent = new Intent(MainActivity.this,WeatherActivity.class);
                    startActivity(intent);
                }
                else if(item.getItemId()==R.id.nav_profile){
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    if (user != null){
                        Intent intent=new Intent(MainActivity.this,ProfileActivity.class);
                        startActivity(intent);
                    }
                    else{
                        Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                        startActivity(intent);
                    }
                }
                DrawerLayout drawerLayout=findViewById(R.id.drawer_layout);
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }




}