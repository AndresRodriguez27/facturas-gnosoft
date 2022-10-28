/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao.imp;

import Dao.ArticuloDao;
import Vo.ArticuloVo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Conexion;

/**
 *
 * @author Andres
 */
public class ArticuloDao_imp implements ArticuloDao{
    

private static final String INSERT_ARTICULO = "INSERT INTO gnosoftarticulo(articulo_nombre, articulo_cantidad, articulo_precio, factura_id) VALUES (?, ?, ?, ?);";
    private static final String SELECT_ARTICULO = "SELECT * FROM gnosoftarticulo WHERE articulo_id = ?";
    private static final String SELECT_ALL_ARTICULO = "SELECT * FROM gnosoftarticulo";
    private static final String DELETE_ARTICULO = "DELETE FROM gnosoftarticulo WHERE articulo_id = ?;";
    private static final String SELECT_BY_ID_FACTURA = "SELECT * FROM gnosoftarticulo WHERE factura_id = ?;";
    private static final String UPDATE_ARTICULO = "UPDATE gnosoftarticulo SET articulo_nombre = ?, articulo_cantidad = ?, articulo_precio = ?, factura_id = ? WHERE articulo_id = ?;";


private final Conexion con;
    
    public ArticuloDao_imp(Conexion con){
        this.con = con;
    }

  

@Override
    public boolean insert(ArticuloVo articulo) {
        boolean insertado = false;
        try (PreparedStatement preparedStatement = con.preparedStatement(INSERT_ARTICULO)) {
            preparedStatement.setString(1, articulo.getArticulo_nombre());
            preparedStatement.setInt(2, articulo.getArticulo_cantidad());
            preparedStatement.setDouble(3, articulo.getArticulo_precio());
            preparedStatement.setInt(4, articulo.getFactura_id());
            insertado = preparedStatement.executeUpdate()>0;
        } catch (SQLException ex) {
            con.rollback();
            Logger.getLogger(ArticuloDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return insertado;
    }

    @Override
    public List<ArticuloVo> getAll() {
        List< ArticuloVo> articulos = new ArrayList<>();
        try (PreparedStatement preparedStatement = con.preparedStatement(SELECT_ALL_ARTICULO);
                ResultSet rs = preparedStatement.executeQuery()) {
            while (rs.next()) {
                ArticuloVo articulo = new ArticuloVo();
                articulo.setArticulo_nombre(rs.getString("articulo_nombre"));
                articulo.setArticulo_cantidad(rs.getInt("articulo_cantidad"));
                articulo.setArticulo_precio(rs.getDouble("articulo_precio"));
                articulo.setFactura_id(rs.getInt("factura_id"));
                articulos.add(articulo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return articulos;
    }


    @Override
    public boolean update(ArticuloVo articulo) {
        boolean actualizado = false;
        try (PreparedStatement preparedStatement = con.preparedStatement(UPDATE_ARTICULO)) {
            preparedStatement.setString(1, articulo.getArticulo_nombre());
            preparedStatement.setInt(2, articulo.getArticulo_cantidad());
            preparedStatement.setDouble(3, articulo.getArticulo_precio());
            preparedStatement.setInt(4, articulo.getFactura_id());
            preparedStatement.setInt(5, articulo.getArticulo_id());
            actualizado = preparedStatement.executeUpdate()>0;
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return actualizado;
    }


    @Override
    public ArticuloVo getById(Integer id) {
        ArticuloVo articulo = null;
        try (PreparedStatement preparedStatement = con.preparedStatement(SELECT_ARTICULO)) {
            preparedStatement.setInt(1, id);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    articulo = new ArticuloVo();
                    articulo.setArticulo_id(rs.getInt("articulo_id"));
//System.out.println(rs.getInt("articulo_id"));
                    articulo.setArticulo_nombre(rs.getString("articulo_nombre"));
//System.out.println(rs.getString("articulo_nombre"));
                    articulo.setArticulo_cantidad(rs.getInt("articulo_cantidad"));
//System.out.println(rs.getInt("articulo_cantidad"));
                    articulo.setArticulo_precio(rs.getDouble("articulo_precio"));
//System.out.println(rs.getDouble("articulo_precio"));
                    articulo.setFactura_id(rs.getInt("factura_id"));
//System.out.println(rs.getInt("factura_id"));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return articulo;
    }

    @Override
    public boolean delete(Integer id) {
        boolean eliminado = false;
        try (PreparedStatement statement = con.preparedStatement(DELETE_ARTICULO)) {
            statement.setInt(1, id);
            eliminado = statement.executeUpdate()>0;
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return eliminado;
    }
    
    @Override
    public List<ArticuloVo> getByIdFactura(int factura_id) {
        List<ArticuloVo> articulos = new ArrayList<>();
        try (PreparedStatement preparedStatement = con.preparedStatement(SELECT_BY_ID_FACTURA);) {
            preparedStatement.setInt(1, factura_id);

System.out.println(preparedStatement.toString());
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                ArticuloVo articulo = new ArticuloVo();
                articulo.setArticulo_id(rs.getInt("articulo_id"));
//                System.out.println(rs.getInt("articulo_id"));
                articulo.setArticulo_nombre(rs.getString("articulo_nombre"));
//               System.out.println(rs.getString("articulo_nombre"));
                articulo.setArticulo_cantidad(rs.getInt("articulo_cantidad"));
//               System.out.println(rs.getInt("articulo_cantidad"));
                articulo.setArticulo_precio(rs.getDouble("articulo_precio"));
//               System.out.println(rs.getDouble("articulo_precio"));
                articulo.setFactura_id(rs.getInt("factura_id"));
//               System.out.println(rs.getInt("factura_id"));
                articulos.add(articulo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArticuloDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return articulos;
    }


}
