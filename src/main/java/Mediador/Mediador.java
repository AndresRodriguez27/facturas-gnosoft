/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mediador;

import Dao.ArticuloDao;
import Dao.FacturaDao;
import Dao.imp.ArticuloDao_imp;
import Dao.imp.FacturaDao_Imp;
import Vo.ArticuloVo;
import Vo.FacturaVo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import util.Conexion;

/**
 *
 * @author Andres
 */
public class Mediador {
    

public FacturaVo crearFactura(FacturaVo factura) {
        Conexion con = new Conexion();
        FacturaDao facturaDao = new FacturaDao_Imp(con);
        ArticuloDao articuloDao = new ArticuloDao_imp(con);
        try {
            con.setAutoCommit(false);
            factura.obtenersubtotal();
            factura.obtenertotal();
            factura.setFactura_fecha(new Date());
            facturaDao.insert(factura);
            factura.getArticulos().forEach((d) -> {
             d.setFactura_id(factura.getFactura_id());
            articuloDao.insert(d);
            });
            con.commit();
        } catch (SQLException ex) {
            con.rollback();
            System.out.println("Error al crear factura " + factura + " " + ex.getMessage());
        } finally {
            con.close();
        }
        return factura;
    }


    public boolean modificarFactura(FacturaVo factura) {
        boolean modificado = false;

        Conexion con = new Conexion();
        FacturaDao facturaDao = new FacturaDao_Imp(con);
        ArticuloDao articuloDao = new ArticuloDao_imp(con);

        try {

            con.setAutoCommit(false);

            if (factura.getArticulos() != null) {
                factura.getArticulos().forEach((d) -> {
                    articuloDao.update(d);
                });
            }
            
            factura.obtenersubtotal();
            factura.obtenertotal();
            factura.setFactura_fecha(new Date());
            
            modificado = facturaDao.update(factura);

            con.commit();

        } catch (SQLException ex) {
            con.rollback();
            System.out.println("Error al crear factura " + factura + " " + ex.getMessage());
        } finally {
            con.close();
        }
        return modificado;
    }


    public boolean eliminarFactura(int Factura_id) {
        boolean eliminado = false;
        Conexion con = new Conexion();
        FacturaDao facturaDao = new FacturaDao_Imp(con);
        try {
            con.setAutoCommit(false);
            eliminado = facturaDao.delete(Factura_id);
            con.commit();
            return eliminado;
        } catch (SQLException ex) {
            System.out.println("Error al eliminar factura #" + Factura_id + " " + ex.getMessage());
        } finally {
            con.close();
        }
        return eliminado;
    }

public FacturaVo obtenerFactura(int Factura_id) {
        FacturaVo factura = null;
        Conexion con = new Conexion();
        FacturaDao facturaDao = new FacturaDao_Imp(con);
        ArticuloDao articuloDao = new ArticuloDao_imp(con);
        try {
            con.setAutoCommit(false);
            factura = facturaDao.getById(Factura_id);
            if (factura != null) {
                System.out.println(factura.getFactura_id() + "Bandido");

                   List <ArticuloVo> Av = new ArrayList();
                    Av= articuloDao.getByIdFactura(factura.getFactura_id());
                for (ArticuloVo articuloVo : Av) {
                    System.out.println(articuloVo.getArticulo_cantidad() + "Can" );
                     System.out.println(articuloVo.getArticulo_id() + "id");
                     System.out.println(articuloVo.getArticulo_nombre() + "nom");
                     System.out.println(articuloVo.getArticulo_precio() + "valor");
                }
                factura.setArticulos(Av);
            }
            con.commit();
        } catch (SQLException ex) {
            con.rollback();
            System.out.println("Error al obtener factura #" + Factura_id + " " + ex.getMessage());
        }
        return factura;
    }

    public List<FacturaVo> listarFacturas() {
        List<FacturaVo> facturas = null;
        Conexion con = new Conexion();
        FacturaDao facturaDao = new FacturaDao_Imp(con);
        try {
            con.setAutoCommit(false);
            facturas = facturaDao.getAll();
            con.commit();
        } catch (SQLException ex) {
            con.rollback();
            System.out.println("Error al listar facturas " + ex.getMessage());
        } finally {
            con.close();
        }
        return facturas;
    }


}


