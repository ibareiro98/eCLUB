package com.eCLUB.apieCLUB.Interfaces;

import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eCLUB.apieCLUB.entitys.ComprasCab;
import com.eCLUB.apieCLUB.repositorys.ComprasCabRep;

@Service
public class ComprasCabServiceImplement implements ComprasCabService{

    @Autowired
    private ComprasCabRep comprasCabRep;
    
    @Override
    @Transactional
    public List<ComprasCab> findAll() {
        return (List<ComprasCab>) comprasCabRep.findAll();        
    }

    @Override
    @Transactional
    public ComprasCab save(ComprasCab comprasCab) {
        return comprasCabRep.save(comprasCab);        
    }

    @Override
    public ComprasCab findById(Long id_compra) {
        return comprasCabRep.findById(id_compra).orElse(null);        
    }

    @Override
    @Transactional
    public void delete(ComprasCab comprasCab) {
        comprasCabRep.delete(comprasCab);        
    }
    
}
