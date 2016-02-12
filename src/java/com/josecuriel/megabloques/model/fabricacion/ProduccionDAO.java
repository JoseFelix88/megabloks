package com.josecuriel.megabloques.model.fabricacion;

import com.josecuriel.megabloques.model.producto.ProductoDAO;
import com.josecuriel.megabloques.model.util.Utilidades;
import com.josecuriel.megabloques.model.util.db.CRUD;
import com.josecuriel.megabloques.model.util.db.database;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProduccionDAO extends database implements CRUD<Producciones> {

    ProductoDAO productoDAO = new ProductoDAO();
    Utilidades util = new Utilidades();

    @Override
    public boolean create(Producciones c) {

        PreparedStatement ps;
        String sql = "INSERT INTO PRODUCCIONES (FECHAFABRICACION, COSTOTOTAL, HORAINICIO, "
                + " PRODUCTOFINAL,NUMEROLOTE, CANTIDADPRODUCCIDA, ESTADO) VALUES (?,?,CURRENT_TIME(),?,?,?,1)";
        try {

            ps = getConnection().prepareStatement(sql);
            ps.setDate(1, (Date) util.formatearFecha(util.formatearFecha(c.getFechafabricacion())));
            ps.setLong(2, c.getCostototal());
            ps.setInt(3, productoDAO.read(c.getProductos().getIdproductos()).getIdproductos());
            ps.setString(4, c.getNumerolote());
            ps.setInt(5, c.getCantidadproducida());

            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error al momento de insertar DATOS DE produccion: \n" + e);
        }

        return false;
    }

    @Override
    public boolean delete(Object key) {
        return Delete("producciones", "idproducciones = " + key + "");
    }

    @Override
    public boolean update(Producciones c) {

        PreparedStatement ps;
        String sql = "UPDATE PRODUCCIONES SET FECHAEMISION = ?, COSTOTOTAL = ?, HORAINICIO = ?, "
                + " PRODUCTOFINAL = ? ,NUMEROLOTE = ?, CANTIDADPRODUCCIDA = ? WHERE IDPRODUCCIONES = ?";
        try {

            ps = getConnection().prepareStatement(sql);
            ps.setDate(1, (Date) util.formatearFecha(util.formatearFecha(c.getFechafabricacion())));
            ps.setLong(2, c.getCostototal());
            ps.setInt(3, productoDAO.read(c.getProductos().getIdproductos()).getIdproductos());
            ps.setString(4, c.getNumerolote());
            ps.setInt(5, c.getCantidadproducida());
            ps.setInt(6, c.getIdproduccion());

            ps.execute();

            return true;
        } catch (Exception e) {
            System.out.println("Error al momento de actualizar DATOS DE produccion: \n" + e);
        }

        return false;
    }

    @Override
    public Producciones read(Object key) {
        Producciones p = null;
        PreparedStatement ps;
        ResultSet rs;
        String sql = "SELECT\n"
                + "producciones.idproducciones,\n"
                + "producciones.fechafabricacion,\n"
                + "producciones.costototal,\n"
                + "producciones.horainicio,\n"
                + "producciones.horafinal,\n"
                + "producciones.numerolote,\n"
                + "producciones.cantidadproducida,\n"
                + "producciones.productofinal,\n"
                + "producciones.estado\n"
                + "FROM `producciones` where producciones.idproducciones = ?";
        try {

            if (key != null) {

                ps = getConnection().prepareStatement(sql);
                ps.setInt(1, Integer.parseInt(key.toString()));

                rs = ps.executeQuery();

                if (rs.next()) {
                    p = new Producciones();
                    p.setIdproduccion(rs.getInt("idproducciones"));
                    p.setFechafabricacion(rs.getDate("fechaemision"));
                    p.setCostototal(rs.getLong("costototal"));
                    p.setHorainicio(rs.getTime("horainicio"));
                    p.setHorafinal(rs.getTime("horafinal"));
                    p.setProductos(productoDAO.read(rs.getObject("productofinal")));
                    p.setNumerolote(rs.getString("numerolote"));
                    p.setCantidadproducida(rs.getInt("cantidadproducida"));
                    p.setEstado(rs.getInt("estado"));

                    return p;
                }
            }
        } catch (SQLException | NumberFormatException e) {
            System.out.println("ERROR AL MOMENTO DE CONSULTAR PRODUCCION: " + e);
        }

        return p;

    }

    @Override
    public List<Producciones> readAll() {
        Producciones p;
        List<Producciones> list = null;
        PreparedStatement ps;
        ResultSet rs;
        String sql = "SELECT\n"
                + "producciones.idproducciones,\n"
                + "producciones.fechafabricacion,\n"
                + "producciones.costototal,\n"
                + "producciones.horainicio,\n"
                + "producciones.horafinal,\n"
                + "producciones.numerolote,\n"
                + "producciones.cantidadproducida,\n"
                + "producciones.productofinal,\n"
                + "producciones.estado\n"
                + "FROM `producciones` ";
        try {

            ps = getConnection().prepareStatement(sql);
            rs = ps.executeQuery();

            list = new ArrayList<>();
            while (rs.next()) {
                p = new Producciones();
                p.setIdproduccion(rs.getInt("idproducciones"));
                p.setFechafabricacion(rs.getDate("fechaemision"));
                p.setCostototal(rs.getLong("costototal"));
                p.setHorainicio(rs.getTime("horainicio"));
                p.setHorafinal(rs.getTime("horafinal"));
                p.setProductos(productoDAO.read(rs.getObject("productofinal")));
                p.setNumerolote(rs.getString("numerolote"));
                p.setCantidadproducida(rs.getInt("cantidadproducida"));
                p.setEstado(rs.getInt("estado"));

                list.add(p);
            }
        } catch (SQLException | NumberFormatException e) {
            System.out.println("ERROR AL MOMENTO DE LISTAR PRODUCCION: " + e);
        }
        return list;
    }
    
    
    public boolean ingresarInsumos(Producciones p){
        
        String values = ""+p.getIdproduccion()+","+p.getDetalleproduccion().getProductos().getIdproductos()+","
                + ""+p.getDetalleproduccion().getCantidad()+","+p.getDetalleproduccion().getProductos().getCosto();
        
        return insert("detalleproduccion", "produccion, insumo, cantidad, costo", values);
    }
    
    public boolean ingresarOperadorProduccion(Producciones p){
        
        String values = ""+p.getIdproduccion()+","+p.getOperadorproduccion().getEmpleados().getIdempleados();
        return insert("operadorproduccion", "empleado, produccion", values);
    }

}
