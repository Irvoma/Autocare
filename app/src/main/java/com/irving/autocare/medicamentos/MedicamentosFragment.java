package com.irving.autocare.medicamentos;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CursorAdapter;
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
                //Toast.makeText(getContext(), "Aceptar", Toast.LENGTH_SHORT).show();
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(getContext());
                View myView = getLayoutInflater().inflate(R.layout.formulario_medicamento, null);

                Spinner spinner = (Spinner) myView.findViewById(R.id.spinner);

                ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.tipoDosis,
                        android.R.layout.simple_spinner_item);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);

                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
                        String medida = (String) adapterView.getItemAtPosition(pos);
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });

                mBuilder.setView(myView).setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //agregar medicamento
                        Toast.makeText(getContext(), "Aceptar", Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getContext(), "Cancelar", Toast.LENGTH_SHORT).show();
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

    private class addMedicamento extends AsyncTask<Medicamento, Void, Boolean>{
        @Override
        protected Boolean doInBackground(Medicamento... medicamentos) {
            return null;
        }
    }
}
