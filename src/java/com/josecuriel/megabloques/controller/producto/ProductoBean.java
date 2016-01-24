package com.josecuriel.megabloques.controller.producto;

import com.josecuriel.megabloques.model.empleado.EmpleadoDAO;
import com.josecuriel.megabloques.model.producto.Producto;
import com.josecuriel.megabloques.model.producto.ProductoDAO;
import com.josecuriel.megabloques.model.producto.categoria.Categoria;
import com.josecuriel.megabloques.model.producto.categoria.CategoriaDAO;
import com.josecuriel.megabloques.model.util.Generador_de_Codigos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import org.primefaces.event.SelectEvent;

@ManagedBean
@ViewScoped
public class ProductoBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<Categoria> listcategoria = new ArrayList<>();
    private final CategoriaDAO cdao = new CategoriaDAO();

    private ProductoDAO productoDAO;
    private Producto producto;
    private List<Producto> listProductos;
    private List<Producto> filtrolistProductos;

    private final CalculosProducto cp = new CalculosProducto();
    Generador_de_Codigos gc = new Generador_de_Codigos();

    @PostConstruct
    public void init() {
        producto = new Producto();
        producto.setCodigobarras(gc.getCodigoAleatorioNumerico());
        productoDAO = new ProductoDAO();
        listcategoria = cdao.readAll();
        cargarListaproducto();
    }

    private void cargarListaproducto() {
        listProductos = new ArrayList<>();
        filtrolistProductos = new ArrayList<>();
        listProductos = productoDAO.readAll();
        filtrolistProductos = listProductos;

    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setProductoDAO(ProductoDAO productoDAO) {
        this.productoDAO = productoDAO;
    }

    public List<Categoria> getListcategoria() {
        return listcategoria;
    }

    public void setListcategoria(List<Categoria> listcategoria) {
        this.listcategoria = listcategoria;
    }

    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("Producto: ", ((Producto) event.getObject()).getDescripcion());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void save(ActionEvent event) {

        if (productoDAO.CodigoProducto(producto.getCodigobarras()) != false) {

            boolean rs = productoDAO.create(producto);

            if (rs != false) {
                cargarListaproducto();
                FacesContext.getCurrentInstance().addMessage("",
                        new FacesMessage(FacesMessage.SEVERITY_INFO, null, "PRODUCTO REGISTRADO CORRECTAMENTE."));
            }
        } else {
            FacesContext.getCurrentInstance().addMessage("",
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, null, "PRODUCTO NO PUDO SER REGISTRADO. EL CODIGO DE BARRAS ESTA REGISTRADO, GENERA UNO NUEVO POR FAVOR."));
        }
    }

    public void update(ActionEvent event) {
        boolean rs = productoDAO.update(producto);
        if (rs != false) {
            cargarListaproducto();
            FacesContext.getCurrentInstance().addMessage("",
                    new FacesMessage(FacesMessage.SEVERITY_INFO, null, "PRODUCTO ACTUALIZADO CORRECTAMENTE."));
        } else {
            FacesContext.getCurrentInstance().addMessage("",
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, null, "PRODUCTO NO PUDO SER ACTUALIZADO."));
        }
    }

    public List<Producto> getListProductos() {
        return listProductos;
    }

    public void setListProductos(List<Producto> listProductos) {
        this.listProductos = listProductos;
    }

    public List<Producto> getFiltrolistProductos() {
        return filtrolistProductos;
    }

    public void setFiltrolistProductos(List<Producto> filtrolistProductos) {
        this.filtrolistProductos = filtrolistProductos;
    }

    public CalculosProducto getCp() {
        return cp;
    }

}
