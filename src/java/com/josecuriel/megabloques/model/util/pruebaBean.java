package com.josecuriel.megabloques.model.util;

import com.josecuriel.megabloques.model.empleado.EmpleadoDAO;
import com.josecuriel.megabloques.model.empleado.Empleados;
import com.josecuriel.megabloques.model.producto.Producto;
import com.josecuriel.megabloques.model.producto.ProductoDAO;
import java.util.List;



public class pruebaBean {

    public static void main(String[] args) {

       /* EmpleadoDAO emdao = new EmpleadoDAO();
        System.out.println("idempleado: "+emdao.read(1102819530).getIdempleados());
        List<Empleados> lis = emdao.readAll();
        for (Empleados li : lis) {
            System.out.println("empleado: "+li.getApellido1());
        }*/
        ProductoDAO dAO = new ProductoDAO();

        List<Producto>l = dAO.readAll();
        l.stream().forEach((producto) -> {
            System.out.println(producto.getDescripcion()+" - "+producto.getIdproductos());
        }); 
         
        
        /* List<Categoria> rs = aO.readAll();
        for (Categoria r : rs) {
        System.out.println("categoriaID: "+r.getIdcategorias()+" Descripcion: "+r.getDescripcion());
        }
        /* List<ProductoDTO> rs = dAO.readAll();
        List<Object> list = new ArrayList<>();
        for (ProductoDTO r : rs) {
        list.add(r);
        System.out.println("costo: "+CambiaFormatoTexto.numerico((double)r.getCosto()));
        }
        /*  Utilidades u = new Utilidades();
        Date testdate = new GregorianCalendar().getTime();
        System.out.println(""+u.formatearFecha(testdate));
        AfiliadoDAO dAO = new AfiliadoDAO();
        for (Object[] listarRegimene : dAO.listarRegimenes()) {
        System.out.println("regimen: "+listarRegimene[1]);
        }
        /*OrdenDAO ordenDAO = new  OrdenDAO();
        Object[] rs = ordenDAO.listarProductos();
        List<Object> list = new ArrayList<>();
        for (Object r : rs) {
        list.add(r);
        System.out.println("punto entrega: "+list.get(0));
        }
        LoginDAO dAO = new LoginDAO();
        Object[] credencial = {"1102819530","1102"};
        LoginDTO dTO = dAO.Logear(credencial);
        if ( dTO != null) {
        System.out.println("login: "+dTO.getNombre());
        }else{
        System.out.println("ID. USUARIO O CLAVE SON INCORRECTOS");
        }
        /*   ProductoDAO dAO;
        dAO = new ProductoDAO();
        List<ProductoDTO> listcanal = dAO.CanalPos();
        for (ProductoDTO listcanal1 : listcanal) {
        System.out.println("traigo> "+listcanal1.getCanal());
        }
        LaboratorioDAO dAO;
        dAO = new LaboratorioDAO();
        List<LaboratorioDTO> list = dAO.readAll();
        for (LaboratorioDTO lisdto1 : list) {
        System.out.println("Laboratorio> "+lisdto1.getNombre());
        }
        ProductoDAO dAO = new ProductoDAO();
        ProductoDTO dTO = dAO.read("7706569020567");
        List<ProductoDTO> lista = dAO.CanalPos();
        for (ProductoDTO lista1 : lista) {
        System.out.println("canal : "+lista1.getCanal());
        System.out.println("pos: "+lista1.getPos());
        }*/ /*  System.out.println("Producto: "+lista.getDescripcion()+"\nPresentacion: "+dTO.getPresentacion()+"\n"
        + "laboiratorio: "+dTO.getLaboratorio());
        /*  PacienteDAO pacientedao = new PacienteDAO();
        //        producto.delete("1144");
        PacienteDTO pdto = pacientedao.read("948850");
        System.out.println("Codigo: "+pdto.getDocumento()+" - "
        + "apellidos: "+pdto.getPrimerApellido()+" - nombre: "+pdto.getPrimerNombre()+""
        + " - fecha Nace: "+pdto.getFechaNacimiento()+" - nivel: "+pdto.getNivel()+" "
        + "valor cuota moderadora = "+pdto.getCuotamoderadora());
        List<CiudadDTO> lsciudades = new CiudadDAO().readAll();
        for (CiudadDTO lspacie : lsciudades) {
        System.out.println("ciudades: "+lspacie.getCodigoPunto()+" ");
        }*/
    }

}
