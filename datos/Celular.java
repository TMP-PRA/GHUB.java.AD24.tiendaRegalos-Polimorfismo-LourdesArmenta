
package datos;
import negocio.Vendible;

public class Celular extends ProductoElectronico implements Vendible{
    private int numCamaras;
    private String sistemaOperativo;
    private int capacidadAlmacenamiento;
    private int ram;
    private String tipoPantalla;
    final String familia = super.getFamilia();

    public Celular(String idProducto, String nombre, double precio, String descripcion, String familia
                    ,String marca, String modelo, String color, int garantia, String voltaje
                    ,int numCamaras, String sistemaOperativo, int capacidadAlmacenamiento, int ram, String tipoPantalla)
    {
        super(idProducto, nombre, precio, descripcion, familia, marca, modelo, color, garantia, voltaje);
        this.numCamaras = numCamaras;
        this.sistemaOperativo = sistemaOperativo;
        this.capacidadAlmacenamiento = capacidadAlmacenamiento;
        this.ram = ram;
        this.tipoPantalla = tipoPantalla;
    }

    public int getNumCamaras() {
        return numCamaras;
    }

    public void setNumCamaras(int numCamaras) {
        this.numCamaras = numCamaras;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }

    public int getCapacidadAlmacenamiento() {
        return capacidadAlmacenamiento;
    }

    public void setCapacidadAlmacenamiento(int capacidadAlmacenamiento) {
        this.capacidadAlmacenamiento = capacidadAlmacenamiento;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getTipoPantalla() {
        return tipoPantalla;
    }

    public void setTipoPantalla(String tipoPantalla) {
        this.tipoPantalla = tipoPantalla;
    }

    @Override
    public String getFamilia(){
        return super.getFamilia();
    }

    //sobreescritura del metodo obtenerDetalles de la clase ProductoElectronico y
    //agregando los atributos numCamaras, sistemaOperativo, capacidadAlmacenamiento, ram y tipoPantalla
    @Override
    public String obtenerDetalles() {
        return super.obtenerDetalles()+"Celular [capacidadAlmacenamiento=" + capacidadAlmacenamiento + ", numCamaras=" + numCamaras + ", ram=" + ram + ", sistemaOperativo=" + sistemaOperativo + ", tipoPantalla=" + tipoPantalla + "]";
    }

    @Override
    //se le puede aplicar un descuento de hasta el 20%
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

        return super.toString()+", capacidadAlmacenamiento=" + capacidadAlmacenamiento + 
                                ", numCamaras=" + numCamaras + ", ram=" + ram + 
                                ", sistemaOperativo=" + sistemaOperativo + ", tipoPantalla=" + 
                                   tipoPantalla;
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
        return true; //es vendible
    }
    
    

    
}