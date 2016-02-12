/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.josecuriel.megabloques.model.fabricacion;

import java.io.Serializable;


public class DetalleproduccionPK implements Serializable {
     
    private int iddetalleproduccion;
    
    private int produccion;
     
    private int insumo;

    public DetalleproduccionPK() {
    }

    public DetalleproduccionPK(int iddetalleproduccion, int produccion, int insumo) {
        this.iddetalleproduccion = iddetalleproduccion;
        this.produccion = produccion;
        this.insumo = insumo;
    }

    public int getIddetalleproduccion() {
        return iddetalleproduccion;
    }

    public void setIddetalleproduccion(int iddetalleproduccion) {
        this.iddetalleproduccion = iddetalleproduccion;
    }

    public int getProduccion() {
        return produccion;
    }

    public void setProduccion(int produccion) {
        this.produccion = produccion;
    }

    public int getInsumo() {
        return insumo;
    }

    public void setInsumo(int insumo) {
        this.insumo = insumo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) iddetalleproduccion;
        hash += (int) produccion;
        hash += (int) insumo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleproduccionPK)) {
            return false;
        }
        DetalleproduccionPK other = (DetalleproduccionPK) object;
        if (this.iddetalleproduccion != other.iddetalleproduccion) {
            return false;
        }
        if (this.produccion != other.produccion) {
            return false;
        }
        if (this.insumo != other.insumo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.josecuriel.megabloques.model.produccion.DetalleproduccionPK[ iddetalleproduccion=" + iddetalleproduccion + ", produccion=" + produccion + ", insumo=" + insumo + " ]";
    }
    
}
