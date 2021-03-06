package com.irving.autocare.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.irving.autocare.data.MedicamentosContract.MedicamentoEntry;

public class MedicamentosDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Medicamentos.db";

    public MedicamentosDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + MedicamentoEntry.TABLE_NAME + " ("
                + MedicamentoEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + MedicamentoEntry.ID + " TEXT NOT NULL,"
                + MedicamentoEntry.NOMBRE + " TEXT NOT NULL,"
                + MedicamentoEntry.DOSIS + " TEXT NOT NULL,"
                + MedicamentoEntry.PRESENTACION + " TEXT NOT NULL,"
                + MedicamentoEntry.EMPAQUE + " TEXT NOT NULL,"
                + MedicamentoEntry.UNIDADES + " TEXT NOT NULL,"
                + "UNIQUE (" + MedicamentoEntry.ID + "))"
        );

        mockData(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long saveMedicamento(Medicamento medicamento){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        return sqLiteDatabase.insert(MedicamentoEntry.TABLE_NAME,
                null,
                medicamento.toContentValues());
    }

    private void mockData(SQLiteDatabase sqLiteDatabase){
        mockMedicamento(sqLiteDatabase, new Medicamento("Fluoxetina", "20",
                "mg", "caja", "20"));
        mockMedicamento(sqLiteDatabase, new Medicamento("Butilhiosina", "10",
                "mg", "frasco", "10"));
        mockMedicamento(sqLiteDatabase, new Medicamento("Ibuprofeno|Cafeina", "400|100",
                "mg", "caja", "10"));
        mockMedicamento(sqLiteDatabase, new Medicamento("Amoxixilina|Acido clavulanico", "500|125",
                "mg", "frasco", "12"));
        mockMedicamento(sqLiteDatabase, new Medicamento("Epival", "250",
                "mg", "frasco", "30"));
    }

    public long mockMedicamento(SQLiteDatabase db, Medicamento medicamento){
        return db.insert(
                MedicamentoEntry.TABLE_NAME,
                null,
                medicamento.toContentValues()
        );
    }

    public Cursor getAllMedicamentos(){
        return getReadableDatabase().query(
                MedicamentoEntry.TABLE_NAME,
                null, null, null, null, null, null);
    }
}