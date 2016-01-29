package com.josecuriel.megabloques.model.empleado;

import com.josecuriel.megabloques.model.util.db.database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.josecuriel.megabloques.model.util.db.CRUD;

public class EmpleadoDAO extends database implements CRUD<Empleados> {

    @Override
    public boolean create(Empleados c) {

        PreparedStatement ps;
        String sql = "INSERT INTO EMPLEADOS (idempleados, tipodocumento, nombre1, nombre2,"
                + "apellido1, apellido2, telefono, direccion, email, cargo, departamento, "
                + "tipocontrato, formapago, sueldobase, fechaingreso, estado,"
                + "contraseña) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,curdate(),1,md5(?))";
        try {
            ps = getConnection().prepareStatement(sql);
            ps.setInt(1, c.getIdempleados());
            ps.setString(2, c.getTipodocumento());
            ps.setString(3, c.getNombre1().toUpperCase());
            ps.setString(4, c.getNombre2().toUpperCase());
            ps.setString(5, c.getApellido1().toUpperCase());
            ps.setString(6, c.getApellido2().toUpperCase());
            ps.setString(7, c.getTelefono());
            ps.setString(8, c.getDireccion());
            ps.setString(9, c.getEmail());
            ps.setString(10, c.getCargo());
            ps.setString(11, c.getDepartamento());
            ps.setString(12, c.getTipocontrato());
            ps.setString(13, c.getFormapago());
            ps.setInt(14, c.getSueldobase());
            ps.setString(15, c.getContrasenia());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("error al momento de crear empleado: " + e);
        }
        return false;
    }

    @Override
    public boolean delete(Object key) {
        return update("empleados", "estado = 0, fechasalida = curdate()", "idempleados = " + key + "");
    }

    @Override
    public boolean update(Empleados c) {
        PreparedStatement ps;
        String sql = "UPDATE EMPLEADOS SET tipodocumento = ?, nombre1 = ?, nombre2 = ?,"
                + "apellido1 = ?, apellido2 = ?, telefono = ?, direccion = ?, email = ?,"
                + " cargo = ?, departamento = ?, tipocontrato = ?, formapago = ?, sueldobase = ?,"
                + "contraseña = MD5(?) WHERE idempleados = ?";
        try {
            ps = getConnection().prepareStatement(sql);
            ps.setString(1, c.getTipodocumento());
            ps.setString(2, c.getNombre1().toUpperCase());
            ps.setString(3, c.getNombre2().toUpperCase());
            ps.setString(4, c.getApellido1().toUpperCase());
            ps.setString(5, c.getApellido2().toUpperCase());
            ps.setString(6, c.getTelefono());
            ps.setString(7, c.getDireccion());
            ps.setString(8, c.getEmail());
            ps.setString(9, c.getCargo());
            ps.setString(10, c.getDepartamento());
            ps.setString(11, c.getTipocontrato());
            ps.setString(12, c.getFormapago());
            ps.setInt(13, c.getSueldobase());
            ps.setString(14, c.getContrasenia());
            ps.setInt(15, c.getIdempleados());

            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("error al momento de actualizar empleado: " + e);
        }
        return false;
    }

    @Override
    public Empleados read(Object key) {
        Empleados empleado = null;
        PreparedStatement ps;
        String sql = "SELECT empleados.idempleados, empleados.tipodocumento, empleados.nombre1, empleados.nombre2,\n"
                + "empleados.apellido1, empleados.apellido2, empleados.telefono, empleados.direccion, empleados.email,\n"
                + "empleados.cargo, empleados.departamento, empleados.tipocontrato, empleados.formapago, empleados.sueldobase,\n"
                + "empleados.fechaingreso, empleados.fechasalida, empleados.estado, md5(empleados.`contraseña`) as clave, empleados.huella\n"
                + "FROM empleados WHERE idempleados = ?";
        ResultSet rs;

        try {
            ps = getConnection().prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(key.toString()));
            rs = ps.executeQuery();
            if (rs.next()) {
                empleado = new Empleados();
                empleado.setTipodocumento(rs.getString("tipodocumento"));
                empleado.setIdempleados(rs.getInt("idempleados"));
                empleado.setNombre1(rs.getString("nombre1"));
                empleado.setNombre2(rs.getString("nombre2"));
                empleado.setApellido1(rs.getString("apellido1"));
                empleado.setApellido2(rs.getString("apellido2"));
                empleado.setTelefono(rs.getString("telefono"));
                empleado.setDireccion(rs.getString("direccion"));
                empleado.setEmail(rs.getString("email"));
                empleado.setCargo(rs.getString("cargo"));
                empleado.setDepartamento(rs.getString("departamento"));
                empleado.setTipocontrato(rs.getString("tipocontrato"));
                empleado.setFormapago(rs.getString("formapago"));
                empleado.setSueldobase(rs.getInt("sueldobase"));
                empleado.setFechaingreso(rs.getDate("fechaingreso"));
//                empleado.setFechasalida(rs.getDate("fechasalida"));
                empleado.setEstado(rs.getBoolean("estado"));
                empleado.setContrasenia(rs.getString("clave"));
            }
        } catch (SQLException e) {
            System.out.println("error en el momento de la consulta " + e);
        } catch (NumberFormatException e) {
        }

        return empleado;
    }

    @Override
    public List<Empleados> readAll() {
        List<Empleados> list = new ArrayList<>();
        Empleados empleado;
        PreparedStatement ps;
        String sql = "SELECT empleados.idempleados, empleados.tipodocumento, empleados.nombre1, empleados.nombre2,\n"
                + "empleados.apellido1, empleados.apellido2, empleados.telefono, empleados.direccion, empleados.email,\n"
                + "empleados.cargo, empleados.departamento, empleados.tipocontrato, empleados.formapago, empleados.sueldobase,\n"
                + "empleados.fechaingreso, empleados.fechasalida, empleados.estado, md5(empleados.`contraseña`) as clave, empleados.huella\n"
                + "FROM empleados ";
        ResultSet rs;
        try {
            ps = getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                empleado = new Empleados();
                empleado.setTipodocumento(rs.getString("tipodocumento"));
                empleado.setIdempleados(rs.getInt("idempleados"));
                empleado.setNombre1(rs.getString("nombre1"));
                empleado.setNombre2(rs.getString("nombre2"));
                empleado.setApellido1(rs.getString("apellido1"));
                empleado.setApellido2(rs.getString("apellido2"));
                empleado.setTelefono(rs.getString("telefono"));
                empleado.setDireccion(rs.getString("direccion"));
                empleado.setEmail(rs.getString("email"));
                empleado.setCargo(rs.getString("cargo"));
                empleado.setDepartamento(rs.getString("departamento"));
                empleado.setTipocontrato(rs.getString("tipocontrato"));
                empleado.setFormapago(rs.getString("formapago"));
                empleado.setSueldobase(rs.getInt("sueldobase"));
                empleado.setFechaingreso(rs.getDate("fechaingreso"));
                empleado.setFechasalida(rs.getDate("fechasalida"));
                empleado.setEstado(rs.getBoolean("estado"));
                empleado.setContrasenia(rs.getString("clave"));

                list.add(empleado);
            }
        } catch (SQLException | NumberFormatException e) {
            System.out.println("error al momento de llenar la lista de empleados: " + e);
        }

        return list;
    }

}
