package miTest;

import ui.Menu;
import datos.Producto;
import datos.ProductoElectroDomestico;
import datos.ProductoElectronico;
import datos.ProductoLiterario;
import datos.ProductoPromocional;
import datos.Libro;
import datos.Television;
import datos.Celular; 
import datos.Licuadora;
import datos.Tostadora;
import negocio.TiendaDeRegalos;
import datos.Calculadora;
import datos.CamisetaPromocional;
import datos.Inventario;
import negocio.TiendaDeRegalos;



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


class AppTest {

    private Inventario inventario;

    private TiendaDeRegalos tienda;
    private Producto producto1;
    private Producto producto2;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {

        // Crear un inventario con 7 productos
        inventario = new Inventario(7); // Suponiendo que el inventario puede contener hasta 10 productos
        inventario.agregarProducto(new Television("1", "Televisor 4K", 499.99, "Televisor de alta definición", "ProductoElectronico",
            "Samsung", "QLED", "Negro", 2, "220V", "65 pulg", "8K: 7680 x 4320", "LCD"));
        inventario.agregarProducto(new Celular("2", "Celular Android", 299.99, "Celular de última generación", "ProductoElectronico",
            "Samsung", "Galaxy S21", "Azul", 1, "110V", 3, "IOS", 4, 64, "tactil"));
        inventario.agregarProducto(new Calculadora("3", "Calculadora Científica", 19.99, "Calculadora con funciones avanzadas", "Producto Electronico",
            "Casio", "FX-991ES", "Gris", 1, "N/A", "Científica"));
        inventario.agregarProducto(new Licuadora("7", "Licuadora Oster", 79.99, "Licuadora de alta velocidad con 10 velocidades", "ProductoElectrodomestico",
            "Oster", "BLSTMG-W00", "Blanco", 2, "110V", 600, 1500));
        inventario.agregarProducto(new Tostadora("8", "Tostadora Philips", 49.99, "Tostadora de 4 rebanadas con control de temperatura","ProductoElectrodomestico",
             "Philips", "HD2581/00", "Negro", 2, "110V", 4));
        inventario.agregarProducto(new CamisetaPromocional("9", "Camiseta Deportiva", 19.99, "Camiseta de algodón para deportes","ProductoPromocional",
             "L", "Rojo"));
        inventario.agregarProducto(new Libro("4", "Cien Años de Soledad", 19.99, "Descripción de prueba", "ProductoLiterario",
            "Gabriel Garcia Marquez", "Editorial", 1967, "Realismo mágico", 500, "978-84-376-0494-7"));
    
        
        //creo una Tienda de regalos con capacidad para 20 productos
        tienda = new TiendaDeRegalos(20);
        tienda.setNombre("Tienda de Lulú");
        tienda.setDireccion("Culiacán, Sinaloa");

        producto1 = new ProductoLiterario("3", "Revista",50.00,"Revista National Geographic", "ProductoLiterario", 
                               "National Geographic Society", "Editorial", 2000, "Ciencia y Naturaleza",20);

       producto2 = new ProductoLiterario("2","LibroABC", 250,"Libro de prueba","ProductoLiterario",
                                     "autor","editorial",2000,"genero",0);

       tienda.agregarProducto(producto1);
       tienda.agregarProducto(producto2);
       System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testCalcularValorTotalProductos() {
        double totalEsperado = 499.99 + 299.99 + 19.99 + 79.99 + 49.99 + 19.99 + 19.99;
        assertEquals(totalEsperado, inventario.calcularValorTotalProductos(), 0.01);
    }

    @Test
    public void testAplicarDescuentoATodos() {
        inventario.aplicarDescuentoATodos(10); // Aplicar un descuento del 10% a todos los productos
        // Verificar los precios después del descuento
        /* 
        Producto lista[] = inventario.getProductos();
      
        assertEquals(449.99, lista[0].getPrecio(), 0.01); // Televisor
        assertEquals(269.99, lista[1].getPrecio(), 0.01); // Celular
        assertEquals(17.99, lista[2].getPrecio(), 0.01);  // Calculadora
        assertEquals(71.99, lista[3].getPrecio(), 0.01);  // Licuadora
        assertEquals(44.99, lista[4].getPrecio(), 0.01);  // Tostadora
        assertEquals(19.99, lista[5].getPrecio(), 0.01);  // Camiseta
        assertEquals(17.99, lista[6].getPrecio(), 0.01);  // Libro
        */

        assertEquals(449.99, inventario.getProductos()[0].getPrecio(), 0.01); // Televisor
        assertEquals(269.99, inventario.getProductos()[1].getPrecio(), 0.01); // Celular
        assertEquals(17.99, inventario.getProductos()[2].getPrecio(), 0.01);  // Calculadora
        assertEquals(71.99, inventario.getProductos()[3].getPrecio(), 0.01);  // Licuadora
        assertEquals(44.99, inventario.getProductos()[4].getPrecio(), 0.01);  // Tostadora
        assertEquals(19.99, inventario.getProductos()[5].getPrecio(), 0.01);  // Camiseta
        assertEquals(17.99, inventario.getProductos()[6].getPrecio(), 0.01);  // Libro
        
    }

    @Test
    public void testMostrarInventario() {
        // Redirigir la salida estándar para capturar el output de mostrarInventario
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        inventario.mostrarInventario();

        // Verificar que la salida contiene los productos esperados
        String output = outContent.toString();
        assertTrue(output.contains("Televisor 4K"));
        assertTrue(output.contains("Celular Android"));
        assertTrue(output.contains("Calculadora Científica"));
        assertTrue(output.contains("Licuadora Oster"));
        assertTrue(output.contains("Tostadora Philips"));
        assertTrue(output.contains("Camiseta Deportiva"));
        assertTrue(output.contains("Cien Años de Soledad"));

        // Restaurar la salida estándar
        System.setOut(System.out);
    }
    @Test
    public void testVenderProductoExistente() {
        tienda.venderProducto("LibroABC");
        assertNull(tienda.buscarProducto("LibroABC"));
        assertTrue(outContent.toString().contains("Producto vendido: LibroABC"));
    }

    @Test
    public void testNoVenderProductoPromocional() {
        ProductoPromocional productoPromocional = new ProductoPromocional("9", "Camiseta Deportiva", 
                19.99, "Camiseta de algodón para deportes","ProductoPromocional");
        tienda.agregarProducto(productoPromocional);
        
        // Intentar vender el producto promocional
        tienda.venderProducto("Promo123");
        
        // Verificar que el producto sigue existiendo en el inventario
        assertNotNull(tienda.buscarProducto("Camiseta Deportiva"));
        
        // Verificar que no se imprimió el mensaje de producto vendido
        assertFalse(outContent.toString().contains("Producto vendido: Camiseta Deportiva"));
    }

    @Test 
    public void testMenuInitialization() {
        Menu menu = new Menu();
        assertNotNull(menu, "El menú debe inicializarse correctamente");
    }

    @Test
    public void testProducto() {
        // Prueba de constructor y getNombre
        Producto producto = new Libro("1", "cien años de soledad", 19.99, "Descripción de prueba", "Productoliterario", "Gabriel Garcia Marquez", "Editorial", 1967, "Realismo mágico", 500, "978-84-376-0494-7");  
       
        assertEquals("cien años de soledad", producto.getNombre(), "El nombre del producto debe ser 'cien años de soledad'");

        // Prueba de setNombre
        producto.setNombre("Producto de Prueba 2");
        assertEquals("Producto de Prueba 2", producto.getNombre(), "El nombre del producto debe ser 'Producto de Prueba 2' después de usar setNombre");

        // Prueba de getPrecio
        assertEquals(19.99, producto.getPrecio(), "El precio del producto debe ser 19.99");

        // Prueba de setPrecio
        producto.setPrecio(14.99);
        assertEquals(14.99, producto.getPrecio(), "El precio del producto debe ser 14.99 después de usar setPrecio");

        // Prueba de getDescripcion
        assertEquals("Descripción de prueba", producto.getDescripcion(), "La descripción del producto debe ser 'Descripción de prueba'");

        // Prueba de setDescripcion
        producto.setDescripcion("Nueva descripción de prueba");
        assertEquals("Nueva descripción de prueba", producto.getDescripcion(), "La descripción del producto debe ser 'Nueva descripción de prueba' después de usar setDescripcion");

        // Prueba de getFamilia
        assertEquals("ProductoLiterario", producto.getFamilia(), "La familia del producto debe ser 'ProductoLiterario'");

       
    }
    
    @Test
    public void testAplicarDescuentoHerenciaProducto() {
        // Crear una instancia de Producto usando Libro
        Producto producto = new Libro("1", "Cien Años de Soledad", 19.99, "Descripción de prueba", "Productoliterario", "Gabriel Garcia Marquez", "Editorial", 1967, "Realismo mágico", 500, "978-84-376-0494-7");  


        // Aplicar un descuento válido
        producto.aplicarDescuento(20);
        assertEquals(16.0, producto.getPrecio(), 0.01);

        // Aplicar un descuento no válido, porque es mayor a 80%
        //entonces el costo no debe cambiar
        producto.aplicarDescuento(90);
        assertEquals(16.0, producto.getPrecio(), 0.01); // El precio no debe cambiar

        // Aplicar otro descuento válido
        //se aplica un descuento del 80% al precio original
        //19.99 - 80% = 3.2
        producto.aplicarDescuento(80);
        assertEquals(3.2, producto.getPrecio(), 0.01);
    }

    @Test
    public void testAplicarDescuentoHerenciaProductoElectronico() {
        // Crear una instancia de ProductoElectronico usando Televisor
        ProductoElectronico productoElectronico = new Television("1", "Televisor 4K", 499.99, "Televisor de alta definición", "ProductoElectronico",
                                                    "Samsung", "QLED", "Negro", 2, "220V", "65 pulg", "8K: 7680 x 4320", "LCD");

        // Aplicar un descuento válido
        productoElectronico.aplicarDescuento(20);
        assertEquals(399.99, productoElectronico.getPrecio(), 0.01);

        // Aplicar un descuento no válido, porque es mayor a 20%
        // entonces el costo no debe cambiar
        productoElectronico.aplicarDescuento(90);
        assertEquals(399.99, productoElectronico.getPrecio(), 0.01); // El precio no debe cambiar

        // Aplicar otro descuento válido
        // se aplica un descuento del 10% al precio original
        // 399.99 - 10% = 39.99
        productoElectronico.aplicarDescuento(10);
        assertEquals(360.0, productoElectronico.getPrecio(), 0.01);
    }

    @Test
    public void testAplicarDescuentoHerenciaProductoElectroDomestico() {
        // Crear una instancia de ProductoElectroDomestico usando Licuadora
        ProductoElectroDomestico productoElectroDomestico = new Licuadora("7", "Licuadora Oster", 79.99, "Licuadora de alta velocidad con 10 velocidades","Electrodomesticos",
                                                                     "Oster","BLSTMG-W00","Blanco",2,"110V", 600,1500);

        // Aplicar un descuento válido
        productoElectroDomestico.aplicarDescuento(20);
        assertEquals(63.99, productoElectroDomestico.getPrecio(), 0.01);

        // Aplicar un descuento no válido, porque es mayor a 50%
        // entonces el costo no debe cambiar
        productoElectroDomestico.aplicarDescuento(55);
        assertEquals(63.99, productoElectroDomestico.getPrecio(), 0.01); // El precio no debe cambiar

        // Aplicar otro descuento válido
        // se aplica un descuento del 80% al precio original
        // 63.99 - 20% = 51.1
        productoElectroDomestico.aplicarDescuento(20);
        assertEquals(51.19, productoElectroDomestico.getPrecio(), 0.01);
    }

    @Test
    public void testAplicarDescuentoHerenciaProductoLiterario() {
        // Crear una instancia de ProductoLiterario usando Libro
        ProductoLiterario productoLiterario = new Libro("4", "Cien Años de Soledad", 19.99, "Descripción de prueba", "ProductoLiterario",
                            "Gabriel Garcia Marquez", "Editorial", 1967, "Realismo mágico", 500, "978-84-376-0494-7");

        // Aplicar un descuento válido
        productoLiterario.aplicarDescuento(20);
        assertEquals(15.99, productoLiterario.getPrecio(), 0.01);

        // Aplicar un descuento no válido, porque es mayor a 80%
        // entonces el costo no debe cambiar
        productoLiterario.aplicarDescuento(90);
        assertEquals(15.99, productoLiterario.getPrecio(), 0.01); // El precio no debe cambiar

        // Aplicar otro descuento válido
        // se aplica un descuento del 80% al precio original
        // 15.99 - 80% = 3.2
        productoLiterario.aplicarDescuento(80);
        assertEquals(3.2, productoLiterario.getPrecio(), 0.01);
    }

    @Test
    public void testPolimorfismoProducto() {
        // Crear instancias de Televisor, Celular y Calculadora
        ProductoElectronico television = new Television("1", "Televisor 4K", 499.99, "Televisor de alta definición", "ProductoElectronico",
                                                        "Samsung", "QLED", "Negro", 2, "220V",
                                                        "65 pulg","8K: 7680 x 4320","LCD");
        ProductoElectronico celular = new Celular("2", "Celular Android", 299.99, "Celular de última generación", "ProductoElectronico",
                                                 "Samsung", "Galaxy S21", "Azul", 1, "110V",
                                                 3,"IOS",4,64,"tactil");
        ProductoElectronico calculadora = new Calculadora("3", "Calculadora Científica", 19.99, "Calculadora con funciones avanzadas", "ProductoEletroico",
                                                "Casio", "FX-991ES", "Gris", 1, "N/A","Científica");

        ProductoElectroDomestico licuadora = new Licuadora("7", "Licuadora Oster", 79.99, "Licuadora de alta velocidad con 10 velocidades","Electrodomesticos",
                                                "Oster","BLSTMG-W00","Blanco",2,"110V", 600,1500);
        ProductoElectroDomestico tostadora = new Tostadora("8","Tostadora Philips",49.99, "Tostadora de 4 rebanadas con control de temperatura","Electrodomesticos",
                                                 "Philips", "HD2581/00","Negro", 2,  "110V",4);

        ProductoLiterario libro = new Libro("4","Cien Años de Soledad", 19.99, "Descripción de prueba", "Productoliterario", 
                                                "Gabriel Garcia Marquez", "Editorial", 1967, "Realismo mágico", 500, "978-84-376-0494-7"); 
       
        ProductoPromocional camisetaPromocional = new CamisetaPromocional( "9","Camiseta Deportiva",19.99,"Camiseta de algodón para deportes","ProductoPromocional",
                                                 "L","Rojo"); 

        // Verificar que las instancias son también instancias de Producto
        assertTrue(television instanceof Producto, "Televisor debe ser una instancia de Producto");
        assertTrue(celular instanceof Producto, "Celular debe ser una instancia de Producto");
        assertTrue(calculadora instanceof Producto, "Calculadora debe ser una instancia de Producto");
        assertTrue(libro instanceof Producto, "Libro debe ser una instancia de Producto");
        assertTrue(licuadora instanceof Producto,"Licuadora debe ser una instancia de Producto");
        assertTrue(tostadora instanceof Producto,"Tostadora debe ser una instancia de Producto");
        assertTrue(camisetaPromocional instanceof Producto,"Camiseta Promocional debe ser una instancia de Producto");

        // Verificar que las instancias son también instancias de Familias
        assertTrue(television instanceof ProductoElectronico, "Televisor debe ser una instancia de ProductoElectronico");
        assertTrue(celular instanceof ProductoElectronico, "Celular debe ser una instancia de ProductoElectronico");
        assertTrue(calculadora instanceof ProductoElectronico, "Calculadora debe ser una instancia de ProductoElectronico");
        assertTrue(libro instanceof ProductoLiterario, "Libro debe ser una instancia de ProductoLiterario");
        assertTrue(licuadora instanceof ProductoElectroDomestico, "Licuadora  debe ser una instancia de ProductoElectroDomestico");
        assertTrue(tostadora instanceof ProductoElectroDomestico, "Tostadora debe ser una instancia de ProductoElectroDomestico");
        assertTrue(camisetaPromocional instanceof ProductoPromocional, "Camiseta Promocional debe ser una instancia de ProductoPromocional");
    }

    @Test
    public void testAplicarDescuentoHerenciaProductoPromocional() {
        // Crear una instancia de ProductoPromocional usando Camiseta
        ProductoPromocional productoPromocional = new CamisetaPromocional("9","Camiseta Deportiva",19.99,"Camiseta de algodón para deportes","ProductoPromocional",
                                                                    "L","Rojo");

        // Aplicar un descuento no válido, porque es el 
        //método aplicarDescuento no existe en la clase CamisetaPromocional
        productoPromocional.aplicarDescuento(20);
        assertEquals(19.99, productoPromocional.getPrecio(), 0.01);

        // Aplicar un descuento no válido, porque es el 
        //método aplicarDescuento no existe en la clase CamisetaPromocional
        productoPromocional.aplicarDescuento(110);
        assertEquals(19.99, productoPromocional.getPrecio(), 0.01); // El precio no debe cambiar

        // Aplicar otro descuento válido
        productoPromocional.aplicarDescuento(100);
        assertEquals(19.99, productoPromocional.getPrecio(), 0.01);
    }
    
 
}