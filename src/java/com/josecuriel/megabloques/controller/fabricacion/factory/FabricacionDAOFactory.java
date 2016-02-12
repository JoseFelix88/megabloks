

package com.josecuriel.megabloques.controller.fabricacion.factory;

import com.josecuriel.megabloques.model.fabricacion.ProduccionDAO;
import com.josecuriel.megabloques.model.producto.ProductoDAO;
import java.io.Serializable;

public class FabricacionDAOFactory implements Serializable{
    
    public ProduccionDAO produccion(){
        return new ProduccionDAO();
    }
    
    public ProductoDAO producto(){
        return new ProductoDAO();
    }
}
