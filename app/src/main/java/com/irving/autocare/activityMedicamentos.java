package com.irving.autocare;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class activityMedicamentos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicamentos);

        FloatingActionButton boton = (FloatingActionButton) findViewById(R.id.add_medicamento);
        boton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder mBuilder = new AlertDialog.Builder(activityMedicamentos.this);
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
                }
        );
    }


}
