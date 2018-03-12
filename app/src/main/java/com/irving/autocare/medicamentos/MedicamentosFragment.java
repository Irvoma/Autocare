package com.irving.autocare.medicamentos;

import android.database.Cursor;
import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.ListView;

import com.irving.autocare.R;
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

        mMedicamentosDbHelper = new MedicamentosDbHelper(getActivity());

        loadMedicamentos();

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
}
