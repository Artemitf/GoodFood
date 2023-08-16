package com.example.GoodFood;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.afinal.R;
import com.example.afinal.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public ActivityMainBinding binding;
    public DrawerLayout drawer;

    BlankFragment1 bf1 = new BlankFragment1();
    BlankFragment2 bf2 = new BlankFragment2();
    BlankFragment3 bf3 = new BlankFragment3();
    BlankFragment4 bf4 = new BlankFragment4();
    BlankFragment5 bf5 = new BlankFragment5();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        drawer = new DrawerLayout(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        NavigationView navigationView = binding.navView;
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();



        if (bf1 != null) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.container, bf1);
            fragmentTransaction.commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        TextView sverhu = findViewById(R.id.sverhu);

        if (id == R.id.nav_home){
            ft.replace(R.id.container, bf1);
            sverhu.setText("Главная");

        }
        if (id == R.id.nav_food){
            ft.replace(R.id.container, bf2);
            sverhu.setText("Еда");

        }
        if (id == R.id.nav_workout){
            ft.replace(R.id.container, bf3);
            sverhu.setText("Тренировки");

        }
        if (id == R.id.nav_advice){
            ft.replace(R.id.container, bf4);
            sverhu.setText("Советы");

        }
        if (id == R.id.nav_dop){
            ft.replace(R.id.container, bf5);
            sverhu.setText("О приложении");

        }ft.commit();
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}