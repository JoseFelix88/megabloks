package com.josecuriel.megabloques.model.produccion;

import com.josecuriel.megabloques.model.producto.ProductoDAO;
import com.josecuriel.megabloques.model.util.Utilidades;
import com.josecuriel.megabloques.model.util.db.CRUD;
import com.josecuriel.megabloques.model.util.db.database;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;

public class ProduccionDAO extends database implements CRUD<Producciones> {

    ProductoDAO productoDAO = new ProductoDAO();
    Utilidades util = new Utilidades();

    @Override
    public boolean create(Producciones c) {

        PreparedStatement ps;
        String sql = "INSERT INTO PRODUCCIONES (FECHAEMISION, COSTOTOTAL, HORAINICIO, "
                + "HORAFINAL, PRODUCTOFINAL,NUMEROLOTE CANTIDADPRODUCCIDA) VALUES (?,?,?,?,?,?,?)";
        try {
            
            ps = getConnection().prepareStatement(sql);
            ps.setDate(1, (Date) util.formatearFecha(util.formatearFecha(c.getFechaemision())));
            
            
            return true;
        } catch (Exception e) {
        }
        
        return false;
    }

    @Override
    public boolean delete(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Producciones c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Producciones read(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Producciones> readAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
