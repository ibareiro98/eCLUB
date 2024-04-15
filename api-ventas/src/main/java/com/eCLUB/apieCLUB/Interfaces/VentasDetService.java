package com.eCLUB.apieCLUB.Interfaces;

import java.util.List;
import com.eCLUB.apieCLUB.entitys.VentasDet;;

public interface VentasDetService {
    public List<VentasDet> findAll();
    public VentasDet save(VentasDet ventasDet);
    public VentasDet findById(Long idVenta);
    public void delete(VentasDet ventasDet);
}
