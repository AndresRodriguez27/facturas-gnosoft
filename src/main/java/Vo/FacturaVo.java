/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Andres
 */
public class FacturaVo {
    
private int factura_id;
private int factura_cliente_id;
private String factura_cliente_nombre;
private Date factura_fecha;
private double factura_subtotal;
private double factura_total;
private static final double factura_iva = 0.19;
private List<ArticuloVo> articulos;

public FacturaVo(){

}

public FacturaVo(int factura_id, int factura_cliente_id, String factura_cliente_nombre ) {
        this.factura_id = factura_id;
        this.factura_cliente_id = factura_cliente_id;
        this.factura_cliente_nombre = factura_cliente_nombre;
        this.articulos = new ArrayList();
    }

    public FacturaVo(int factura_cliente_id, String factura_cliente_nombre) {
        this.factura_cliente_id = factura_cliente_id;
        this.factura_cliente_nombre = factura_cliente_nombre;
        this.factura_fecha = new Date();
        this.factura_subtotal = 0;
        this.factura_total = 0;
        this.articulos = new ArrayList();
    }

    public FacturaVo(int factura_cliente_id, String factura_cliente_nombre, List<ArticuloVo> articulos) {
        this.factura_cliente_id = factura_cliente_id;
        this.factura_cliente_nombre = factura_cliente_nombre;
        this.factura_fecha = new Date();
        this.factura_subtotal = 0;
        this.factura_total = 0;
        this.articulos = articulos;
    }

    public int getFactura_id() {
        return factura_id;
    }

    public void setFactura_id(int factura_id) {
        this.factura_id = factura_id;
    }

    public int getFactura_cliente_id() {
        return factura_cliente_id;
    }

    public void setFactura_cliente_id(int factura_cliente_id) {
        this.factura_cliente_id = factura_cliente_id;
    }

    public String getFactura_cliente_nombre() {
        return factura_cliente_nombre;
    }

    public void setFactura_cliente_nombre(String factura_cliente_nombre) {
        this.factura_cliente_nombre = factura_cliente_nombre;
    }

    public Date getFactura_fecha() {
        return factura_fecha;
    }

    public void setFactura_fecha(Date factura_fecha) {
        this.factura_fecha = factura_fecha;
    }

    public double getFactura_subtotal() {
        return factura_subtotal;
    }

    public void setFactura_subtotal(double factura_subtotal) {
        this.factura_subtotal = factura_subtotal;
    }

    public double getFactura_total() {
        return factura_total;
    }

    public void setFactura_total(double factura_total) {
        this.factura_total = factura_total;
    }

    public List<ArticuloVo> getArticulos() {
        return articulos;
    }

    public void setArticulos(List<ArticuloVo> articulos) {
        this.articulos = articulos;
    }

public void obtenersubtotal(){
factura_subtotal=0;
if(articulos!= null){
articulos.stream().forEach((a) -> { 
factura_subtotal += a.getArticulo_cantidad()*a.getArticulo_precio();
});
}
}

public void obtenertotal(){
factura_total = factura_subtotal + (factura_subtotal * factura_iva);

}

    @Override
    public String toString() {
        return "Factura{" + "factura_id=" + factura_id + ", factura_cliente_id=" + factura_cliente_id + ", factura_fecha=" + factura_fecha + ", factura_subtotal=" + factura_subtotal + ", factura_total=" + factura_total + ", articulos=" + articulos + '}';
    }

}     


