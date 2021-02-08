package com.project.ichwan.bayurid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;
import com.project.ichwan.bayurid.cnbfragment.HomeFragment;
import com.project.ichwan.bayurid.cnbfragment.MitraFragment;
import com.project.ichwan.bayurid.cnbfragment.ProdukFragment;
import com.project.ichwan.bayurid.cnbfragment.ProfilFragment;

public class MainActivity extends AppCompatActivity {

    ChipNavigationBar cnb;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cnb = findViewById(R.id.chipbar);

        if (savedInstanceState == null){
            cnb.setItemSelected(R.id.homes,true);
            fragmentManager = getSupportFragmentManager();
            HomeFragment home = new HomeFragment();
            fragmentManager.beginTransaction().replace(R.id.frame_container, home).commit();
        }

        cnb.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment fragment = null;

                switch (i){
                    case R.id.homes:
                        fragment = new HomeFragment();
                        break;
                    case R.id.product:
                        fragment = new ProdukFragment();
                        break;
                    case R.id.partner:
                        fragment = new MitraFragment();
                        break;
                    case R.id.profile:
                        fragment = new ProfilFragment();
                        break;
                }

                if (fragment != null){
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.frame_container,fragment).commit();
                }
            }
        });

    }
}