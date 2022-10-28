/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fachada;

import Mediador.Mediador;
import Vo.FacturaVo;
import java.util.List;

/**
 *
 * @author Andres
 */
public class Fachada {
    
private final Mediador mediador;


public Fachada() {
        mediador = new Mediador();
    }


    public FacturaVo crearFactura(FacturaVo factura){
        return mediador.crearFactura(factura);
    }
    
    public FacturaVo obtenerFactura(int Factura_id){
         return mediador.obtenerFactura(Factura_id);
    }
    
    public List<FacturaVo> ListarFacturas(){
        return mediador.listarFacturas();
    }
    
    public boolean eliminarFactura(int Factura_id){
        return mediador.eliminarFactura(Factura_id);
    }
    
    public boolean actualizarFactura(FacturaVo factura){
        return mediador.modificarFactura(factura);
    }


}
