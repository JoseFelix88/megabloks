/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.josecuriel.megabloques.model.empleado;

import com.josecuriel.megabloques.model.produccion.Operadorproduccion;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Empleados implements Serializable {
    
    private byte[] huella;
    private static final long serialVersionUID = 1L;
    
    private Integer idempleados;
    
    private String tipodocumento;
    
    private String nombre1;
   
    private String nombre2;
    
    private String apellido1;
    
    private String apellido2;
    
    private String telefono;
    
    private String direccion;
    
    private String email;
    
    private String cargo;
    
    private String departamento;
    
    private String tipocontrato;
    
    private String formapago;
   
    private Integer sueldobase;
    
    private Date fechaingreso;
    
    private Date fechasalida;
    
    private Boolean estado;
    
    private String foto;
    
    private String contrasenia;
    private List<Operadorproduccion> operadorproduccionList;

    public Empleados() {
    }

    public Empleados(Integer idempleados) {
        this.idempleados = idempleados;
    }

    public Integer getIdempleados() {
        return idempleados;
    }

    public void setIdempleados(Integer idempleados) {
        this.idempleados = idempleados;
    }

    public String getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(String tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getTipocontrato() {
        return tipocontrato;
    }

    public void setTipocontrato(String tipocontrato) {
        this.tipocontrato = tipocontrato;
    }

    public String getFormapago() {
        return formapago;
    }

    public void setFormapago(String formapago) {
        this.formapago = formapago;
    }

    public Integer getSueldobase() {
        return sueldobase;
    }

    public void setSueldobase(Integer sueldobase) {
        this.sueldobase = sueldobase;
    }

    public Date getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(Date fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    public Date getFechasalida() {
        return fechasalida;
    }

    public void setFechasalida(Date fechasalida) {
        this.fechasalida = fechasalida;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
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
        hash += (idempleados != null ? idempleados.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleados)) {
            return false;
        }
        Empleados other = (Empleados) object;
        if ((this.idempleados == null && other.idempleados != null) || (this.idempleados != null && !this.idempleados.equals(other.idempleados))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.josecuriel.megabloques.model.produccion.Empleados[ idempleados=" + idempleados + " ]";
    }

    public byte[] getHuella() {
        return huella;
    }

    public void setHuella(byte[] huella) {
        this.huella = huella;
    }

    public String getContracenia() {
        return contrasenia;
    }

    public void setContracenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    
}
