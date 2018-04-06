package com.irving.autocare.medicamentos;

import android.support.v7.app.AppCompatActivity;
import com.irving.autocare.R;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

public class CitasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citas);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_citas);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_citas, menu);
        return true;
    }
}
