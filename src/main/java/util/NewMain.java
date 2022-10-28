/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package util;

import Dao.imp.FacturaDao_Imp;
import Dao.imp.ArticuloDao_imp;
import Mediador.Mediador;
import Vo.ArticuloVo;
import Vo.FacturaVo;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andres
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Conexion objetoConexion = new Conexion();

 Mediador m = new Mediador();
 m.obtenerFactura(1);


//FacturaDao_Imp fd = new FacturaDao_Imp(objetoConexion);
//
//System.out.println();

        //       Mediador m = new Mediador();
//        m.listarFacturas().forEach(System.out::println);
        //      FacturaVo f = new FacturaVo();
        //      f.setFactura_cliente_id(1);
        //      f.setFactura_cliente_nombre("Andres");
        //      f.setFactura_subtotal(12.5);
        //      f.setFactura_total(15.2);
        //      f.setArticulos(Arrays.asList());
            ArticuloVo a = new ArticuloVo();
//
//
//            a.setArticulo_nombre("lapiz");
//            a.setArticulo_cantidad(3);
//            a.setArticulo_precio(12.0);
//            a.setFactura_id(2);
//
//            System.out.println(a);



 ArticuloDao_imp am = new ArticuloDao_imp(objetoConexion);
//am.getByIdFactura(1);
//am.getById(4);
//am.update(a);

FacturaDao_Imp fm = new FacturaDao_Imp(objetoConexion);
        
    }

}
