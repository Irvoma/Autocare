package com.irving.autocare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private CardView cita_card,hora_card,medicamentos_card,calcular_card;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar= findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        cita_card=(CardView)findViewById(R.id.cita_card);
        hora_card=(CardView)findViewById(R.id.hora_card);
        medicamentos_card=(CardView)findViewById(R.id.medicamentos_card);
        calcular_card=(CardView)findViewById(R.id.calcular_card);
        cita_card.setOnClickListener(this);
        hora_card.setOnClickListener(this);
        medicamentos_card.setOnClickListener(this);
        calcular_card.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case (R.id.cita_card):
                Intent intent1 = new Intent(this,activityCitas.class);
                startActivity(intent1);
                break;
            case (R.id.hora_card):
                break;
            case (R.id.medicamentos_card):
                //Intent intent3 = new Intent(this,activityMedicamentos.class);
                //startActivity(intent3);
                break;
            case (R.id.calcular_card):
                break;
            default: break;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_desplegable, menu);
        return true;
    }


}
