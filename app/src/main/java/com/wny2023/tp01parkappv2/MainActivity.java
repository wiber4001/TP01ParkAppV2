package com.wny2023.tp01parkappv2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.wny2023.tp01parkappv2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    Fragment[] fragments=new Fragment[3];
    BottomNavigationView bnv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Fragment 붙이기
        fragments[0]=new ParkInfo1Fragment();
        fragments[1]=new Favorit2Fragment();
        fragments[2]=new Review3Fragment();

        getSupportFragmentManager().beginTransaction().add(R.id.container_fragment,fragments[0]).commit();

        bnv=findViewById(R.id.bnv);
        bnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.bnv_home) getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment,fragments[0]).commit();
                else if (item.getItemId()==R.id.bnv_fav) getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment,fragments[1]).commit();
                else if (item.getItemId()==R.id.bnv_review) getSupportFragmentManager().beginTransaction().replace(R.id.container_fragment,fragments[2]).commit();

                return true;
            }
        });

    }//onCreate()..

}