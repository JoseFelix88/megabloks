 
package com.josecuriel.megabloques.model.producto.categoria;

import com.josecuriel.megabloques.model.producto.Producto;
import java.io.Serializable;
import java.util.List;

 
public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;
    
   
    private Integer idcategorias;
    
    private String descripcion;
    
    private List<Producto> productosList;

    public Categoria() {
    }

    public Categoria(Integer idcategorias) {
        this.idcategorias = idcategorias;
    }

    public Integer getIdcategorias() {
        return idcategorias;
    }

    public void setIdcategorias(Integer idcategorias) {
        this.idcategorias = idcategorias;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Producto> getProductosList() {
        return productosList;
    }

    public void setProductosList(List<Producto> productosList) {
        this.productosList = productosList;
    }

   
    
}
