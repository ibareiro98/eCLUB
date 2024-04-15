package com.eCLUB.apieCLUB.Interfaces;

import com.eCLUB.apieCLUB.entitys.Proveedores;
import com.eCLUB.apieCLUB.repositorys.ProveedoresRep;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProveedoresServiceImplement implements ProveedoresService{

    @Autowired
    private ProveedoresRep proveedoresRep;
    
    @Override
    @Transactional
    public List<Proveedores> findAll() {
        return (List<Proveedores>) proveedoresRep.findAll();        
    }

    @Override
    @Transactional
    public Proveedores save(Proveedores productos) {
        return proveedoresRep.save(productos);        
    }

    @Override
    public Proveedores findById(Long idProductos) {
        return proveedoresRep.findById(idProductos).orElse(null);        
    }

    @Override
    @Transactional
    public void delete(Proveedores proveedor) {
        proveedoresRep.delete(proveedor);        
    }
    
}
