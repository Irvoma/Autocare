package com.irving.autocare.medicamentos;

import com.irving.autocare.data.MedicamentosContract.MedicamentoEntry;
import com.irving.autocare.R;

import android.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.content.Context;
import android.database.Cursor;
import android.widget.TextView;
import android.view.ViewGroup;
import android.view.View;


public class MedicamentosCursorAdapter extends CursorAdapter {
    public MedicamentosCursorAdapter(Context context, Cursor cursor){
        super(context, cursor, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return inflater.inflate(R.layout.list_item_medicamentos, viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView linea1 = (TextView) view.findViewById(R.id.tv_name);
        TextView linea2 = (TextView) view.findViewById(R.id.tv_dosis);
        TextView linea3 = (TextView) view.findViewById(R.id.tv_descripcion);

        String name = cursor.getString(cursor.getColumnIndex(MedicamentoEntry.NOMBRE));
        String dosis = cursor.getString(cursor.getColumnIndex(MedicamentoEntry.DOSIS))
                + " " + cursor.getString(cursor.getColumnIndex(MedicamentoEntry.PRESENTACION));;
        String descripcion = cursor.getString(cursor.getColumnIndex(MedicamentoEntry.EMPAQUE))
                + " " + cursor.getString(cursor.getColumnIndex(MedicamentoEntry.UNIDADES)) + " unidades";

        linea1.setText(name);
        linea2.setText(dosis);
        linea3.setText(descripcion);
    }
}
