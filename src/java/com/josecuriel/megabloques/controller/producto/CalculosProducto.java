
package com.josecuriel.megabloques.controller.producto;

import com.josecuriel.megabloques.model.producto.Producto;
import java.io.Serializable;


public class CalculosProducto implements Serializable{
    
    
    public int utilidad(Producto p){
        int utilidad = 0;
        
        utilidad = (int) (p.getPrecioVenta() - p.getCosto());
        if (utilidad < 0) {
            return 0;
        }
        return utilidad;
        
    }
    
}
