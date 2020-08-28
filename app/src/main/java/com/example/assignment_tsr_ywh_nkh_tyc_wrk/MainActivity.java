package com.example.assignment_tsr_ywh_nkh_tyc_wrk;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity{
    private DrawerLayout dl;
    private ActionBarDrawerToggle ab;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dl = (DrawerLayout)findViewById(R.id.dl);
        ab = new ActionBarDrawerToggle(this, dl, R.string.Open, R.string.Close);
        ab.setDrawerIndicatorEnabled(true);

        dl.addDrawerListener(ab);
        ab.syncState();

        final NavigationView nav_view =(NavigationView)findViewById(R.id.nav_view);

        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.action_cart){
                    Toast.makeText(MainActivity.this, "User Account", Toast.LENGTH_SHORT).show();

                }

                else if (id == R.id.user_account){
                    Toast.makeText(MainActivity.this, "User Account", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, UserAcc.class);
                }
                return true;
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item) || ab.onOptionsItemSelected(item);
    }

}

