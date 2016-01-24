package com.josecuriel.megabloques.model.producto.categoria;

import com.josecuriel.megabloques.model.util.db.database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.josecuriel.megabloques.model.util.db.CRUD;

public class CategoriaDAO extends database implements CRUD<Categoria> {

    @Override
    public boolean create(Categoria c) {
        return insert("categorias", "descipcion", c.getDescripcion());
    }

    @Override
    public boolean delete(Object key) {

        return Delete("categorias", "idcategorias = " + key + "");
    }

    @Override
    public boolean update(Categoria c) {

        return update("categorias", "descripcion = '" + c.getDescripcion() + "'", "idcategorias = " + c.getIdcategorias() + "");
    }

    @Override
    public Categoria read(Object key) {
        Categoria dto = null;
        Object[][] rs = select("categorias", "idcategorias,descripcion", "idcategorias = " + key + "");
        if (rs.length > 0) {
            dto = new Categoria();
            dto.setIdcategorias(Integer.parseInt(rs[0][0].toString()));
            dto.setDescripcion(String.valueOf(rs[0][1]));
        }

        return dto;
    }

    @Override
    public List<Categoria> readAll() {
        List<Categoria> list = new ArrayList<Categoria>();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = getConnection().prepareStatement("select idcategorias,descripcion from categorias");
            rs = ps.executeQuery();
            Categoria c = null;
            while (rs.next()) {
                c = new Categoria();
                c.setIdcategorias(rs.getInt("idcategorias"));
                c.setDescripcion(rs.getString("descripcion"));
                list.add(c);

            }
        } catch (Exception e) {
        }

        return list;
    }

}
