package com.josecuriel.megabloques.controller.empleado;

import com.josecuriel.megabloques.model.empleado.EmpleadoDAO;
import com.josecuriel.megabloques.model.empleado.Empleados;
import com.josecuriel.megabloques.model.producto.Producto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.event.SelectEvent;

@ManagedBean
@ViewScoped
public class EmpleadoBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Empleados empleado;
    private List<Empleados> listEmpleados, filtrolistEmpleados;
    EmpleadoDAO dAO;

    @PostConstruct
    public void init() {
        empleado = new Empleados();
        dAO = new EmpleadoDAO();
        listEmpleados = new ArrayList<>();
        filtrolistEmpleados = new ArrayList<>();
        cargarlistaempleados();
    }

    public void cargarlistaempleados() {
        listEmpleados = dAO.readAll();
        filtrolistEmpleados = listEmpleados;
    }

    public void save(ActionEvent ae) {
        if (dAO.read(empleado.getIdempleados()) == null) {
            if (dAO.create(empleado) != false) {
                FacesContext.getCurrentInstance().addMessage("",
                        new FacesMessage(FacesMessage.SEVERITY_INFO, null, "EMPLEADO REGISTRADO CORRECTAMENTE."));
            } else {
                FacesContext.getCurrentInstance().addMessage("",
                        new FacesMessage(FacesMessage.SEVERITY_INFO, null, "EMPLEADO NO FUE REGISTRADO."));
            }
        } else {
            FacesContext.getCurrentInstance().addMessage("",
                    new FacesMessage(FacesMessage.SEVERITY_INFO, null, "EL EMPLEADO  SE ENCUENTRA REGISTRADO."));
        }
    }

    public void update(ActionEvent ae) {
        if (dAO.read(empleado.getIdempleados()) != null) {
            if (dAO.update(empleado) != false) {
                FacesContext.getCurrentInstance().addMessage("",
                        new FacesMessage(FacesMessage.SEVERITY_INFO, null, "EMPLEADO ACTUALIZADO CORRECTAMENTE."));
            } else {
                FacesContext.getCurrentInstance().addMessage("",
                        new FacesMessage(FacesMessage.SEVERITY_INFO, null, "EMPLEADO NO FUE ACTUALIZADO."));
            }
        } else {
            FacesContext.getCurrentInstance().addMessage("",
                    new FacesMessage(FacesMessage.SEVERITY_INFO, null, "EL EMPLEADO NO SE ENCUENTRA REGISTRADO."));
        }
    }

    public void delete(ActionEvent ae) {
        if (dAO.read(empleado.getIdempleados()) != null) {
            if (dAO.delete(empleado.getIdempleados()) != false) {
                FacesContext.getCurrentInstance().addMessage("",
                        new FacesMessage(FacesMessage.SEVERITY_INFO, null, "EMPLEADO ELIMINADO CORRECTAMENTE."));
            } else {
                FacesContext.getCurrentInstance().addMessage("",
                        new FacesMessage(FacesMessage.SEVERITY_INFO, null, "EMPLEADO NO FUE ELIMINADO."));
            }
        } else {
            FacesContext.getCurrentInstance().addMessage("",
                    new FacesMessage(FacesMessage.SEVERITY_INFO, null, "EL EMPLEADO NO SE ENCUENTRA REGISTRADO."));
        }
    }

    public Empleados getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleados empleado) {
        this.empleado = empleado;
    }

    public List<Empleados> getListEmpleados() {
        return listEmpleados;
    }

    public void setListEmpleados(List<Empleados> listEmpleados) {
        this.listEmpleados = listEmpleados;
    }

    public List<Empleados> getFiltrolistEmpleados() {
        return filtrolistEmpleados;
    }

    public void setFiltrolistEmpleados(List<Empleados> filtrolistEmpleados) {
        this.filtrolistEmpleados = filtrolistEmpleados;
    }

    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Empleado: ",
                ((Empleados) event.getObject()).getApellido1() + " " + ((Empleados) event.getObject()).getNombre1());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void nuevo(ActionEvent ae) {
        empleado = new Empleados();
    }
}
