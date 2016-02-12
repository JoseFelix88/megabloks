package com.josecuriel.megabloques.controller.fabricacion;

import com.josecuriel.megabloques.controller.fabricacion.factory.FabricacionDAOFactory;
import com.josecuriel.megabloques.model.fabricacion.ProduccionDAO;
import com.josecuriel.megabloques.model.fabricacion.Producciones;
import com.josecuriel.megabloques.model.util.Utilidades;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

@ManagedBean
@ViewScoped
public class FabricacionBean implements Serializable {

    FabricacionDAOFactory factory = new FabricacionDAOFactory();
    private Producciones produccion;
    ProduccionDAO dAO = factory.produccion();
    private Date fechafabrica;
    Calendar ff = new GregorianCalendar();

    int costototal = 0;
    private String numero_lote;
    Utilidades util = new Utilidades();

    @PostConstruct
    public void init() {
        produccion = new Producciones();
        fechafabrica = ff.getTime();
        numero_lote = produccion.getIdproduccion() + "-" + util.formatearFecha(fechafabrica).replace("-", "").replace("/", "");

    }

    public Producciones getProduccion() {
        return produccion;
    }

    public void setProduccion(Producciones produccion) {
        this.produccion = produccion;
    }

    public void addproduccion(ActionEvent event) {

    }

    public void findBYproducto(ActionEvent event, Object idproducto) {
        
        produccion.setProductos(factory.producto().read(idproducto));
    }

    public void TotalCosto(ActionEvent event, int cantidad) {
        costototal = (int) (cantidad * produccion.getProductos().getCosto());
        produccion.getDetalleproduccion().setCosto(costototal);
    }

    public void registrar_produccion() {

        if (factory.produccion().read(produccion.getIdproduccion()) == null) {
            produccion.setFechafabricacion(fechafabrica);
            produccion.setNumerolote(numero_lote);

            factory.produccion().create(produccion);
            factory.produccion().ingresarInsumos(produccion);
            factory.produccion().ingresarOperadorProduccion(produccion);
        } else {
            factory.produccion().ingresarInsumos(produccion);
            factory.produccion().ingresarOperadorProduccion(produccion);
        }
    }

    public Date getFechafabrica() {
        return fechafabrica;
    }

    public void setFechafabrica(Date fechafabrica) {
        this.fechafabrica = fechafabrica;
    }

    public String getNumero_lote() {
        return numero_lote;
    }

    public void setNumero_lote(String numero_lote) {
        this.numero_lote = numero_lote;
    }
}
