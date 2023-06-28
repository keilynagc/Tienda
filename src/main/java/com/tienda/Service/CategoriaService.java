
package com.tienda.Service;

import com.tienda.domain.Categoria;
import java.util.List;

public interface CategoriaService {
    
    //Método que retorna la lista de categorías
    //List porque me va a retornar más de 1 dato y tipo Categoria porque es el nombre que tengo en domain que es el archivo donde guardaba los datos
    //Luego sigue el nombre del método "getCategorias" SIEMPRE en plural porque devuelvo más de 1, y si recibe parámetros ()
    public List<Categoria> getCategorias(boolean activos);
    
}
