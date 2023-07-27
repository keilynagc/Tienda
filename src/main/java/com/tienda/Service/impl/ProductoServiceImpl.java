
package com.tienda.Service.impl;

import com.tienda.Service.ProductoService;
import com.tienda.dao.ProductoDao;
import com.tienda.domain.Producto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//Implements osea que va heredar los metodos de en este caso Producto Service por eso debo hacer el import 
//Necesito definir los métodos de producto service 
@Service   //NOTACIÓN PARA IMPLEMENTAR LA LOGICA DE LA CLASE CATEGORIA SERVICIOS EN SPRINGBOOT
public class ProductoServiceImpl implements ProductoService{
    @Autowired //permite acceder a variable de un objeto y si no existe la crea. 
    private ProductoDao productoDao;
    @Override
    @Transactional(readOnly=true)
    public List<Producto> getProductos(boolean activos) {
        List<Producto> lista = productoDao.findAll(); //para que traiga todos los objetos de esa table Producto y los guarde en lista.
        
        if(activos){
            //Para remover las productos donde activo = false
            lista.removeIf(x -> !x.isActivo());
        }
        
        return lista;
    }
       @Override
    @Transactional(readOnly = true)
    public Producto getProducto(Producto producto) {
        return productoDao.findById(producto.getIdProducto()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Producto producto) {
        productoDao.save(producto);
    }

    @Override
    @Transactional
    public void delete(Producto producto) {
        productoDao.delete(producto);
    }
    
    // Lista de productos con precio entre ordendados por descripción ConsultaAmpliada
    @Override
    @Transactional(readOnly=true)
    public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup) {
      return productoDao.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
    }
    
    @Override
    @Transactional(readOnly=true)    
    public List<Producto> metodoJPQL(double precioInf, double precioSup) {
        return productoDao.metodoJPQL(precioInf, precioSup);
    }
    
    @Override
    @Transactional(readOnly=true)    
    public List<Producto> metodoNativo(double precioInf, double precioSup) {
        return productoDao.metodoNativo(precioInf, precioSup);
    }
     
    
}
