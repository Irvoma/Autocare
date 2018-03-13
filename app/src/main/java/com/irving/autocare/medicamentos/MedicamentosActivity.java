package com.irving.autocare.medicamentos;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.irving.autocare.R;

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
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/

                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MedicamentosActivity.this);
                View myView = getLayoutInflater().inflate(R.layout.formulario_medicamento, null);

                Spinner spinner = (Spinner) myView.findViewById(R.id.spinner);

                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.tipoDosis,
                        android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);

                mBuilder.setView(myView).setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "Aceptar", Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(), "Cancelar", Toast.LENGTH_SHORT).show();
                    }
                });


                AlertDialog dialog = mBuilder.create();
                dialog.show();
            }
        });

        MedicamentosFragment fragment = (MedicamentosFragment)
                getSupportFragmentManager().findFragmentById(R.id.medicamentos_container);

        if(fragment == null){
            fragment = MedicamentosFragment.newInstance();
            getSupportFragmentManager().beginTransaction().add(R.id.medicamentos_container, fragment).commit();
        }
    }

}
