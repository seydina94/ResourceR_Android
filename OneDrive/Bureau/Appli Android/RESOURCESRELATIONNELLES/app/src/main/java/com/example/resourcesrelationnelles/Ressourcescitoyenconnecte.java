package com.example.resourcesrelationnelles;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class Ressourcescitoyenconnecte extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{

    // Variables
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    Button Btn_ajout_fav;
    // Button d'ajout de Favori


    @Override //
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ressourcescitoyenconnecte);


        /*---------Hooks----------*/
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
/* Bouton d'ajout de favori */

        //Btn_ajout_fav = (Button) findViewById(R.id.imageButton);


       //0 Btn_ajout_fav.setOnClickListener((View.OnClickListener) this);

        /*---------Tool Bar----------*/
        setSupportActionBar(toolbar);


        /*---------Navigation Drawer Menu ----------*/


        // Hide or show items

        /**
         * Ajouter dans le "main_menu.xml" les sections "deconnexion et profil"
         * puis rajouter ce code pour les faire disparaître quand l'utillisateur n'est pas connecté.
         *
         */ Menu menu = navigationView.getMenu();

        menu.findItem(R.id.nav_connexion).setVisible(false);
        menu.findItem(R.id.nav_deconnexion).setVisible(true);
        menu.findItem(R.id.nav_profil).setVisible(true);
        menu.findItem(R.id.creer_ressource).setVisible(true);
        menu.findItem(R.id.favoris_ressources).setVisible(true);
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
                Intent i = new Intent(Ressourcescitoyenconnecte.this,menucitoyenconnecte.class);
                startActivity(i);
                break;

            //Redirection page "Ressources"
            case R.id.nav_ressources :
                Intent i1 = new Intent(Ressourcescitoyenconnecte.this,Ressourcescitoyenconnecte.class);
                startActivity(i1);
                break;
            case R.id.text_rces_accueil:// Marche pas cas n'est pas dans le Menu de Navigation
                Intent i2 = new Intent(Ressourcescitoyenconnecte.this,Ressourcescitoyenconnecte.class);
                startActivity(i2);
                break;

            //Redirection page "Favoris"
            case R.id.favoris_ressources :
                Intent i6 = new Intent(Ressourcescitoyenconnecte.this,Favoris.class);
                startActivity(i6);
                break;
            // Ajouter un favori
            case R.id.imageButton :
                Intent i5 = new Intent(Ressourcescitoyenconnecte.this,Favoris.class);
                startActivity(i5);
                break;


            // Redirection Deconnexion
            case R.id.nav_deconnexion:
                Intent i3 = new Intent(Ressourcescitoyenconnecte.this,menuconnexion.class);
                startActivity(i3);
                break;
            case R.id.text_con_accueil:// Marche pas cas n'est pas dans le Menu de Navigation
                Intent i4 = new Intent(Ressourcescitoyenconnecte.this,menuconnexion.class);
                startActivity(i4);
                break;


        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}