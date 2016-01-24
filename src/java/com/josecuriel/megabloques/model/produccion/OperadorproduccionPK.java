/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.josecuriel.megabloques.model.produccion;

import java.io.Serializable;
 
public class OperadorproduccionPK implements Serializable {
     
    private int idoperadorproduccion;
    
    
    private int empleado;
     
    private int produccion;
     
    private int producto;

    public OperadorproduccionPK() {
    }

    public OperadorproduccionPK(int idoperadorproduccion, int empleado, int produccion, int producto) {
        this.idoperadorproduccion = idoperadorproduccion;
        this.empleado = empleado;
        this.produccion = produccion;
        this.producto = producto;
    }

    public int getIdoperadorproduccion() {
        return idoperadorproduccion;
    }

    public void setIdoperadorproduccion(int idoperadorproduccion) {
        this.idoperadorproduccion = idoperadorproduccion;
    }

    public int getEmpleado() {
        return empleado;
    }

    public void setEmpleado(int empleado) {
        this.empleado = empleado;
    }

    public int getProduccion() {
        return produccion;
    }

    public void setProduccion(int produccion) {
        this.produccion = produccion;
    }

    public int getProducto() {
        return producto;
    }

    public void setProducto(int producto) {
        this.producto = producto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idoperadorproduccion;
        hash += (int) empleado;
        hash += (int) produccion;
        hash += (int) producto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OperadorproduccionPK)) {
            return false;
        }
        OperadorproduccionPK other = (OperadorproduccionPK) object;
        if (this.idoperadorproduccion != other.idoperadorproduccion) {
            return false;
        }
        if (this.empleado != other.empleado) {
            return false;
        }
        if (this.produccion != other.produccion) {
            return false;
        }
        if (this.producto != other.producto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.josecuriel.megabloques.model.produccion.OperadorproduccionPK[ idoperadorproduccion=" + idoperadorproduccion + ", empleado=" + empleado + ", produccion=" + produccion + ", producto=" + producto + " ]";
    }
    
}
