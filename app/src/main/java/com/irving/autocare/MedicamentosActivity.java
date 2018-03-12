package com.irving.autocare;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import data.Medicamento;

public class MedicamentosActivity extends AppCompatActivity {
    public static final String EXTRA_MEDICAMENTO_ID = "extra_medicamento_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicamentos);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        MedicamentosFragment fragment = (MedicamentosFragment)
                getSupportFragmentManager().findFragmentById(R.id.medicamentos_container);

        if (fragment == null){
            fragment = MedicamentosFragment.newInstance();
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.medicamentos_container, fragment).commit();
        }
    }

}
