import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

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

    public Vendedor buscarVendedorNombre(String nombre){
        Vendedor buscarVendedor = null;
        for (Vendedor vendedor : this.vendedores) {
            if (vendedor.getNombre().equals(nombre)) {
                buscarVendedor = vendedor;
            }
        }
        return buscarVendedor;
    }

    public Vendedor buscarVendedorRut(String rut){
        Vendedor buscarVendedor = null;
        for (Vendedor vendedor : this.vendedores) {
            if (vendedor.getRut().equals(rut)) {
                buscarVendedor = vendedor;
            }
        }
        return buscarVendedor;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void añadirClientes(){
        CalculoRut calculoRut = new CalculoRut();
        Cliente cliente = new Cliente("Pedrito","14503774-3","casa","correo@gmail,com",123456789);
        if (CalculoRut.verificarRut(cliente.getRut())){
            this.clientes.add(cliente);
        }else{
            System.out.println("Rut no válido");
        }
    }

    public Cliente buscarClienteNombre(String nombre){
        Cliente buscarCliente = null;
        for (Cliente cliente : this.clientes) {
            if (cliente.getNombre().equals(nombre)) {
                buscarCliente = cliente;
            }
        }
        return buscarCliente;
    }

    public Cliente buscarClienteRut(String rut){
        Cliente buscarCliente = null;
        for (Cliente cliente : this.clientes) {
            if (cliente.getNombre().equals(rut)) {
                buscarCliente = cliente;
            }
        }
        return buscarCliente;
    }

    public void modificarClientes(Cliente cliente){
        Scanner teclado = new Scanner(System.in);
        String direccion = teclado.next();
        String correo = teclado.next();
        int numero = teclado.nextInt();
        cliente.setDireccion(direccion);
        cliente.setCorreo(correo);
        cliente.setNumeroTelefono(numero);
    }

    public void eliminarClientes(Cliente cliente){
        this.clientes.remove(cliente);
    }

    public Vehiculo buscarAutoNombreVenta(String nombre){
        Vehiculo buscarVehiculo = null;
        for(Vehiculo auto : this.vehiculosAVenta){
            if(auto.getNombre().equals(nombre)){
                buscarVehiculo = auto;
            }
        }
        return buscarVehiculo;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void añadirVenta(){
        Vendedor vendedor = buscarVendedorNombre("German");
        Cliente cliente = buscarClienteNombre("Pedrito");
        Vehiculo vehiculo = buscarAutoNombreVenta("Celerio");
        Date fecha = new Date();
        Venta venta = new Venta(vendedor, cliente, vehiculo, fecha);
        this.ventas.add(venta);
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
        añadirVenta();
    }

}


