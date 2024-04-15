package com.eCLUB.apieCLUB.Interfaces;

import java.util.List;
import com.eCLUB.apieCLUB.entitys.Clientes;

public interface ClientesServices {
    public List<Clientes> findAll();
    public Clientes save(Clientes clientes);
    public Clientes findById(Long idClientes);
    public void delete(Clientes clientes);
}
