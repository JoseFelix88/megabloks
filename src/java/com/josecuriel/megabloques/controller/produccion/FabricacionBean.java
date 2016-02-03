

package com.josecuriel.megabloques.controller.produccion;

import com.josecuriel.megabloques.model.produccion.ProduccionDAO;
import com.josecuriel.megabloques.model.produccion.Producciones;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean
@ViewScoped
public class FabricacionBean implements Serializable{

    private Producciones produccion;
    ProduccionDAO dAO;
    
    public void init(){
        produccion = new Producciones();
        dAO = new ProduccionDAO();
    }

    public Producciones getProduccion() {
        return produccion;
    }

    public void setProduccion(Producciones produccion) {
        this.produccion = produccion;
    }
    
    
}
