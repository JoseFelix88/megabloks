

package com.josecuriel.megabloques.controller.fabricacion;

import com.josecuriel.megabloques.controller.fabricacion.factory.FabricacionDAOFactory;
import com.josecuriel.megabloques.model.produccion.ProduccionDAO;
import com.josecuriel.megabloques.model.produccion.Producciones;
import com.josecuriel.megabloques.model.producto.Producto;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;


@ManagedBean
@ViewScoped
public class FabricacionBean implements Serializable{

    FabricacionDAOFactory factory = new FabricacionDAOFactory();
    private Producciones produccion;
    ProduccionDAO dAO = factory.produccion();
    
    @PostConstruct
    public void init(){
        produccion = new Producciones();
    }

    public Producciones getProduccion() {
        return produccion;
    }

    public void setProduccion(Producciones produccion) {
        this.produccion = produccion;
    }
    
    public void addproduccion(ActionEvent event){
        
    }
    
    public void findBYproducto(ActionEvent event, Object o){

        System.out.println("opcion seleccionada "+o);
        produccion.setProductos(factory.producto().read(o));
    }
}
