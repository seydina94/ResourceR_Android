package com.example.resourcesrelationnelles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class menuconnexionadmin extends AppCompatActivity implements View.OnClickListener {

    Button btn_cnx;
    TextView txt_ins;

    @Override //
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuconnexionadmin);

        btn_cnx = (Button) findViewById(R.id.button_connexion);
        txt_ins = (TextView) findViewById(R.id.text_redirect_connexion_citoyen);
        btn_cnx.setOnClickListener(this);
        txt_ins.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_connexion:
                //Toast.makeText(getApplicationContext(),"Vous avez cliqué sur le bouton connecter !",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(this,menuadmin.class);
                startActivity(i);
                break;
            case R.id.text_redirect_connexion_citoyen:
                Intent i2 = new Intent(this,menuconnexion.class);
                startActivity(i2);
                break;

        }
    }
}