package com.irving.autocare.medicamentos;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.irving.autocare.R;

import org.w3c.dom.Text;

public class MedicamentosActivity extends AppCompatActivity {
    public static final String EXTRA_MEDICAMENTO_ID = "extra_medicamento_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicamentos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        MedicamentosFragment fragment = (MedicamentosFragment)
                getSupportFragmentManager().findFragmentById(R.id.medicamentos_container);

        if(fragment == null){
            fragment = MedicamentosFragment.newInstance();
            getSupportFragmentManager().beginTransaction().add(R.id.medicamentos_container, fragment).commit();
        }
    }

}
