package datos;
import negocio.Vendible;

public class Licuadora extends ProductoElectroDomestico implements Vendible{
    private int potencia;
    private int capacidad;
    final String familia = super.getFamilia();

    public Licuadora(String idProducto, String nombre, double precio, String descripcion, String familia
                        ,String marca, String modelo, String color, int garantia, String voltaje,
                        int potencia, int capacidad) {
        super(idProducto, nombre, precio, descripcion, familia, marca, modelo, color, garantia, voltaje);
  
        this.potencia = potencia;
        this.capacidad = capacidad;
    }
    

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    //metodo getFamilia sobreescrito de la clase ProductoElectronico
    @Override
    public String getFamilia(){
        return super.getFamilia();
    }

    
    @Override
    //a un producto electrodomestico se le puede aplicar un descuento de hasta el 50%
    public boolean aplicarDescuento(double porcentaje) {
        if (super.aplicarDescuento(porcentaje)){
            this.setPrecio(this.getPrecio()-this.getPrecio()*(porcentaje/100));
            return true;
         }
         else
             return false;  
    }

    //sobreescritura el metodos obtenerDetalles de la clase base ProductoElectronico
    //agregando los atributos potencia y capacidad
    @Override
    public String obtenerDetalles() {
        
        return super.obtenerDetalles()+"Licuadora [capacidad=" + capacidad + ", potencia=" + potencia + "]";
    }

    

    @Override
    public String toString() {
        return super.toString()+", capacidad:" + capacidad + ", potencia:" + potencia;
    }


    @Override
    public double calcularPrecio() {
        return 0;
    }

    @Override
    public double calcularPrecio(double porcentaje) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean esVendible() {

        return true; //este producto es vendible al público
    }
    
    

}