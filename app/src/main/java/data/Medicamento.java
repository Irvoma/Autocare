package data;

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

    public Medicamento(String id, String nombre, String dosis, String presentacion, String empaque, String unidades) {
        this.id = id;
        this.nombre = nombre;
        this.dosis = dosis;
        this.presentacion = presentacion;
        this.empaque = empaque;
        this.unidades = unidades;
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
