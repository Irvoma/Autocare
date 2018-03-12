package com.irving.autocare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MedicamentosFragment extends Fragment {

    public MedicamentosFragment() {
        // Required empty public constructor
    }

    public static MedicamentosFragment newInstance() {
        return  new MedicamentosFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_medicamentos, container, false);
    }

    @Override
    public void onActivityResult(int requestCode, int reultCode, Intent data){

    }

}
