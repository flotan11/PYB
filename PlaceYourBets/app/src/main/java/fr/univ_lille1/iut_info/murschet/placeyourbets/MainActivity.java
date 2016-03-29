package fr.univ_lille1.iut_info.murschet.placeyourbets;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    String url = "localhost:8080/data/users";
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
        EditText et = (EditText) findViewById(R.id.LoginAccueil);
        String url ="http://172.18.49.104:8080/data/users"+"/"+et.getText();
        Log.d("toto3",url);


        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.d("toto",response);
                        setContentView(R.layout.menu);
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


        setContentView(R.layout.accueil);
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
