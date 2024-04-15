package com.eCLUB.apieCLUB.Interfaces;

import java.util.List;
import com.eCLUB.apieCLUB.entitys.Productos;

public interface ProductosService {
    public List<Productos> findAll();
    public Productos save(Productos productos);
    public Productos findById(Long idProductos);
    public void delete(Productos productos);
}
