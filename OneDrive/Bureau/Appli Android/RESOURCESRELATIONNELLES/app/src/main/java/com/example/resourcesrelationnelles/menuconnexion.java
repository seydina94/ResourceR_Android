package com.example.resourcesrelationnelles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;

import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.ReferenceQueue;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class menuconnexion extends AppCompatActivity /*implements*/ /*View.OnClickListener*//*LoaderManager.LoaderCallbacks<Cursor>*/ {

    /*String login;
    String password;*/
    private   UserLoginTask mAuthTask = null;
    EditText login_connexion;
    EditText password_connexion;
    Button btn_cnx;
    TextView txt_ins;
    TextView txt_con_adm;

    Retrofit.Builder builder = new Retrofit.Builder()
        .baseUrl("http://192.168.0.15:8080/authentication")
            .addConverterFactory(GsonConverterFactory.create());
    Retrofit retrofit = builder.build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuconnexion);


        // On récupère les éléments de la vue à partir de leur identifiant.
        login_connexion = (EditText) findViewById(R.id.login_connexion);
        password_connexion = (EditText) findViewById(R.id.password_connexion);
        btn_cnx = (Button) findViewById(R.id.button_connexion);
        txt_ins = (TextView) findViewById(R.id.text_redirect_inscription);
        txt_con_adm = (TextView) findViewById(R.id.text_redirect_connexion_admin);

        btn_cnx.setOnClickListener(this);
        txt_ins.setOnClickListener(this);
        txt_con_adm.setOnClickListener(this);


    }


    /**
     *Represents an asynchronous login/registration task used to authenticate the user
     *
     */
    public class UserLoginTask extends  AsyncTask<Void, Void, Boolean>{

        private final String mLogin;
        private final String mPassword;

        UserLoginTask(String login, String password){
            mLogin = login;
            mPassword = password;
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            // TODO: attempt authentication against a network service.

            // get client
            UserClient userClient = retrofit.create(UserClient.class);

            String userName = mLogin;
            String password = mPassword;

            String base = userName + ":" + password;

            String authHeader = "authentication" + Base64.encodeToString(base.getBytes(), Base64.NO_WRAP);
            Call<UserDto> call = userClient.getUser(authHeader);

            try {
                Response<UserDto> response = call.execute();
                if (response.isSuccessful()){
                    return true;
                }
            }catch (IOException e){
                e.printStackTrace();
            }
            return false;
        }
        @Override
        protected void onPostExecute(final Boolean success){
            mAuthTask = null;
            if(success){
                Intent i = new Intent(this, menucitoyenconnecte.class);
                startActivity(i);
            }
            else{
                password_connexion.setError("Login ou mot de passe incorrect !");
                password_connexion.requestFocus();
            }
        }


        @Override
        protected void onCancelled(){
            mAuthTask=null;
        }


    }






    /*Thread T = new Thread(new Runnable(){
        public void run(){
            HttpURLConnection urlConnection = null;
            try {
                URL url = new URL("http://192.168.0.15:8080/registration");
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");

                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                String result = InputStreamOperations.InputStreamToString(in);

                JSONObject jsonObject = new JSONObject(result);


                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                    }
                });

            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }*/
    //
    /**
     * Vérifie si les informations rentrées existent dans la base, si tel est le cas, récupère les champs du citoyen.
    /**
    public static ArrayList<UserDto> getPersonnes() {

        ArrayList<UserDto> personnes = new ArrayList<UserDto>();
        try {
            String myurl= "http://192.168.0.15:8080/authentication";

            URL url = new URL(myurl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            /*
             * InputStreamOperations est une classe complémentaire:
             * Elle contient une méthode InputStreamToString.
             */
            /**String result = InputStreamOperations.InputStreamToString(inputStream);
{@link }
            // On récupère le JSON complet
            JSONObject jsonObject = new JSONObject(result);
            // On récupère le tableau d'objets qui nous concerne
            JSONArray array = new JSONArray(jsonObject.getString("citoyen"));
            // Pour tous les objets on récupère les infos
            for (int i = 0; i < array.length(); i++) {
                // On récupère un objet JSON du tableau
                JSONObject obj = new JSONObject(array.getString(i));
                // On fait le lien Personne - Objet JSON
                UserDto personne = new UserDto();
                personne.setfirstName(obj.getString("nom"));
                personne.setlastName(obj.getString("prenom"));
                // On ajoute la personne à la liste
                personnes.add(personne);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        // On retourne la liste des personnes
        return personnes;
    }
    */



    /*@Override
    public void onClick(View v){


        switch (v.getId()) {
            case R.id.button_connexion:
                //Toast.makeText(getApplicationContext(),"Vous avez cliqué sur le bouton connecter !",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(this,menucitoyenconnecte.class);
                startActivity(i);
                break;
            case R.id.text_redirect_inscription:
                Intent i2 = new Intent(this,menuinscription.class);
                startActivity(i2);
                break;
            case R.id.text_redirect_connexion_admin:
                Intent i3 = new Intent(this,menuconnexionadmin.class);
                startActivity(i3);
                break;

        }
    }*/



}