package datos;

public class Inventario{
    
    private Producto[] productos;
    private int contador;

    public Inventario() {
        this.productos = new Producto[10];
        this.contador = 0;
    }

    public Inventario(int capacidad) {
        this.productos = new Producto[capacidad];
        this.contador = 0;
    }

    public Producto[] getProductos() {
        return productos;
    }


    public void agregarProducto(Producto producto) {
        if (contador < productos.length) {
            productos[contador++] = producto;
        } else {
            System.out.println("Inventario lleno. No se puede agregar más productos.");
        }
    }

    public boolean eliminarProducto(String nombre) {
        
        for (int i = 0; i < contador; i++) {
            
            if (productos[i].getNombre().equals(nombre)) {
               
                if (i < contador - 1) {
                    
                    for (int j = i; j < contador - 1; j++) {
                        productos[j] = productos[j + 1];
                    }
                }else{
                    productos[i] = null;
                }
                contador--;
                
                return true;
            }
        }
        return false;
            
    }

    public boolean eliminarProducto(Producto producto) {
        for (int i = 0; i < contador; i++) {
            if (productos[i].equals(producto)) {
                for (int j = i; j < contador - 1; j++) {
                    productos[j] = productos[j + 1];
                }    
                contador--;
                //break;
                return true;
            }
           
        }
        return false;
    }

    public Producto buscarProducto(String nombre) {
        for (int i = 0; i < contador; i++) {
            if (productos[i].getNombre().equals(nombre)) {
                return productos[i];
            }
        }
        return null;
    }

    public double calcularValorTotalProductos() {
        double total = 0;
        for (int i = 0; i < contador; i++) {
            total += productos[i].getPrecio();
        }
        return total;
    }

    public void aplicarDescuentoATodos(double porcentaje) {
        for (int i = 0; i < contador; i++) {
            productos[i].aplicarDescuento(porcentaje);
        }
    }

    public void mostrarInventario() {
        for (int i = 0; i < contador; i++) {
            System.out.println(productos[i]);
        }
    }


}