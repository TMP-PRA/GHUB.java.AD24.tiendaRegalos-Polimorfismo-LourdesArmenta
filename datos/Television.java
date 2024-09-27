package datos;
import negocio.Vendible;

public class Television extends ProductoElectronico implements Vendible{
    private String tamanio;
    private String resolucion;
    private String tipoPantalla;
    private final String familia = super.getFamilia();

    public Television(String idProducto, String nombre, double precio, String descripcion, String familia
                    ,String marca, String modelo, String color, int garantia, String voltaje
                    ,String tamanio, String resolucion, String tipoPantalla)
    {
        super(idProducto, nombre, precio, descripcion, familia,marca, modelo, color, garantia, voltaje);
        this.tamanio = tamanio;
        this.resolucion = resolucion;
        this.tipoPantalla = tipoPantalla;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    public String getTipoPantalla() {
        return tipoPantalla;
    }

    public void setTipoPantalla(String tipoPantalla) {
        this.tipoPantalla = tipoPantalla;
    }

    //metodo getFamilia sobreescrito de la clase ProductoElectronico
    @Override
    public String getFamilia(){
        return super.getFamilia();
    }


    //sobreescritura del metodo obtenerDetalles de la clase ProductoElectronico y
    //agregando los atributos tamanio, resolucion y tipoPantalla
    @Override
    public String obtenerDetalles() {
        return super.obtenerDetalles()+"Television 3resolucion=" + resolucion + ", tamanio=" + tamanio + ", tipoPantalla=" + tipoPantalla;
    }

    @Override
    //a un producto electronico se le puede aplicar un descuento de hasta el 20%
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
        return super.toString()+", resolucion:" + resolucion + ", tamanio:" + tamanio + ", tipoPantalla:" + tipoPantalla;
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