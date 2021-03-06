package fr.univ_lille1.iut_info.murschet.placeyourbets;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {
    String url ="http://10.0.2.2:8080/data/users";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accueil);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void doConnect(View view){
        RequestQueue queue = Volley.newRequestQueue(this);
        final EditText et = (EditText) findViewById(R.id.LoginAccueil);
        final EditText ett = (EditText) findViewById(R.id.MdpAccueil);
        Log.d("toto3", url);


        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.d("toto", response);
                        int indexdebut = response.indexOf("<login>");
                        int indexfinal = response.indexOf("</login>");
                        Log.d("toto4", response.substring(indexdebut+7,indexfinal));
                        Log.d("toto5", et.getText().toString());

                        int indexdeb = response.indexOf("<mdp>");
                        int indexfin = response.indexOf("</mdp>");
                        Log.d("toto4", response.substring(indexdeb+5,indexfin));
                        Log.d("toto5", ett.getText().toString());

                        if(response.substring(indexdebut + 7, indexfinal).equals(et.getText().toString())&& response.substring(indexdeb + 5, indexfin).equals(ett.getText().toString())){
                            setContentView(R.layout.menu);
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("toto2", String.valueOf(error));
            }
        });
        // Add the request to the RequestQueue.
        queue.add(stringRequest);



    }

    public void doInscription(View view){
        
        setContentView(R.layout.inscription);
    }

    public void doInscrire(View view){
        RequestQueue queue = Volley.newRequestQueue(this);
        final EditText id = (EditText) findViewById(R.id.Identifiant);
        final EditText mdp = (EditText) findViewById(R.id.mdp);
        StringRequest myReq = new StringRequest(Request.Method.POST,url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("Response", response);
                setContentView(R.layout.accueil);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("login", "test2");
                params.put("mdp","yolo");
                return params;
            }

        };
        queue.add(myReq);


    }




    public void doDisconnect(View view){
        setContentView(R.layout.accueil);
    }

    public void goProfil(View view){
        setContentView(R.layout.profil);
    }

    public void goListePari(View view){
        setContentView(R.layout.listepari);
    }

    public void goPari(View view){
        setContentView(R.layout.pari);
    }

    public void goMenu(View view){
        setContentView(R.layout.menu);
    }

    public void goSuivant(View view){ setContentView(R.layout.infosperso);}

    public void doRetour(View view){
        setContentView(R.layout.inscription);
    }
}
