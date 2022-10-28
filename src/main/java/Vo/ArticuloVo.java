/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vo;

/**
 *
 * @author Andres
 */
public class ArticuloVo {
    
private int articulo_id;
private String articulo_nombre;
private int articulo_cantidad;
private double articulo_precio;
private int factura_id;

public ArticuloVo(){
}

public ArticuloVo(String articulo_nombre, double articulo_precio, int articulo_cantidad) {
        this.articulo_nombre = articulo_nombre;
        this.articulo_precio = articulo_precio;
        this.articulo_cantidad = articulo_cantidad;
    }
    
    public ArticuloVo(int articulo_id, String articulo_nombre, double articulo_precio, int articulo_cantidad) {
        this.articulo_id = articulo_id;
        this.articulo_nombre = articulo_nombre;
        this.articulo_precio = articulo_precio;
        this.articulo_cantidad = articulo_cantidad;
    }

    public ArticuloVo(int articulo_id, String articulo_nombre, double articulo_precio, int articulo_cantidad, int factura_id) {
       this.articulo_id = articulo_id;
        this.articulo_nombre = articulo_nombre;
        this.articulo_precio = articulo_precio;
        this.articulo_cantidad = articulo_cantidad;
       this.factura_id = factura_id;




    }

    public int getArticulo_id() {
        return articulo_id;
    }

    public void setArticulo_id(int articulo_id) {
        this.articulo_id = articulo_id;
    }

    public String getArticulo_nombre() {
        return articulo_nombre;
    }

    public void setArticulo_nombre(String articulo_nombre) {
        this.articulo_nombre = articulo_nombre;
    }

    public int getArticulo_cantidad() {
        return articulo_cantidad;
    }

    public void setArticulo_cantidad(int articulo_cantidad) {
        this.articulo_cantidad = articulo_cantidad;
    }

    public double getArticulo_precio() {
        return articulo_precio;
    }

    public void setArticulo_precio(double articulo_precio) {
        this.articulo_precio = articulo_precio;
    }

    public int getFactura_id() {
        return factura_id;
    }

    public void setFactura_id(int factura_id) {
        this.factura_id = factura_id;
    }

@Override
    public String toString() {
        return "articulo{" + "articulo_id=" + articulo_id + ", articulo_nombre=" + articulo_nombre + ", articulo_precio=" + articulo_precio + ", articulo_cantidad=" + articulo_cantidad + ", factura_id=" + factura_id + '}';
    }

}
