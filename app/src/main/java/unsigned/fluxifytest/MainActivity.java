package unsigned.fluxifytest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.squareup.otto.Subscribe;

import java.util.AbstractMap;

import stores.UselessStore;
import unsigned.fluxify.stores.StoreObject;

public class MainActivity extends AppCompatActivity {

    private SingleDispatcher dispatcher;
    private UselessStore uselessStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dispatcher = SingleDispatcher.getInstance();

        uselessStore = UselessStore.getInstance(dispatcher);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dispatcher.dispatch(
                        "USELESS_BUTTON_PRESSED",
                        new AbstractMap.SimpleEntry<String, StoreObject>(
                                "USELESS_BUTTON_PRESSED",
                                new StoreObject(
                                        "useless_string",
                                        false,
                                        "Stringa inutile"
                                )
                        ));
            }
        });
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

    @Subscribe
    public void onUselessStoreChange(UselessStore.UselessStoreChangeEvent event){
        updateUI();
    }

    private void updateUI(){
        StoreObject useless_string = uselessStore.getItems().get("useless_string");
        Toast.makeText(MainActivity.this,useless_string.getCarry().toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        dispatcher.register(this);
        dispatcher.register(uselessStore);
    }

    @Override
    protected void onPause() {
        super.onPause();
        dispatcher.unregister(this);
        dispatcher.unregister(uselessStore);
    }
}
