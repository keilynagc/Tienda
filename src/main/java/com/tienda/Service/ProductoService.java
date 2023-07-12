
package com.tienda.Service;

import com.tienda.domain.Producto;
import java.util.List;

public interface ProductoService {
    
    //Método que retorna la lista de categorías
    //List porque me va a retornar más de 1 dato y tipo Producto porque es el nombre que tengo en domain que es el archivo donde guardaba los datos
    //Luego sigue el nombre del método "getProductos" SIEMPRE en plural porque devuelvo más de 1, y si recibe parámetros ()
    public List<Producto> getProductos(boolean activos);
    
    // Se obtiene un Producto, a partir del id de un producto
    public Producto getProducto(Producto producto);
    
    // Se inserta un nuevo producto si el id del producto esta vacío
    // Se actualiza un producto si el id del producto NO esta vacío
    public void save(Producto producto);
    
    // Se elimina el producto que tiene el id pasado por parámetro
    public void delete(Producto producto);
    
}
