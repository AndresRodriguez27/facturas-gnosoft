/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;
import java.util.List;
import Vo.ArticuloVo;
/**
 *
 * @author Andres
 */
public interface ArticuloDao extends Dao<ArticuloVo,Integer> {
    List<ArticuloVo> getByIdFactura(int Factura_Id);





}
