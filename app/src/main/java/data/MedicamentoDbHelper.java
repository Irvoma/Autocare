package data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by IrvingOmar on 11/03/2018.
 */

public class MedicamentoDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Medicamentos.db";

    public MedicamentoDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + MedicamentoContract.MedicamentoEntry.TABLE_NAME + " ("
                + MedicamentoContract.MedicamentoEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + MedicamentoContract.MedicamentoEntry.ID + " TEXT NOT NULL,"
                + MedicamentoContract.MedicamentoEntry.NOMBRE + " TEXT NOT NULL,"
                + MedicamentoContract.MedicamentoEntry.DOSIS + " TEXT NOT NULL,"
                + MedicamentoContract.MedicamentoEntry.PRESENTACION + " TEXT NOT NULL,"
                + MedicamentoContract.MedicamentoEntry.EMPAQUE + " TEXT NOT NULL,"
                + MedicamentoContract.MedicamentoEntry.UNIDADES + " TEXT NOT NULL,"
                + "UNIQUE (" + MedicamentoContract.MedicamentoEntry.ID + "))"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long saveMedicamento(Medicamento medicamento){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        return sqLiteDatabase.insert(MedicamentoContract.MedicamentoEntry.TABLE_NAME,
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
                MedicamentoContract.MedicamentoEntry.TABLE_NAME,
                null,
                medicamento.toContentValues()
        );
    }

    public Cursor getAllMedicamentos(){
        return getReadableDatabase().query(
                MedicamentoContract.MedicamentoEntry.TABLE_NAME,
                null, null, null, null, null, null);
    }
}
