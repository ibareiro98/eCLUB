package com.eCLUB.apieCLUB.Interfaces;

import java.util.List;
import com.eCLUB.apieCLUB.entitys.ComprasCab;;

public interface ComprasCabService {
    public List<ComprasCab> findAll();
    public ComprasCab save(ComprasCab comprasCab);
    public ComprasCab findById(Long idCompra);
    public void delete(ComprasCab comprasCab);
}