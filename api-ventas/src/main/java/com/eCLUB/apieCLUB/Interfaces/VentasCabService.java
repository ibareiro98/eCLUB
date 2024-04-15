package com.eCLUB.apieCLUB.Interfaces;

import java.util.List;
import com.eCLUB.apieCLUB.entitys.VentasCab;;

public interface VentasCabService {
    public List<VentasCab> findAll();
    public VentasCab save(VentasCab ventasCab);
    public VentasCab findById(Long idVenta);
    public void delete(VentasCab ventasCab);
}
