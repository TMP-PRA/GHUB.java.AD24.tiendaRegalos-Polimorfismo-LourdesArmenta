package datos;
import negocio.Vendible;

public class Tostadora extends ProductoElectroDomestico implements Vendible{
    private int numRanuras;
    final String familia = super.getFamilia();
    
    public Tostadora(String idProducto, String nombre, double precio, String descripcion, String familia
                        ,String marca, String modelo, String color, int garantia, String voltaje
                        ,int numRanuras) {
        super(idProducto, nombre, precio, descripcion, familia, marca, modelo, color, garantia, voltaje);
        this.numRanuras = numRanuras;
    }

    public int getNumRanuras() {
        return numRanuras;
    }

    public void setNumRanuras(int numRanuras) {
        this.numRanuras = numRanuras;
    }

    //metodo getFamilia sobreescrito de la clase ProductoElectronico
    @Override
    public String getFamilia(){
        return super.getFamilia();
    }

    //sobreescritura del metodo obtenerDetalles de la clase ProductoElectronico y
    //agregando el atributo numRanuras
    @Override
    public String obtenerDetalles() {
        
        return super.obtenerDetalles()+"Tostadora numRanuras=" + numRanuras;
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

    @Override
    public String toString() {
        return super.toString()+", numRanuras:" + numRanuras;
    }

    @Override
    public double calcularPrecio() {
        return 0;
    }

    @Override
    public double calcularPrecio(double porcentaje) {

        return 0;
    }

    @Override
    public boolean esVendible() {
        return true; //este producto es vendible al público
    }

    

   
    
}