package com.eCLUB.apieCLUB.Interfaces;

import com.eCLUB.apieCLUB.entitys.VentasCab;
import com.eCLUB.apieCLUB.repositorys.VentasCabRep;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentasCabServiceImplement implements VentasCabService{

    @Autowired
    private VentasCabRep ventasCabRep;
    
    @Override
    @Transactional
    public List<VentasCab> findAll() {
        return (List<VentasCab>) ventasCabRep.findAll();        
    }

    @Override
    @Transactional
    public VentasCab save(VentasCab idVenta) {
        return ventasCabRep.save(idVenta);        
    }

    @Override
    public VentasCab findById(Long idVenta) {
        return ventasCabRep.findById(idVenta).orElse(null);        
    }

    @Override
    @Transactional
    public void delete(VentasCab ventasCab) {
        ventasCabRep.delete(ventasCab);        
    }
    
}
