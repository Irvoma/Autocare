package data;

import android.content.ContentValues;

import java.util.UUID;

/**
 * Created by IrvingOmar on 11/03/2018.
 */

public class Medicamento {
    private String id;
    private String nombre;
    private String dosis;
    private String presentacion;
    private String empaque;
    private String unidades;

    public Medicamento(String nombre, String dosis, String presentacion, String empaque, String unidades) {
        this.id = UUID.randomUUID().toString();
        this.nombre = nombre;
        this.dosis = dosis;
        this.presentacion = presentacion;
        this.empaque = empaque;
        this.unidades = unidades;
    }

    public ContentValues toContentValues(){
        ContentValues values = new ContentValues();
        values.put(MedicamentoContract.MedicamentoEntry.ID, id);
        values.put(MedicamentoContract.MedicamentoEntry.NOMBRE, nombre);
        values.put(MedicamentoContract.MedicamentoEntry.DOSIS, dosis);
        values.put(MedicamentoContract.MedicamentoEntry.PRESENTACION, presentacion);
        values.put(MedicamentoContract.MedicamentoEntry.EMPAQUE, empaque);
        values.put(MedicamentoContract.MedicamentoEntry.UNIDADES, unidades);
        return values;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public void setEmpaque(String empaque) {
        this.empaque = empaque;
    }

    public void setUnidades(String unidades) {
        this.unidades = unidades;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDosis() {
        return dosis;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public String getEmpaque() {
        return empaque;
    }

    public String getUnidades() {
        return unidades;
    }
}
