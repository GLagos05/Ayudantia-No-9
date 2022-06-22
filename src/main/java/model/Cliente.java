package model;

public class Cliente extends Persona{
    private String direccion;
    private String correo;
    private int numeroTelefono;

    public Cliente(String nombre, String rut, String direccion, String correo, int numeroTelefono) {
        super(nombre, rut);
        this.direccion = direccion;
        this.correo = correo;
        this.numeroTelefono = numeroTelefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(int numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    @Override
    public String toString() {
        return nombre + ',' + rut + ',' + direccion + ',' + correo + ',' + numeroTelefono;
    }
}
