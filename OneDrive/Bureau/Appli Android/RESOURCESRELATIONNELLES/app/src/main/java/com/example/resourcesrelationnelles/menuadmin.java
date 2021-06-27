package com.example.resourcesrelationnelles;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class menuadmin extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    // Variables
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuadmin);

        /*---------Hooks----------*/
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);


        /*---------Tool Bar----------*/
        setSupportActionBar(toolbar);

        // Hide or show items

        Menu menu = navigationView.getMenu();
        menu.findItem(R.id.nav_connexion).setVisible(true);
        menu.findItem(R.id.nav_deconnexion).setVisible(true);
        menu.findItem(R.id.nav_profil).setVisible(false);
        menu.findItem(R.id.creer_ressource).setVisible(true);
        menu.findItem(R.id.favoris_ressources).setVisible(false);
        menu.findItem(R.id.supprimer_ressource).setVisible(true);
        menu.findItem(R.id.approbation_ressources).setVisible(true);
        menu.findItem(R.id.creer_categorie_ressources).setVisible(true);
        menu.findItem(R.id.supprimer__categorie_ressources).setVisible(true);
        menu.findItem(R.id.gestion_des_comptes).setVisible(true);
        menu.findItem(R.id.statistiques).setVisible(true);
        menu.findItem(R.id.nav_statistiques).setVisible(true);
        menu.findItem(R.id.filtre_statistiques).setVisible(true);
        menu.findItem(R.id.exporter_statistiques).setVisible(true);

        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.nav_accueil);

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            //Redirection Accueil
            case R.id.nav_accueil:
                Intent i = new Intent(menuadmin.this,MainActivity.class);
                startActivity(i);
                break;

            //Redirection page "Ressources"
            case R.id.nav_ressources :
                Intent i1 = new Intent(menuadmin.this,Ressources.class);
                startActivity(i1);
                break;

            // Redirection Connexion
            case R.id.nav_connexion:
                Intent i3 = new Intent(menuadmin.this,menuconnexion.class);
                startActivity(i3);
                break;

            case R.id.nav_deconnexion:
                Intent i4 = new Intent(menuadmin.this,MainActivity.class);
                startActivity(i4);
                break;


        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}