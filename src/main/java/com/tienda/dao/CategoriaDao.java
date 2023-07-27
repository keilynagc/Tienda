
package com.tienda.dao;

import com.tienda.domain.Categoria;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaDao extends JpaRepository<Categoria, Long> {
    //Métodos ampliados más adelante
    
    List<Categoria> findByDescripcion (String descripcion); //Debe ser alguna de las variables ya declaradas en CategoriaDomain y debe recibir algo del mismo tipo del que estoy filtrando
    
}
