package com.josecuriel.megabloques.model.producto;

import com.josecuriel.megabloques.model.empleado.Empleados;
import com.josecuriel.megabloques.model.producto.categoria.Categoria;
import java.io.Serializable;
import java.util.Date;

public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;

    private int idproductos;

    private String codigobarras;

    private String descripcion;

    private float stockActual;

    private float stockMinimo;

    private float stockAviso;

    private float costo;

    private int precioVenta;

    private int utilidad;
    
    private float ancho;

    private float alto;
    
    private float espesor;

    private float peso;

    private int estado;

    private Date fechacreacion;

    private String imagen;
    
    private Categoria categoria = new Categoria();

    private Empleados empleados = new Empleados();

    public Producto() {
    }

    public Producto(int idproductos) {
        this.idproductos = idproductos;
    }

    public int getIdproductos() {
        return idproductos;
    }

    public void setIdproductos(int idproductos) {
        this.idproductos = idproductos;
    }

    public String getCodigobarras() {
        return codigobarras;
    }

    public void setCodigobarras(String codigobarras) {
        this.codigobarras = codigobarras;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getStockActual() {
        return stockActual;
    }

    public void setStockActual(float stockActual) {
        this.stockActual = stockActual;
    }

    public float getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(float stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public float getStockAviso() {
        return stockAviso;
    }

    public void setStockAviso(float stockAviso) {
        this.stockAviso = stockAviso;
    }

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public int getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(int precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getUtilidad() {
       
        return utilidad;
    }

    public void setUtilidad(int utilidad) {
       
        this.utilidad = utilidad;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Date getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Date fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Empleados getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleados empleados) {
        this.empleados = empleados;
    }

    public float getAncho() {
        return ancho;
    }

    public void setAncho(float ancho) {
        this.ancho = ancho;
    }

    public float getAlto() {
        return alto;
    }

    public void setAlto(float alto) {
        this.alto = alto;
    }

    

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getEspesor() {
        return espesor;
    }

    public void setEspesor(float espesor) {
        this.espesor = espesor;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

}
