
package com.tienda.controller;

import com.tienda.Service.CategoriaService;
import com.tienda.Service.ProductoService;
import com.tienda.Service.impl.FirebaseStorageServiceImpl;
import com.tienda.domain.Categoria;
import com.tienda.domain.Producto;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
@Slf4j
@RequestMapping("/producto")
public class ProductoController {
    
    @Autowired
    ProductoService productoService; //para conocer los métodos
    
    @Autowired
    CategoriaService categoriaService;
    
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    
    @GetMapping("/listado")
    public String inicio(Model model) {
        log.info("Consumiendo el recurso /producto/listado");
        List<Producto> productos = productoService.getProductos(false);
        List<Categoria> categorias =categoriaService.getCategorias(true); //True para traer solo las categorias activas
        model.addAttribute("productos",productos);
        model.addAttribute("categorias",categorias);
        model.addAttribute("totalProductos", productos.size());
        return "/producto/listado";
    }
    
    @GetMapping("/nuevo")
    public String productoNuevo(Producto producto) {
        return "/producto/modifica";
    }

    
    
    @PostMapping("/guardar")
    public String productoGuardar(Producto producto,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            productoService.save(producto);
            producto.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "producto", 
                            producto.getIdProducto()));
        }
        productoService.save(producto);
        return "redirect:/producto/listado";
    }

    @GetMapping("/eliminar/{idProducto}")
    public String productoEliminar(Producto producto) {
        productoService.delete(producto);
        return "redirect:/producto/listado";
    }

    @GetMapping("/modificar/{idProducto}")
    public String productoModificar(Producto producto, Model model) {
        producto = productoService.getProducto(producto);
        List<Categoria> categorias =categoriaService.getCategorias(true);
        model.addAttribute("categorias",categorias);
        model.addAttribute("producto", producto);
        return "/producto/modifica";
    }
}

    

