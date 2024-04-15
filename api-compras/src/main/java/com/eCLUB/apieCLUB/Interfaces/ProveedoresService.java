package com.eCLUB.apieCLUB.Interfaces;

import java.util.List;
import com.eCLUB.apieCLUB.entitys.Proveedores;

public interface ProveedoresService {
    public List<Proveedores> findAll();
    public Proveedores save(Proveedores proveedor);
    public Proveedores findById(Long idProveedor);
    public void delete(Proveedores proveedor);
}
