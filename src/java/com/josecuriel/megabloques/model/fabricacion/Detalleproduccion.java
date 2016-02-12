

package com.josecuriel.megabloques.model.fabricacion;

import com.josecuriel.megabloques.model.producto.Producto;
import java.io.Serializable;


public class Detalleproduccion implements Serializable {
    private static final long serialVersionUID = 1L;
   
    protected DetalleproduccionPK detalleproduccionPK;
  
    private Float cantidad;
   
    private int costo;
    
    private Producto productos = new Producto();
    
    private Producciones producciones;

    public Detalleproduccion() {
    }

    public Detalleproduccion(DetalleproduccionPK detalleproduccionPK) {
        this.detalleproduccionPK = detalleproduccionPK;
    }

    public Detalleproduccion(int iddetalleproduccion, int produccion, int insumo) {
        this.detalleproduccionPK = new DetalleproduccionPK(iddetalleproduccion, produccion, insumo);
    }

    public DetalleproduccionPK getDetalleproduccionPK() {
        return detalleproduccionPK;
    }

    public void setDetalleproduccionPK(DetalleproduccionPK detalleproduccionPK) {
        this.detalleproduccionPK = detalleproduccionPK;
    }

    public Float getCantidad() {
        return cantidad;
    }

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public Producto getProductos() {
        return productos;
    }

    public void setProductos(Producto productos) {
        this.productos = productos;
    }

    public Producciones getProducciones() {
        return producciones;
    }

    public void setProducciones(Producciones producciones) {
        this.producciones = producciones;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detalleproduccionPK != null ? detalleproduccionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detalleproduccion)) {
            return false;
        }
        Detalleproduccion other = (Detalleproduccion) object;
        if ((this.detalleproduccionPK == null && other.detalleproduccionPK != null) || (this.detalleproduccionPK != null && !this.detalleproduccionPK.equals(other.detalleproduccionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.josecuriel.megabloques.model.produccion.Detalleproduccion[ detalleproduccionPK=" + detalleproduccionPK + " ]";
    }
    
}
