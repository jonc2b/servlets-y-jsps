
package com.curso.domain.repository;

import com.curso.domain.Producto;
import java.util.List;

public interface ProductoRepository {
    List <Producto> getAllProductos();
    Producto getProducto(String idProducto);
    
    void update(Producto producto);
    
    void create(Producto producto);
    List <Producto> getProductosCategoria(String categoria);
    void delete(String idProducto);
}
