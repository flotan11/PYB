package fr.univ_lille1.iut_info.murschet.placeyourbets;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.frenchcomputerguy.rest.GetRequest;
import com.frenchcomputerguy.rest.PostRequest;
import com.frenchcomputerguy.rest.Request;
import com.frenchcomputerguy.utils.JSONElement;

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
        Map<String,String> map = new HashMap<>();
        TextView Login = (TextView) findViewById(R.id.LoginAccueil) ;
        TextView Mdp = (TextView) findViewById(R.id.MdpAccueil) ;
        map.put(Login.toString(),Mdp.toString());
        TextView tv = (TextView) findViewById(R.id.Presentation) ;
        setContentView(R.layout.menu);

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
