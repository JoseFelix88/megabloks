package com.josecuriel.megabloques.model.producto;

import com.josecuriel.megabloques.model.empleado.EmpleadoDAO;
import com.josecuriel.megabloques.model.producto.categoria.CategoriaDAO;
import com.josecuriel.megabloques.model.util.Generador_de_Codigos;
import com.josecuriel.megabloques.model.util.db.database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.josecuriel.megabloques.model.util.db.CRUD;

public class ProductoDAO extends database implements CRUD<Producto> {

    CategoriaDAO categoria = new CategoriaDAO();
    EmpleadoDAO empleado = new EmpleadoDAO();

    @Override
    public boolean create(Producto c) {
//        System.out.println(""+c.getCodigobarras());
        PreparedStatement ps;
        String sql = "INSERT INTO PRODUCTOS (codigobarras, descripcion, stock_actual, "
                + "stock_minimo, stock_aviso, costo, precio_venta,utilidad,alto,ancho,espesor,peso, estado,"
                + " fechacreacion, categoria, usuariosystem ) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,1,CURDATE(),?,?)";
        boolean insertado = false;
        try {

            ps = getConnection().prepareStatement(sql);
            ps.setString(1, c.getCodigobarras());
            ps.setString(2, c.getDescripcion().toUpperCase());
            ps.setFloat(3, c.getStockActual());
            ps.setFloat(4, c.getStockMinimo());
            ps.setFloat(5, c.getStockAviso());
            ps.setFloat(6, c.getCosto());
            ps.setInt(7, c.getPrecioVenta());
            ps.setInt(8, c.getUtilidad());
            ps.setFloat(9, c.getAlto());
            ps.setFloat(10, c.getAncho());
            ps.setFloat(11, c.getEspesor());
            ps.setFloat(12, c.getPeso());
            ps.setInt(13, c.getCategoria().getIdcategorias());
            ps.setInt(14, 1102819530);
            System.out.println(ps);
            ps.execute();
            insertado = true;
        } catch (Exception e) {
            System.out.println("Error en el momento de insertar Producto: " + e);
        }

        return insertado;
    }

    @Override
    public boolean delete(Object key) {
        return update("PRODUCTOS", "ESTADO = 0", "idproductos = " + key + "");
    }

    @Override
    public boolean update(Producto c) {
        PreparedStatement ps = null;
        String sql = "UPDATE PRODUCTOS SET codigobarras = ?, descripcion = ?, stock_actual = ?, "
                + "stock_minimo = ?, stock_aviso = ?, costo = ?, precio_venta = ?,"
                + "utilidad = ? ,alto = ?,ancho = ?,espesor = ?,peso =? , categoria = ? WHERE idproductos = ?";

        boolean insertado = false;
        try {

            ps = getConnection().prepareStatement(sql);
            ps.setString(1, c.getCodigobarras());
            ps.setString(2, c.getDescripcion().toUpperCase());
            ps.setFloat(3, c.getStockActual());
            ps.setFloat(4, c.getStockMinimo());
            ps.setFloat(5, c.getStockAviso());
            ps.setFloat(6, c.getCosto());
            ps.setInt(7, c.getPrecioVenta());
            ps.setInt(8, c.getUtilidad());
            ps.setFloat(9, c.getAlto());
            ps.setFloat(10, c.getAncho());
            ps.setFloat(11, c.getEspesor());
            ps.setFloat(12, c.getPeso());
            ps.setInt(13, c.getCategoria().getIdcategorias());
            ps.setInt(14, c.getIdproductos());

            System.out.println("ps update " + ps);
            ps.execute();
            insertado = true;
        } catch (Exception e) {
            System.out.println("Error en el momento de actualizar Producto: " + e + "\n" + ps);
        }

        return insertado;
    }

