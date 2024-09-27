package datos;


public class ProductoDAO {
    private Producto[] productos;
    private int numProductos;

    public ProductoDAO(int capacidad) {
        this.productos = new Producto[capacidad];
        this.numProductos = 0;
    }

    public void agregarProducto(Producto producto) {
        if (numProductos < productos.length) {
            productos[numProductos++] = producto;
            System.out.println("Producto agregado: " + producto.getNombre());
        } else {
            System.out.println("Inventario lleno, no se puede agregar el producto: " + producto.getNombre());
        }
    }

    public void eliminarProducto(String nombreProducto) {
        for (int i = 0; i < numProductos; i++) {
            if (productos[i].getNombre().equals(nombreProducto)) {
                Producto producto = productos[i];
    
                // Mostrar las propiedades específicas del producto
                System.out.println("Detalles del producto a eliminar:");
                System.out.println("Nombre: " + producto.getNombre());
                System.out.println("Precio: $" + producto.getPrecio());
    
                if (producto instanceof Libro) {
                    Libro libro = (Libro) producto;
                    System.out.println("Autor: " + libro.getAutor());
                    System.out.println("Páginas: " + libro.getNumeroPaginas());
                } else if (producto instanceof Celular) {
                    Celular celular = (Celular) producto;
                    System.out.println("Marca: " + celular.getMarca());
                    System.out.println("Modelo: " + celular.getModelo());
                } else if (producto instanceof Television) {
                    Television televisor = (Television) producto;
                    System.out.println("Tamaño: " + televisor.getTamanio() + " pulgadas");
                } else if (producto instanceof Licuadora) {
                    Licuadora licuadora = (Licuadora) producto;
                    System.out.println("Potencia: " + licuadora.getPotencia() + " vatios");
                    System.out.println("Capacidad: " + licuadora.getCapacidad() + " litros");
                }
    
                // Eliminar el producto
                productos[i] = productos[--numProductos];
                productos[numProductos] = null;
                System.out.println("Producto eliminado: " + nombreProducto);
                return;
            }
        }
        System.out.println("Producto no encontrado: " + nombreProducto);
        
    }

    public Producto buscarProducto(String nombreProducto) {
        for (int i = 0; i < numProductos; i++) {
            if (productos[i].getNombre().equals(nombreProducto)) {
                return productos[i];
            }
        }
        return null;
    }

    public Producto[] listarProductos() {
        Producto[] lista = new Producto[numProductos];
    for (int i = 0; i < numProductos; i++) {
        lista[i] = productos[i];

        // Mostrar las propiedades específicas de cada producto
        Producto producto = lista[i];
        System.out.println("Nombre: " + producto.getNombre());
        System.out.println("Precio: $" + producto.getPrecio());

        if (producto instanceof Libro) {
            Libro libro = (Libro) producto;
            System.out.println("Autor: " + libro.getAutor());
            System.out.println("Páginas: " + libro.getNumeroPaginas());
        } else if (producto instanceof Celular) {
            Celular celular = (Celular) producto;
            System.out.println("Marca: " + celular.getMarca());
            System.out.println("Modelo: " + celular.getModelo());
        } else if (producto instanceof Television) {
            Television televisor = (Television) producto;
            System.out.println("Tamaño: " + televisor.getTamanio() + " pulgadas");
        } else if (producto instanceof Licuadora) {
            Licuadora licuadora = (Licuadora) producto;
            System.out.println("Potencia: " + licuadora.getPotencia() + " vatios");
            System.out.println("Capacidad: " + licuadora.getCapacidad() + " litros");
        }
        System.out.println(); // Línea en blanco para separar productos
    }
    return lista;
    }

    public Producto[] getProductos() {
        return productos;
    }

    public void actualizarProducto(Producto producto) {
        // En este ejemplo, no se necesita hacer nada porque estamos usando un arreglo en memoria
        // En una implementación real, aquí se actualizaría el producto en la base de datos
    }

    public void mostrarFamiliaProducto(String familia) {
        System.out.println("Productos de la familia: " + familia);
        for (int i = 0; i < numProductos; i++) {
            
            if (productos[i].getFamilia().toLowerCase().contains(familia.toLowerCase())) {
                System.out.println(productos[i].obtenerDetalles());
                
            }
            
        }
    }
}