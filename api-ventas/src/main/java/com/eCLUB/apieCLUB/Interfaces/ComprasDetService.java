package com.eCLUB.apieCLUB.Interfaces;

import java.util.List;
import com.eCLUB.apieCLUB.entitys.ComprasDet;;

public interface ComprasDetService {
    public List<ComprasDet> findAll();
    public ComprasDet save(ComprasDet comprasDet);
    public ComprasDet findById(Long idCompra);
    public void delete(ComprasDet comprasDet);
}