    @Override
    public Producto read(Object key) {
        Producto producto = null;
        PreparedStatement ps;
        ResultSet rs;
        String sql = "SELECT productos.idproductos, productos.codigobarras,\n"
                + "productos.descripcion,productos.stock_actual,\n"
                + "productos.stock_minimo,productos.stock_aviso,\n"
                + "productos.costo,productos.precio_venta,\n"
                + "productos.utilidad,productos.estado,\n"
                + "productos.fechacreacion, productos.categoria,\n"
                + "productos.usuariosystem,alto,ancho,espesor,peso \n"
                + "FROM productos\n"
                + "WHERE productos.idproductos = ?";

        try {
            ps = getConnection().prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(key.toString()));
            rs = ps.executeQuery();
            if (rs.next()) {
                producto = new Producto();
                producto.setIdproductos(rs.getInt("idproductos"));
                producto.setCodigobarras(rs.getString("codigobarras"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setStockActual(rs.getFloat("stock_actual"));
                producto.setStockAviso(rs.getFloat("stock_aviso"));
                producto.setStockMinimo(rs.getFloat("stock_minimo"));
                producto.setCosto(rs.getFloat("costo"));
                producto.setPrecioVenta(rs.getInt("precio_venta"));
                producto.setUtilidad(rs.getInt("utilidad"));
                producto.setEstado(rs.getInt("estado"));
                producto.setFechacreacion(rs.getDate("fechacreacion"));
                producto.setCategoria(categoria.read(rs.getInt("categoria")));
                producto.setEmpleados(empleado.read(rs.getInt("usuarioSystem")));
                producto.setAlto(rs.getFloat("alto"));
                producto.setAncho(rs.getFloat("ancho"));
                producto.setEspesor(rs.getFloat("espesor"));
                producto.setPeso(rs.getFloat("peso"));
            }
        } catch (SQLException e) {
            System.out.println("Error en la consulta del producto: " + e);
        } catch (NumberFormatException e) {
        }

        return producto;
    }

    @Override
    public List<Producto> readAll() {
        List<Producto> list = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        String sql = "SELECT productos.idproductos, productos.codigobarras,\n"
                + "productos.descripcion,productos.stock_actual,\n"
                + "productos.stock_minimo,productos.stock_aviso,\n"
                + "productos.costo,productos.precio_venta,\n"
                + "productos.utilidad,productos.estado,\n"
                + "productos.fechacreacion, productos.categoria,\n"
                + "productos.usuariosystem,alto,ancho,espesor,peso\n"
                + "FROM productos";

        try {
            ps = getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            Producto producto;
            while (rs.next()) {
                producto = new Producto();
                producto.setIdproductos(rs.getInt("idproductos"));
                producto.setCodigobarras(rs.getString("codigobarras"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setStockActual(rs.getFloat("stock_actual"));
                producto.setStockAviso(rs.getFloat("stock_aviso"));
                producto.setStockMinimo(rs.getFloat("stock_minimo"));
                producto.setCosto(rs.getFloat("costo"));
                producto.setPrecioVenta(rs.getInt("precio_venta"));
                producto.setUtilidad(rs.getInt("utilidad"));
                producto.setEstado(rs.getInt("estado"));
                producto.setFechacreacion(rs.getDate("fechacreacion"));
                producto.setCategoria(categoria.read(rs.getInt("categoria")));
                producto.setEmpleados(empleado.read(rs.getInt("usuarioSystem")));
                producto.setAlto(rs.getFloat("alto"));
                producto.setAncho(rs.getFloat("ancho"));
                producto.setEspesor(rs.getFloat("espesor"));
                producto.setPeso(rs.getFloat("peso"));

                list.add(producto);
            }
        } catch (Exception e) {

            System.out.println("error al momento de cargar la lista de productos: " + e);
        }

        return list;
    }

    public boolean CodigoProducto(String codigoenviado) {

        Object[][] rs = select("productos", "codigobarras", "codigobarras = '" + codigoenviado + "'");
        if (rs.length <= 0 || !rs[0][0].equals(codigoenviado)) {
            return true;
        } else {
            return false;
        }

        
    }

}
