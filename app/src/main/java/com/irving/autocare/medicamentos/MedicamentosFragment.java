package com.irving.autocare.medicamentos;

import android.support.v4.app.FragmentTransaction;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.irving.autocare.R;
import com.irving.autocare.data.Medicamento;
import com.irving.autocare.data.MedicamentosDbHelper;


public class MedicamentosFragment extends Fragment {
    private MedicamentosDbHelper mMedicamentosDbHelper;
    private MedicamentosCursorAdapter mMedicamentosAdapter;
    private ListView mMedicamentosList;
    private FloatingActionButton mAddButton;

    private TextInputEditText nombre;
    private TextInputEditText dosis;
    private TextInputEditText empaque;
    private TextInputEditText unidades;
    private String medida;

    public MedicamentosFragment() {
        // Required empty public constructor
    }

    public static MedicamentosFragment newInstance() {
        return new MedicamentosFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_medicamentos, container, false);

        mMedicamentosList = (ListView) root.findViewById(R.id.medicamentos_list);
        mMedicamentosAdapter = new MedicamentosCursorAdapter(getActivity(), null);
        mAddButton = (FloatingActionButton) getActivity().findViewById(R.id.fab);

        mMedicamentosList.setAdapter(mMedicamentosAdapter);

        mMedicamentosDbHelper = new MedicamentosDbHelper(getActivity());



        loadMedicamentos();

        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(getContext());
                View myView = getLayoutInflater().inflate(R.layout.formulario_medicamento, null);

                Spinner spinner = (Spinner) myView.findViewById(R.id.spinner);
                nombre = (TextInputEditText) myView.findViewById(R.id.nombre);
                dosis = (TextInputEditText) myView.findViewById(R.id.dosis);
                unidades = (TextInputEditText) myView.findViewById(R.id.unidades);
                empaque = (TextInputEditText) myView.findViewById(R.id.empaque);

                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.tipoDosis,
                        android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);

                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
                        medida = (String) adapterView.getItemAtPosition(pos);
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {}
                });

                mBuilder.setView(myView).setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //agregar medicamento
                        //Toast.makeText(getContext(), "Aceptar", Toast.LENGTH_SHORT).show();
                        addMedicamento();
                    }
                }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Toast.makeText(getContext(), "Cancelar", Toast.LENGTH_SHORT).show();
                    }
                });

                AlertDialog dialog = mBuilder.create();
                dialog.show();
            }
        });

        return root;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    private void loadMedicamentos(){
        new MedicamentosLoadTask().execute();
    }

    private class MedicamentosLoadTask extends AsyncTask<Void, Void, Cursor> {
        @Override
        protected Cursor doInBackground(Void... voids) {
            return mMedicamentosDbHelper.getAllMedicamentos();
        }

        @Override
        protected void onPostExecute(Cursor cursor) {
            if(cursor != null && cursor.getCount() > 0){
                mMedicamentosAdapter.swapCursor(cursor);
            }
        }
    }

    public void addMedicamento(){
        String nom = nombre.getText().toString();
        String dos = dosis.getText().toString();
        String emp = empaque.getText().toString();
        String uni = unidades.getText().toString();

        if( nom.equals("") || dos.equals("") || emp.equals("") || uni.equals("")){
            Toast.makeText(getContext(), "Error: campos vacios",Toast.LENGTH_SHORT).show();
        }else {
            Medicamento medicamento = new Medicamento(nom, dos, medida, emp, uni);
            new AddMedicamentoTask().execute(medicamento);
        }

    }

    private void showAddEditError() {
        Toast.makeText(getActivity(),
                "Error al agregar nueva información", Toast.LENGTH_SHORT).show();
    }

    private void showMedicamentoScreen() {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.detach(this).attach(this).commit();
    }

    private class AddMedicamentoTask extends AsyncTask<Medicamento, Void, Boolean>{
        @Override
        protected Boolean doInBackground(Medicamento... medicamentos) {
            return mMedicamentosDbHelper.saveMedicamento(medicamentos[0]) > 0;
        }

        @Override
        protected void onPostExecute(Boolean result){
            showMedicamentoScreen();
        }
    }
}
