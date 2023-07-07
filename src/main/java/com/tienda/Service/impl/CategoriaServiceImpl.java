
package com.tienda.Service.impl;

import com.tienda.Service.CategoriaService;
import com.tienda.dao.CategoriaDao;
import com.tienda.domain.Categoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//Implements osea que va heredar los metodos de en este caso Categoria Service por eso debo hacer el import 
//Necesito definir los métodos de categoria service 
@Service   //NOTACIÓN PARA IMPLEMENTAR LA LOGICA DE LA CLASE CATEGORIA SERVICIOS EN SPRINGBOOT
public class CategoriaServiceImpl implements CategoriaService{
    @Autowired //permite acceder a variable de un objeto y si no existe la crea. 
    private CategoriaDao categoriaDao;
    @Override
    @Transactional(readOnly=true)
    public List<Categoria> getCategorias(boolean activos) {
        List<Categoria> lista = categoriaDao.findAll(); //para que traiga todos los objetos de esa table Categoria y los guarde en lista.
        
        if(activos){
            //Para remover las categorias donde activo = false
            lista.removeIf(x -> !x.isActivo());
        }
        
        return lista;
    }
       @Override
    @Transactional(readOnly = true)
    public Categoria getCategoria(Categoria categoria) {
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Categoria categoria) {
        categoriaDao.save(categoria);
    }

    @Override
    @Transactional
    public void delete(Categoria categoria) {
        categoriaDao.delete(categoria);
    }
    
}
