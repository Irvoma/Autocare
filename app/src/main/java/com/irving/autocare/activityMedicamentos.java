package com.irving.autocare;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class activityMedicamentos extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicamentos);

        FloatingActionButton boton = (FloatingActionButton) findViewById(R.id.add_medicamento_button);
        boton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent=new Intent(this,ActivityFormularioMedicamento.class);
        startActivity(intent);
    }
}
