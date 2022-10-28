/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao.imp;

import Dao.FacturaDao;
import Vo.FacturaVo;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.Conexion;

/**
 *
 * @author Andres
 */
public class FacturaDao_Imp implements FacturaDao{
     

    private static final String INSERT_FACTURA = "INSERT INTO gnosoftfactura (factura_cliente_id, factura_cliente_nombre, factura_fecha, factura_subtotal, factura_total) VALUES (?, ?, ?, ?, ?);";
    private static final String SELECT_FACTURA = "SELECT * FROM gnosoftfactura WHERE factura_id = ?";
    private static final String SELECT_ALL_FACTURAS = "SELECT * FROM gnosoftfactura";
    private static final String DELETE_FACTURA = "DELETE FROM gnosoftfactura WHERE factura_id = ?;";
    private static final String UPDATE_FACTURA = "UPDATE gnosoftfactura SET factura_cliente_id = ?, factura_cliente_nombre =?, factura_fecha = ?, factura_subtotal = ?, factura_total = ? WHERE factura_id = ?;";

    private final Conexion con;

    public FacturaDao_Imp(Conexion con) {
        this.con = con;
    }

    
    @Override
    public FacturaVo getById(Integer id) {

        FacturaVo factura = null;

        try (PreparedStatement preparedStatement = con.preparedStatement(SELECT_FACTURA)) {

            preparedStatement.setInt(1, id);
//           System.out.println(preparedStatement.toString());
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    factura = new FacturaVo();
                    factura.setFactura_id(rs.getInt("factura_id"));
//                    System.out.println(rs.getInt("factura_id"));
                    factura.setFactura_cliente_id(rs.getInt("factura_cliente_id"));
//                    System.out.println(rs.getInt("factura_cliente_id"));
                    factura.setFactura_cliente_nombre(rs.getString("factura_cliente_nombre"));
//                    System.out.println(rs.getString("factura_cliente_nombre"));
                    factura.setFactura_fecha(rs.getDate("factura_fecha"));
//                    System.out.println(rs.getDate("factura_fecha"));
                    factura.setFactura_subtotal(rs.getDouble("factura_subtotal"));
//                    System.out.println(rs.getDouble("factura_subtotal"));
                    factura.setFactura_total(rs.getDouble("factura_total"));
//                    System.out.println(rs.getDouble("factura_total"));
                }
            }
        } catch (SQLException ex) {
            System.out.println("No se pudo obtener la factura #" + factura + " " + ex.getMessage());
        }
        return factura;
    }


    @Override
    public boolean insert(FacturaVo factura) {
        boolean insertado = false;
        try (PreparedStatement preparedStatement = con.preparedStatement(INSERT_FACTURA, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setInt(1, factura.getFactura_cliente_id());
            preparedStatement.setString(2, factura.getFactura_cliente_nombre());
            preparedStatement.setDate(3, new Date(factura.getFactura_fecha().getTime()));
            preparedStatement.setDouble(4, factura.getFactura_subtotal());
            preparedStatement.setDouble(5, factura.getFactura_total());
            insertado = preparedStatement.executeUpdate() > 0;

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

            if (generatedKeys.next()) {
                factura.setFactura_id(generatedKeys.getInt(1));
            }

        } catch (SQLException ex) {
            System.out.println("No se pudo insertar la factura " + factura + " " + ex.getMessage());
        }
        return insertado;
    }


    @Override
    public boolean update(FacturaVo factura) {
        boolean actualizado = false;
        try (PreparedStatement preparedStatement = con.preparedStatement(UPDATE_FACTURA)) {
            preparedStatement.setString(1, factura.getFactura_cliente_nombre());
            preparedStatement.setDate(2, new Date(factura.getFactura_fecha().getTime()));
            preparedStatement.setDouble(3, factura.getFactura_subtotal());
            preparedStatement.setDouble(4, factura.getFactura_total());
            preparedStatement.setInt(5, factura.getFactura_id());
            actualizado = preparedStatement.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println("Error al actualizar la factura  " + factura + " " + ex.getMessage());
        }
        return actualizado;
    }

    @Override
    public boolean delete(Integer id) {
        boolean eliminado = false;
        try (PreparedStatement statement = con.preparedStatement(DELETE_FACTURA)) {
            statement.setInt(1, id);
            eliminado = statement.executeUpdate() > 0;
        } catch (SQLException ex) {
            System.out.println("Error al eliminar la factura  #" + id + " " + ex.getMessage());
        }
        return eliminado;
    }

    @Override
    public List<FacturaVo> getAll() {
        List<FacturaVo> facturas = new ArrayList<>();

        try (PreparedStatement preparedStatement = con.preparedStatement(SELECT_ALL_FACTURAS); ResultSet rs = preparedStatement.executeQuery()) {

            while (rs.next()) {
                FacturaVo factura = new FacturaVo();
                factura.setFactura_id(rs.getInt("factura_id"));
                factura.setFactura_cliente_id(rs.getInt("factura_cliente_id"));
                factura.setFactura_cliente_nombre(rs.getString("factura_cliente_nombre"));
                factura.setFactura_fecha(rs.getDate("factura_fecha"));
                factura.setFactura_subtotal(rs.getDouble("factura_subtotal"));
                factura.setFactura_total(rs.getDouble("factura_total"));

                facturas.add(factura);
            }

        } catch (SQLException ex) {
            System.out.println("Error al obtener las factura  " + ex.getMessage());
        }
        return facturas;
    }

}