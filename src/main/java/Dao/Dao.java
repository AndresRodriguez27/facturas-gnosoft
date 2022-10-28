/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;
import java.util.List;
/**
 *
 * @author Andres
 */
public interface Dao<T, ID> {
 
T getById(ID id);
    boolean insert(T o);
    boolean update(T o);
    boolean delete(ID id);
    List<T> getAll();
   
}
