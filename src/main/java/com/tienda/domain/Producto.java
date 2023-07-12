/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="producto")
public class Producto implements Serializable{
     //Versión de serialización
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_producto")
    
    private Long idProducto;
    private String descripcion;
    private String detalle;
    private double precio;
    private int existencias;
    private String rutaImagen;
    private boolean activo;
    
    @ManyToOne //muchas productos tienen 1 sola categoria
    @JoinColumn(name="id_categoria") //cambio de la tabla producto con el que hacemos relación
    private Categoria categoria;

    public Producto() {
    }

    
    
    
    
      
    
    
    
    
    
    
}
