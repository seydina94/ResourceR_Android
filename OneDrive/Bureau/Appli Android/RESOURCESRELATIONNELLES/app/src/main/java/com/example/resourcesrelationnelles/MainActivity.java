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


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener /**implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener*/
{

    // Variables
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override //
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*---------Hooks----------*/
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);


        /*---------Tool Bar----------*/
        setSupportActionBar(toolbar);


        /*---------Navigation Drawer Menu ----------*/


        // Hide or show items

        /**
         * Ajouter dans le "main_menu.xml" les sections "deconnexion et profil"
         * puis rajouter ce code pour les faire disparaître quand l'utillisateur n'est pas connecté.
         *
         */ Menu menu = navigationView.getMenu();

        menu.findItem(R.id.nav_connexion).setVisible(true);
        menu.findItem(R.id.nav_deconnexion).setVisible(false);
        menu.findItem(R.id.nav_profil).setVisible(false);
        menu.findItem(R.id.creer_ressource).setVisible(false);
        menu.findItem(R.id.favoris_ressources).setVisible(false);
        menu.findItem(R.id.supprimer_ressource).setVisible(false);
        menu.findItem(R.id.approbation_ressources).setVisible(false);
        menu.findItem(R.id.creer_categorie_ressources).setVisible(false);
        menu.findItem(R.id.supprimer__categorie_ressources).setVisible(false);
        menu.findItem(R.id.gestion_des_comptes).setVisible(false);
        menu.findItem(R.id.statistiques).setVisible(false);
        menu.findItem(R.id.nav_statistiques).setVisible(false);
        menu.findItem(R.id.filtre_statistiques).setVisible(false);
        menu.findItem(R.id.exporter_statistiques).setVisible(false);




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
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){

            //Redirection Accueil
            case R.id.nav_accueil:
                Intent i = new Intent(MainActivity.this,MainActivity.class);
                startActivity(i);
                break;
            case R.id.con_accueil:
                Intent i2 = new Intent(MainActivity.this,MainActivity.class);
                startActivity(i2);
                break;

            //Redirection page "Ressources"
            case R.id.nav_ressources :
                Intent i3 = new Intent(MainActivity.this,Ressources.class);
                startActivity(i3);
                break;
            case R.id.image_rces_accueil:// Marche pas cas n'est pas dans le Menu de Navigation
                Intent i4 = new Intent(MainActivity.this,Ressources.class);
                startActivity(i4);
                break;

                // Redirection Connexion
            case R.id.nav_connexion:
                Intent i5 = new Intent(MainActivity.this,menuconnexion.class);
                startActivity(i5);
                break;
            case R.id.text_con_accueil:// Marche pas cas n'est pas dans le Menu de Navigation
                Intent i6 = new Intent(MainActivity.this,menuconnexion.class);
                startActivity(i6);
                break;


        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}