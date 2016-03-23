package fr.univ_lille1.iut_info.murschet.placeyourbets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

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
        setContentView(R.layout.menu);
    }

    public void doInscription(View view){
        setContentView(R.layout.inscription);
    }

    public void doInscrire(View view){
        setContentView(R.layout.menu);
    }

    public void doDisconnect(View view){
        setContentView(R.layout.menu);
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
}
