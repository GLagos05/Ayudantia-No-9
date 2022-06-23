package model;

public class Vendedor extends Persona{
    private int edad;

    public Vendedor(String nombre, String rut, int edad) {
        super(nombre, rut);
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return nombre + ',' + rut + ',' + edad;
    }

    @Override
    public void obtenerDescuento() {
        System.out.println("Usted tiene un descuento de un 10%");
    }
}
