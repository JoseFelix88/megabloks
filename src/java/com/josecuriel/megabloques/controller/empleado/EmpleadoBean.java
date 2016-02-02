package com.josecuriel.megabloques.controller.empleado;

import com.josecuriel.megabloques.model.empleado.EmpleadoDAO;
import com.josecuriel.megabloques.model.empleado.Empleados;
import com.josecuriel.megabloques.model.producto.Producto;
import com.josecuriel.megabloques.model.util.Utilidades;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.UploadedFile;

@ManagedBean
@ViewScoped
public class EmpleadoBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Empleados empleado;
    private List<Empleados> listEmpleados, filtrolistEmpleados;
    EmpleadoDAO dAO;
    Utilidades util = new Utilidades();
    private UploadedFile fotoEmpleado;

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
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "EMPLEADO NO FUE REGISTRADO."));
            }
        } else {
            FacesContext.getCurrentInstance().addMessage("",
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, null, "EL EMPLEADO  SE ENCUENTRA REGISTRADO."));
        }
    }

    public void update(ActionEvent ae) {
        if (dAO.read(empleado.getIdempleados()) != null) {
            if (dAO.update(empleado) != false) {
                FacesContext.getCurrentInstance().addMessage("",
                        new FacesMessage(FacesMessage.SEVERITY_INFO, null, "EMPLEADO ACTUALIZADO CORRECTAMENTE."));
            } else {
                FacesContext.getCurrentInstance().addMessage("",
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "EMPLEADO NO FUE ACTUALIZADO."));
            }
        } else {
            FacesContext.getCurrentInstance().addMessage("",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "EL EMPLEADO NO SE ENCUENTRA REGISTRADO."));
        }
    }

    public void delete(ActionEvent ae) {
        if (dAO.read(empleado.getIdempleados()) != null) {
            if (dAO.delete(empleado.getIdempleados()) != false) {
                FacesContext.getCurrentInstance().addMessage("",
                        new FacesMessage(FacesMessage.SEVERITY_INFO, null, "EMPLEADO ELIMINADO CORRECTAMENTE."));
            } else {
                FacesContext.getCurrentInstance().addMessage("",
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "EMPLEADO NO FUE ELIMINADO."));
            }
        } else {
            FacesContext.getCurrentInstance().addMessage("",
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "EL EMPLEADO NO SE ENCUENTRA REGISTRADO."));
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

    public UploadedFile getFotoEmpleado() {
        return fotoEmpleado;
    }

    public void setFotoEmpleado(UploadedFile fotoEmpleado) {
        this.fotoEmpleado = fotoEmpleado;
    }

    public void agregarFotoEmpleado(ActionEvent event) throws IOException {

        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String realPath = (String) servletContext.getRealPath("/resources/empleados");
        String urlempleado = realPath.concat("/").concat(String.valueOf(empleado.getIdempleados()).concat("/"));
        File f = new File(urlempleado);
        if (f.isDirectory() == true) {
            System.out.println("ruta- " + f.getPath() + " es una ruta: " + f.isAbsolute());
            util.agregarImagen(fotoEmpleado, urlempleado, String.valueOf(empleado.getIdempleados()),
                    FacesContext.getCurrentInstance());

            String tipoarchivo = fotoEmpleado.getContentType().replace("image/", ".");
            dAO.asignarFotoEmpleado(String.valueOf(empleado.getIdempleados()).concat(tipoarchivo),
                    String.valueOf(empleado.getIdempleados()));

        } else {
            util.crearDirecctorio(urlempleado,
                    String.valueOf(empleado.getIdempleados()));

            util.lanzarMSJ(FacesContext.getCurrentInstance(), 1, "FOLDER PARA EL EMPLEADO " + empleado.getApellido1() + ""
                    + " " + empleado.getNombre1() + " CREADO CORRECTAMENTE.");

            util.agregarImagen(fotoEmpleado, urlempleado, String.valueOf(empleado.getIdempleados()),
                    FacesContext.getCurrentInstance());
        }

        String tipoarchivo = fotoEmpleado.getContentType().replace("image/", ".");
        dAO.asignarFotoEmpleado(String.valueOf(empleado.getIdempleados()).concat(tipoarchivo),
                String.valueOf(empleado.getIdempleados()));
    }

    public boolean verificarEmpleado(ActionEvent event) {
        if (dAO.read(empleado.getIdempleados()) == null) {
            //util.lanzarMSJ(FacesContext.getCurrentInstance(), 2, "POR FAVOR PRIMERO REGISTRA EL EMPLEADO.");
            return false;
        }
        
        return true;
    }
}
