package com.eCLUB.apieCLUB.Interfaces;

import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eCLUB.apieCLUB.entitys.ComprasDet;
import com.eCLUB.apieCLUB.repositorys.ComprasDetRep;

@Service
public class ComprasDetServiceImplement implements ComprasDetService{

    @Autowired
    private ComprasDetRep comprasDetRep;
    
    @Override
    @Transactional
    public List<ComprasDet> findAll() {
        return (List<ComprasDet>) comprasDetRep.findAll();        
    }

    @Override
    @Transactional
    public ComprasDet save(ComprasDet comprasDet) {
        return comprasDetRep.save(comprasDet);        
    }

    @Override
    public ComprasDet findById(Long id_compra) {
        return comprasDetRep.findById(id_compra).orElse(null);        
    }

    @Override
    @Transactional
    public void delete(ComprasDet comprasDet) {
        comprasDetRep.delete(comprasDet);        
    }
    
}
