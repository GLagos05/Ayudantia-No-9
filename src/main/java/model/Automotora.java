package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import data.GestorDatos;
import utils.CalculoRut;
import utils.GestorPDF;

public class Automotora {
    private List<Vehiculo> vehiculosAVenta;
    private List<Vehiculo> vehiculosVendidos;
    private List<Vendedor> vendedores;
    private List<Cliente> clientes;
    private List<Venta> ventas;

    public Automotora(){
        this.vehiculosAVenta= new ArrayList<Vehiculo>();
        this.vehiculosVendidos= new ArrayList<Vehiculo>();
        this.vendedores = new ArrayList<Vendedor>();
        this.clientes = new ArrayList<Cliente>();
        this.ventas = new ArrayList<Venta>();
    }

    public List<Vehiculo> getVehiculosAVenta() {
        return vehiculosAVenta;
    }

    public List<Vehiculo> getVehiculosVendidos() {
        return vehiculosVendidos;
    }

    public void añadirVehiculosPorVender(){
        this.vehiculosAVenta.add(new Vehiculo("Celerio",ColorVehiculo.GRIS,MarcaVehiculo.SUZUKI,
                2018,5000000,40000.4));
        this.vehiculosAVenta.add(new Vehiculo("Hilux",ColorVehiculo.ROJO,MarcaVehiculo.TOYOTA,
                2020,12000000,1000));
        this.vehiculosAVenta.add(new Vehiculo("Qashqai",ColorVehiculo.BLANCO,MarcaVehiculo.NISSAN,
                2018,10590000,20000.23));
        this.vehiculosAVenta.add(new Vehiculo("Cruze",ColorVehiculo.CELESTE,MarcaVehiculo.CHEVROLET,
                2010,4500000,105000.144));
        this.vehiculosAVenta.add(new Vehiculo("Sail",ColorVehiculo.GRIS,MarcaVehiculo.CHEVROLET,
                2020,6000000,0));
    }

    public void venderAuto(String nombre, int año){
        for(Vehiculo auto: this.vehiculosAVenta){
            if(auto.getNombre().equals(nombre) && auto.getAño()==año){
               this.vehiculosVendidos.add(auto);
               this.vehiculosAVenta.remove(auto);
               break;
            }
        }
    }

    public List<Vehiculo> buscarAutoNombreForBasico(String nombre){
        List<Vehiculo> vehiculos= new ArrayList<>();
        for(int i=0; i<this.vehiculosAVenta.size(); i++){
            if(this.vehiculosAVenta.get(i).getNombre().equals(nombre)){
                vehiculos.add(this.vehiculosAVenta.get(i));
            }
        }
        return vehiculos;
    }

    public List<Vehiculo> buscarAutoNombre(String nombre){
        List<Vehiculo> vehiculos= new ArrayList<Vehiculo>();
        for(Vehiculo auto : this.vehiculosAVenta){
            if(auto.getNombre().equals(nombre)){
                vehiculos.add(auto);
            }
        }
        return vehiculos;
    }

    public List<Vehiculo> buscarAutoMarca(String marca){
        List<Vehiculo> vehiculos= new ArrayList<Vehiculo>();
        for(Vehiculo auto : this.vehiculosAVenta){
            if(auto.getMarca().equals(marca)){
                vehiculos.add(auto);
            }
        }
        return vehiculos;
    }

    public void mostrarAutosLista(List<Vehiculo> vehiculos){
        for(Vehiculo auto : vehiculos){
            String datos="nombre: "+auto.getNombre()+", marca: "+auto.getMarca()+", año: "+auto.getAño()
                    +", color= "+auto.getColor()+", precio: "+auto.getPrecio()+", kmRecorridos: "+auto.getKmRecorridos();
            System.out.println(datos);
        }
    }

    public void probarSistema(){
        Automotora automotora= new Automotora();
        automotora.añadirVehiculosPorVender();
        automotora.mostrarAutosLista(automotora.buscarAutoNombre("Celerio"));
        automotora.venderAuto("Celerio",2018);
        automotora.mostrarAutosLista(automotora.getVehiculosVendidos());
    }


