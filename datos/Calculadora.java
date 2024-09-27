package datos;


public class Calculadora extends ProductoElectronico  {
    private String tipo;
    final String familia = super.getFamilia();

    public Calculadora(String idProducto, String nombre, double precio, String descripcion, String familia
                       ,String marca, String modelo, String color, int garantia, 
                       String voltaje ,String tipo) {

        super(idProducto, nombre, precio, descripcion, familia, marca, modelo, color, garantia, voltaje);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    //metodo getFamilia sobreescrito de la clase ProductoElectronico
    @Override
    public String getFamilia(){
        return super.getFamilia();
    }

    //sobreescritura del metodo obtenerDetalles de la clase ProductoElectronico y
    //agregando el atributo tipo
    @Override
    public String obtenerDetalles() {
        return super.obtenerDetalles()+"Calculadora [tipo=" + tipo + "]";
    }

    @Override
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
    
        return super.toString()+", tipo:" + tipo ;
    }

    
    
    

    


    

    
}