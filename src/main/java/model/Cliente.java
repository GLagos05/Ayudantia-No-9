package model;

public class Cliente extends Persona{
    private String direccion;
    private String correo;
    private String numeroTelefono;

    public Cliente(String nombre, String rut, String direccion, String correo, String numeroTelefono) {
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

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    @Override
    public String toString() {
        return nombre + ',' + rut + ',' + direccion + ',' + correo + ',' + numeroTelefono;
    }

    @Override
    public void obtenerDescuento() {
        System.out.println("Usted tiene un descuento de un 20%");
    }
}
