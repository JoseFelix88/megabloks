

package com.josecuriel.megabloques.model.fabricacion;

import com.josecuriel.megabloques.model.producto.Producto;
import java.io.Serializable;

import java.util.Date;
import java.util.List;
 


public class Producciones implements Serializable {
    private static final long serialVersionUID = 1L;
    
    protected ProduccionesPK produccionesPK;
    
    private int idproduccion;
    
    private Date fechafabricacion;
     
    private long costototal;
    
    private Date horainicio;
     
    private Date horafinal;
    
    private String numerolote;
     
    private int cantidadproducida;
   
    private int estado;
    
    private Producto productos = new Producto();
    
    private Detalleproduccion detalleproduccion = new Detalleproduccion();
    
    private Operadorproduccion operadorproduccion;
    
    private List<Detalleproduccion> detalleproduccionList;
     
    private List<Operadorproduccion> operadorproduccionList;

    public Producciones() {
    }

    public Producciones(ProduccionesPK produccionesPK) {
        this.produccionesPK = produccionesPK;
    }

    public Producciones(int idproducciones, int productofinal) {
        this.produccionesPK = new ProduccionesPK(idproducciones, productofinal);
    }

    public ProduccionesPK getProduccionesPK() {
        return produccionesPK;
    }

    public void setProduccionesPK(ProduccionesPK produccionesPK) {
        this.produccionesPK = produccionesPK;
    }

    public Date getFechafabricacion() {
        return fechafabricacion;
    }

    public void setFechafabricacion(Date fechafabricacion) {
        this.fechafabricacion = fechafabricacion;
    }

    public long getCostototal() {
        return costototal;
    }

    public void setCostototal(long costototal) {
        this.costototal = costototal;
    }

    public Date getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(Date horainicio) {
        this.horainicio = horainicio;
    }

    public Date getHorafinal() {
        return horafinal;
    }

    public void setHorafinal(Date horafinal) {
        this.horafinal = horafinal;
    }

    public String getNumerolote() {
        return numerolote;
    }

    public void setNumerolote(String numerolote) {
        this.numerolote = numerolote;
    }

    public int getCantidadproducida() {
        return cantidadproducida;
    }

    public void setCantidadproducida(int cantidadproducida) {
        this.cantidadproducida = cantidadproducida;
    }

    public Producto getProductos() {
        return productos;
    }

    public void setProductos(Producto productos) {
        this.productos = productos;
    }

     
    public List<Detalleproduccion> getDetalleproduccionList() {
        return detalleproduccionList;
    }

    public void setDetalleproduccionList(List<Detalleproduccion> detalleproduccionList) {
        this.detalleproduccionList = detalleproduccionList;
    }

    
    public List<Operadorproduccion> getOperadorproduccionList() {
        return operadorproduccionList;
    }

    public void setOperadorproduccionList(List<Operadorproduccion> operadorproduccionList) {
        this.operadorproduccionList = operadorproduccionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (produccionesPK != null ? produccionesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producciones)) {
            return false;
        }
        Producciones other = (Producciones) object;
        if ((this.produccionesPK == null && other.produccionesPK != null) || (this.produccionesPK != null && !this.produccionesPK.equals(other.produccionesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.josecuriel.megabloques.model.produccion.Producciones[ produccionesPK=" + produccionesPK + " ]";
    }

    public int getIdproduccion() {
        return idproduccion;
    }

    public void setIdproduccion(int idproduccion) {
        this.idproduccion = idproduccion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Detalleproduccion getDetalleproduccion() {
        return detalleproduccion;
    }

    public void setDetalleproduccion(Detalleproduccion detalleproduccion) {
        this.detalleproduccion = detalleproduccion;
    }

    public Operadorproduccion getOperadorproduccion() {
        return operadorproduccion;
    }

    public void setOperadorproduccion(Operadorproduccion operadorproduccion) {
        this.operadorproduccion = operadorproduccion;
    }
    
}
