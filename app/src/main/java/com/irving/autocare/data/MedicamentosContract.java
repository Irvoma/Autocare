package com.irving.autocare.data;

import android.provider.BaseColumns;


public class MedicamentosContract {
    public static abstract class MedicamentoEntry implements BaseColumns{
        public static final String TABLE_NAME = "medicamento";
        public static final String ID = "id";
        public static final String NOMBRE = "nombre";
        public static final String DOSIS = "dosis";
        public static final String PRESENTACION = "presentacion";
        public static final String EMPAQUE = "empaque";
        public static final String UNIDADES = "unidades";
    }
}