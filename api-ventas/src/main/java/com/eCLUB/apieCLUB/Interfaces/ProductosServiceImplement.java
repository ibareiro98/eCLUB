package com.eCLUB.apieCLUB.Interfaces;

import com.eCLUB.apieCLUB.entitys.Productos;
import com.eCLUB.apieCLUB.repositorys.ProductosRep;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductosServiceImplement implements ProductosService{

    @Autowired
    private ProductosRep productosRep;
    
    @Override
    @Transactional
    public List<Productos> findAll() {
        return (List<Productos>) productosRep.findAll();        
    }

    @Override
    @Transactional
    public Productos save(Productos productos) {
        return productosRep.save(productos);        
    }

    @Override
    public Productos findById(Long idProductos) {
        return productosRep.findById(idProductos).orElse(null);        
    }

    @Override
    @Transactional
    public void delete(Productos productos) {
        productosRep.delete(productos);        
    }
    
}
