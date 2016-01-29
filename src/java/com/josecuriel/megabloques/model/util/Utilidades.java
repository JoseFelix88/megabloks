package com.josecuriel.megabloques.model.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.primefaces.model.UploadedFile;

public class Utilidades implements Serializable {

    public String formatearFecha(Date fecha) {

        try {

            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

            String fechaConFormato = formato.format(fecha);

            return fechaConFormato;

        } catch (Exception er) {
        }

        return null;
    }

    public String formatearFechaDMY(Date fecha) {

        try {

            SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");

            String fechaConFormato = formato.format(fecha);

            return fechaConFormato;

        } catch (Exception er) {
        }

        return null;
    }

    public boolean crearDirecctorio(String urlOrigen, String nombreCarpeta) {
        File ruta = new File(urlOrigen);

        if (ruta.isDirectory() != true) {
            File nuevaruta = new File(ruta.getPath() + "/" + nombreCarpeta);
            nuevaruta.mkdirs();
            return true;
        }
        return false;
    }

    public void agregarImagen(UploadedFile uf, String rutaFile,
            String nombre_Archivo, FacesContext facesContext) throws IOException {

        InputStream inputStream = null;
        OutputStream outputStream = null;
        String[] extenciones = {".jpeg", ".png", ".gif", ".tiff", ".bmp"};
        String tipoarchivo = uf.getContentType().replace("image/", ".");

       
        try {
 
            if (uf.getSize() <= 0) {
                lanzarMSJ(facesContext, 3, "Ud. debe seleccionar un archivo de imagen");
                return;
            }
 
            if (uf.getSize() > 2097152) {
                lanzarMSJ(facesContext, 3, "El archivo no puede ser más de 2mb");
                return;
            }

            for (String extencione : extenciones) {
                if (extencione == null ? tipoarchivo == null : extencione.equals(tipoarchivo)) {

                    outputStream = new FileOutputStream(new File(rutaFile + "/" + nombre_Archivo + "" + tipoarchivo));
                    inputStream = uf.getInputstream();
                    int read = 0;
                    byte[] bytes = new byte[1024];

                    while ((read = inputStream.read(bytes)) != -1) {
                        outputStream.write(bytes, 0, read);
                    }

                    lanzarMSJ(facesContext, 1, "Imagen Subida correctamente");

                }
            }
        } catch (Exception ex) {
            lanzarMSJ(facesContext, 4, "Ocurrio un problema al momento de realizar la carga de la imagen,"
                    + " contacta a tu admin: "+ex);
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }

            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    public void lanzarMSJ(FacesContext facesContext, int tipo, String msj) {

        msj = msj.toUpperCase();
        
        if (tipo == 1) {
            facesContext.addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Error fatal:", msj));

        }

        if (tipo == 2) {
            facesContext.addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN, null, msj));

        }

        if (tipo == 3) {
            facesContext.addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, null, msj));

        }

        if (tipo == 4) {
            facesContext.addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, null, msj));
        }
    }
}
