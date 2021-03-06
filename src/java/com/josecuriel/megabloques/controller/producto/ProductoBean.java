package com.josecuriel.megabloques.controller.producto;

import com.josecuriel.megabloques.model.producto.Producto;
import com.josecuriel.megabloques.model.producto.ProductoDAO;
import com.josecuriel.megabloques.model.producto.categoria.Categoria;
import com.josecuriel.megabloques.model.producto.categoria.CategoriaDAO;
import com.josecuriel.megabloques.model.util.Generador_de_Codigos;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.servlet.ServletContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.UploadedFile;

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
    private List<Producto> listInsumos;
    private List<Producto> listFabricados;

    private UploadedFile imgproducto;

    private final CalculosProducto cp = new CalculosProducto();
    Generador_de_Codigos gc = new Generador_de_Codigos();

    @PostConstruct
    public void init() {
        producto = new Producto();
        productoDAO = new ProductoDAO();
        listcategoria = cdao.readAll();
        cargarListaproducto();
    }

    private void cargarListaproducto() {
        listProductos = new ArrayList<>();
        filtrolistProductos = new ArrayList<>();
        listInsumos = new ArrayList<>();
        listFabricados = new ArrayList<>();
        listInsumos = productoDAO.ListarInsumos();
        listFabricados = productoDAO.ListarProductosFabricados();
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
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, null, "EL PRODUCTO ESTA REGISTRADO."));
        }
    }

    public void update(ActionEvent event) {
        if (productoDAO.CodigoProducto(producto.getCodigobarras()) != true) {
            boolean rs = productoDAO.update(producto);
            if (rs != false) {
                cargarListaproducto();
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, null,
                                "PRODUCTO ACTUALIZADO CORRECTAMENTE."));
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, null,
                            "PRODUCTO NO PUDO SER ACTUALIZADO. DEVIDO AQUE NO ESTA REGISTRADO."));
        }
    }

    public void delete(ActionEvent event) {
        if (productoDAO.CodigoProducto(producto.getCodigobarras()) != true) {
            boolean rs = productoDAO.delete(producto.getIdproductos());
            if (rs != false) {
                cargarListaproducto();
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, null,
                                "PRODUCTO ELIMINADO CORRECTAMENTE."));
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, null,
                            "PRODUCTO NO PUDO SER ELIMINADO, DEVIDO AQUE NO ESTA REGISTRADO."));
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

    public void nuevo(ActionEvent ae) {
        producto = new Producto();
        producto.setCodigobarras(gc.getCodigoAleatorioNumerico());
    }

    /*EL SIGUIENTE METODO Y TODO EL FUNCIONAMIENTO DE ESTA PARTE DEL PROYECTO
     --REFERENTE A LA CARGA DE UNA IMAGEN A UNA CARPETA DEL SERVIDOR HACIDO TOMADO DE LA ENTRADA DEL BLOG:
     --http://todoenjava.blogspot.com.co/2014/06/jsf-appagenda-parte-24-subir-imagen-al.html*/
    public void agregarimgproducto() throws IOException {
        
        if (productoDAO.CodigoProducto(producto.getCodigobarras()) != true) {
            
            InputStream inputStream = null;
            OutputStream outputStream = null;
            String[] extenciones = {".jpeg", ".png", ".gif", ".tiff", ".bmp"};
            String tipoarchivo = imgproducto.getContentType().replace("image/", ".");

            try {

                if (this.imgproducto.getSize() <= 0) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error:", "Ud. debe seleccionar un archivo de imagen \".png\""));
                    return;
                }

                if (this.imgproducto.getSize() > 2097152) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error:", "El archivo no puede ser más de 2mb"));
                    return;
                }

                ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
                String folderimgproductos = (String) servletContext.getRealPath("/resources/imgproductos");
                for (String extencione : extenciones) {
                    if (extencione == null ? tipoarchivo == null : extencione.equals(tipoarchivo)) {

                        outputStream = new FileOutputStream(new File(folderimgproductos + "/" + this.producto.getCodigobarras() + "" + tipoarchivo));
                        inputStream = this.imgproducto.getInputstream();
                        int read = 0;
                        byte[] bytes = new byte[1024];

                        while ((read = inputStream.read(bytes)) != -1) {
                            outputStream.write(bytes, 0, read);
                        }

                        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto:", "Imagen del Producto Subida correctamente"));

                        productoDAO.agregarImagenProducto(producto.getCodigobarras(), producto.getCodigobarras() + "" + tipoarchivo);
                        cargarListaproducto();
                    }
                }
            } catch (Exception ex) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error fatal:", "Por favor contacte con su administrador " + ex.getMessage()));
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }

                if (outputStream != null) {
                    outputStream.close();
                }
            }
        } else {
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL,
                    null, "La Imagen del Producto NO! hasido Subida por que el producto aun no seá Registrado."));
        }
    }

    public UploadedFile getImgproducto() {
        return imgproducto;
    }

    public void setImgproducto(UploadedFile imgproducto) {
        this.imgproducto = imgproducto;
    }

    public List<Producto> getListInsumos() {
        return listInsumos;
    }

    public void setListInsumos(List<Producto> listInsumos) {
        this.listInsumos = listInsumos;
    }

    public List<Producto> getListFabricados() {
        return listFabricados;
    }

    public void setListFabricados(List<Producto> listFabricados) {
        this.listFabricados = listFabricados;
    }
}
