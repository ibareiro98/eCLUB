package com.eCLUB.apieCLUB.Interfaces;

import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eCLUB.apieCLUB.entitys.VentasDet;
import com.eCLUB.apieCLUB.repositorys.VentasDetRep;

@Service
public class VentasDetServiceImplement implements VentasDetService{

    @Autowired
    private VentasDetRep ventasDetRep;
    
    @Override
    @Transactional
    public List<VentasDet> findAll() {
        return (List<VentasDet>) ventasDetRep.findAll();        
    }

    @Override
    @Transactional
    public VentasDet save(VentasDet ventasDet) {
        return ventasDetRep.save(ventasDet);        
    }

    @Override
    public VentasDet findById(Long idVenta) {
        return ventasDetRep.findById(idVenta).orElse(null);        
    }

    @Override
    @Transactional
    public void delete(VentasDet ventasDet) {
        ventasDetRep.delete(ventasDet);        
    }
    
}
