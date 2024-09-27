package datos;
import negocio.Vendible;
public class Libro extends ProductoLiterario implements Vendible{
    private String isbn;
    final String familia = super.getFamilia();
    
    public Libro(String idProducto, String nombre, double precio, String descripcion, String familia
                        ,String autor, String editorial, int anioPublicacion, String genero, int numeroPaginas, String isbn) 
            {
                super(idProducto, nombre, precio, descripcion, familia, autor, editorial, anioPublicacion, genero, numeroPaginas);
                this.isbn = isbn;

            }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    //metodo getFamilia sobreescrito de la clase ProductoLiterario
    public String getFamilia(){
        return super.getFamilia();
    }


    //sobreescritura del metodo obtenerDetalles de la clase ProductoLiterario y
    //agregando el atributo isbn
    @Override
    public String obtenerDetalles() {
        return super.obtenerDetalles()+"Libro [isbn=" + isbn + "]";
    }

    @Override
    //a un producto literario se le puede aplicar un descuento de hasta el 80%
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
        return super.toString()+", isbn:" + isbn ;
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
       
        return true;//este producto es vendible al público
    }

    
    
    


}