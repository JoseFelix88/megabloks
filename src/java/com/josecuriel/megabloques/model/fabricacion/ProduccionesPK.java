/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.josecuriel.megabloques.model.fabricacion;

import java.io.Serializable;


public class ProduccionesPK implements Serializable {
     
    private int idproducciones;
    
    private int productofinal;

    public ProduccionesPK() {
    }

    public ProduccionesPK(int idproducciones, int productofinal) {
        this.idproducciones = idproducciones;
        this.productofinal = productofinal;
    }

    public int getIdproducciones() {
        return idproducciones;
    }

    public void setIdproducciones(int idproducciones) {
        this.idproducciones = idproducciones;
    }

    public int getProductofinal() {
        return productofinal;
    }

    public void setProductofinal(int productofinal) {
        this.productofinal = productofinal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idproducciones;
        hash += (int) productofinal;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProduccionesPK)) {
            return false;
        }
        ProduccionesPK other = (ProduccionesPK) object;
        if (this.idproducciones != other.idproducciones) {
            return false;
        }
        if (this.productofinal != other.productofinal) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.josecuriel.megabloques.model.produccion.ProduccionesPK[ idproducciones=" + idproducciones + ", productofinal=" + productofinal + " ]";
    }
    
}
