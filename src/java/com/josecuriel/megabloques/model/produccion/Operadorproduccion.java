/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.josecuriel.megabloques.model.produccion;

import com.josecuriel.megabloques.model.empleado.Empleados;
import java.io.Serializable;
import java.util.Date;


public class Operadorproduccion implements Serializable {
    private static final long serialVersionUID = 1L;
     
    protected OperadorproduccionPK operadorproduccionPK;
     
    private Date horaentrada;
     
     
    private Date horasalida;
    
    private Producciones producciones;
    
    private Empleados empleados;

    public Operadorproduccion() {
    }

    public Operadorproduccion(OperadorproduccionPK operadorproduccionPK) {
        this.operadorproduccionPK = operadorproduccionPK;
    }

    public Operadorproduccion(int idoperadorproduccion, int empleado, int produccion, int producto) {
        this.operadorproduccionPK = new OperadorproduccionPK(idoperadorproduccion, empleado, produccion, producto);
    }

    public OperadorproduccionPK getOperadorproduccionPK() {
        return operadorproduccionPK;
    }

    public void setOperadorproduccionPK(OperadorproduccionPK operadorproduccionPK) {
        this.operadorproduccionPK = operadorproduccionPK;
    }

    public Date getHoraentrada() {
        return horaentrada;
    }

    public void setHoraentrada(Date horaentrada) {
        this.horaentrada = horaentrada;
    }

    public Date getHorasalida() {
        return horasalida;
    }

    public void setHorasalida(Date horasalida) {
        this.horasalida = horasalida;
    }

    public Producciones getProducciones() {
        return producciones;
    }

    public void setProducciones(Producciones producciones) {
        this.producciones = producciones;
    }

    public Empleados getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleados empleados) {
        this.empleados = empleados;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (operadorproduccionPK != null ? operadorproduccionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Operadorproduccion)) {
            return false;
        }
        Operadorproduccion other = (Operadorproduccion) object;
        if ((this.operadorproduccionPK == null && other.operadorproduccionPK != null) || (this.operadorproduccionPK != null && !this.operadorproduccionPK.equals(other.operadorproduccionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.josecuriel.megabloques.model.produccion.Operadorproduccion[ operadorproduccionPK=" + operadorproduccionPK + " ]";
    }
    
}
