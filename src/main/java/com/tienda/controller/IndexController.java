/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.tienda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author 50688
 */
@Controller
public class IndexController {
    
    @RequestMapping("/")
    public String page(Model model) {
        model.addAttribute("mensaje", "Hola desde el controlador");
        return "Index"; //vista guardada en templates NO en static// 
    }
    
}