    public List<Vendedor> getVendedores() {
        return vendedores;
    }

    public void añadirVendedores(){
        CalculoRut calculoRut = new CalculoRut();
        Vendedor vendedor = new Vendedor("German","20.919.321-3",20);
        if (CalculoRut.verificarRut(vendedor.getRut())){
            this.vendedores.add(vendedor);
        }else{
            System.out.println("Rut no válido");
        }
    }

    public List<Vendedor> buscarVendedorNombre(String nombre){
        List<Vendedor> vendedores = new ArrayList<Vendedor>();
        for (Vendedor vendedor : this.vendedores) {
            if (vendedor.getNombre().equals(nombre)) {
                vendedores.add(vendedor);
            }
        }
        return vendedores;
    }

    public List<Vendedor> buscarVendedorRut(String rut){
        List<Vendedor> vendedores = new ArrayList<Vendedor>();
        for (Vendedor vendedor : this.vendedores) {
            if (vendedor.getRut().equals(rut)) {
                vendedores.add(vendedor);
            }
        }
        return vendedores;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void añadirClientes(){
        CalculoRut calculoRut = new CalculoRut();
        Cliente cliente = new Cliente("Cliente","12345678-9","casa","cliente@cliente.cl","123456789");
        if (CalculoRut.verificarRut(cliente.getRut())){
            this.clientes.add(cliente);
        }else{
            System.out.println("Rut no válido");
        }
    }

    public List<Cliente> buscarClienteNombre(String nombre){ //arraylist
        List<Cliente> clientes = new ArrayList<Cliente>();
        for (Cliente cliente : this.clientes) {
            if (cliente.getNombre().equals(nombre)) {
                clientes.add(cliente);
            }
        }
        return clientes;
    }

    public List<Cliente> buscarClienteRut(String rut){
        List<Cliente> clientes = new ArrayList<Cliente>();
        for (Cliente cliente : this.clientes) {
            if (cliente.getNombre().equals(rut)) {
                clientes.add(cliente);
            }
        }
        return clientes;
    }

    public void modificarClientes(Cliente cliente){
        Scanner teclado = new Scanner(System.in);
        String direccion = teclado.next();
        String correo = teclado.next();
        String numero = teclado.next();
        cliente.setDireccion(direccion);
        cliente.setCorreo(correo);
        cliente.setNumeroTelefono(numero);
    }

    public void eliminarClientes(Cliente cliente){
        this.clientes.remove(cliente);
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void añadirVenta(String nombreCliente, String nombreAuto){
        Vendedor vendedor = buscarVendedorNombre("German").get(0);
        Cliente cliente = buscarClienteNombre(nombreCliente).get(0);
        Vehiculo vehiculo = buscarAutoNombre(nombreAuto).get(0);
        Date fecha = new Date();
        Venta venta = new Venta(vendedor, cliente, vehiculo, fecha);
        this.ventas.add(venta);
        venderAuto(nombreAuto,vehiculo.getAño());
        boletaVenta(venta);
    }

    public void boletaVenta(Venta venta){
        GestorPDF gestorPDF = new GestorPDF();
        try {
            gestorPDF.generarBoleta(venta);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void probarVenta(){
        añadirVendedores();
        añadirClientes();
        añadirVehiculosPorVender();
        añadirVenta("Cliente", "Celerio");
        añadirVenta("Cliente", "Hilux");
        cargaMasivaDatos(this.clientes,this.vehiculosVendidos,this.vendedores);
    }

    public void cargaMasivaDatos(List<Cliente> clientes, List<Vehiculo> vehiculos, List<Vendedor> vendedores){
        GestorDatos.registrarDatos(clientes,"target/"+"clientes.txt");
        GestorDatos.registrarDatos(vehiculos,"target/"+"vehiculos.txt");
        GestorDatos.registrarDatos(vendedores,"target/"+"vendedores.txt");
    }

}


